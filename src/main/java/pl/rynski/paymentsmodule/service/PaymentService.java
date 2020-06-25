package pl.rynski.paymentsmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.paymentsmodule.entity.PaymentEntity;
import pl.rynski.paymentsmodule.exception.InvalidCostException;
import pl.rynski.paymentsmodule.exception.InvalidReservationIdException;
import pl.rynski.paymentsmodule.model.Payment;
import pl.rynski.paymentsmodule.model.PaymentResult;
import pl.rynski.paymentsmodule.publisher.PaymentResultPublisher;
import pl.rynski.paymentsmodule.repository.PaymentRepository;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentResultPublisher paymentResultPublisher;

    public PaymentService(PaymentRepository paymentRepository, PaymentResultPublisher paymentResultPublisher) {
        this.paymentRepository = paymentRepository;
        this.paymentResultPublisher = paymentResultPublisher;
    }

    public void checkPayment(Payment payment) throws InvalidCostException, InvalidReservationIdException {
        if(payment.getCost() <= 0)
            throw new InvalidCostException();
        if(paymentRepository.existsByReservationId(payment.getReservation_id()))
            throw new InvalidReservationIdException();
        savePayment(payment);
        paymentResultPublisher.insertPaymentResult(getResult(payment));
    }

    private void savePayment(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setReservationId(payment.getReservation_id());
        paymentEntity.setUser_id(payment.getUser_id());
        paymentEntity.setCost(payment.getCost());
        paymentEntity.setLocalDateTime(LocalDateTime.now());
        paymentRepository.save(paymentEntity);
    }

    private PaymentResult getResult(Payment payment) {
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setReservationId(payment.getReservation_id());
        paymentResult.setPaid(true);
        return paymentResult;
    }
}
