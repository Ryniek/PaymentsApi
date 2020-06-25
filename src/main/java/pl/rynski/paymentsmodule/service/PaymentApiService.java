package pl.rynski.paymentsmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.paymentsmodule.entity.PaymentEntity;
import pl.rynski.paymentsmodule.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentApiService {

    private PaymentRepository paymentRepository;

    @Autowired

    public PaymentApiService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<PaymentEntity> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
}
