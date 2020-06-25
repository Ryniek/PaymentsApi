package pl.rynski.paymentsmodule.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.paymentsmodule.exception.InvalidCostException;
import pl.rynski.paymentsmodule.exception.InvalidReservationIdException;
import pl.rynski.paymentsmodule.model.Payment;
import pl.rynski.paymentsmodule.service.PaymentService;



@Service
public class PaymentConsumer {

    private Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
    private PaymentService paymentService;

    @Autowired
    public PaymentConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RabbitListener(queues = "payment")
    public void fetchPayment(Payment payment) {
        try {
            paymentService.checkPayment(payment);
            System.out.println(payment);
        } catch (InvalidCostException e) {
            logger.error(e.getMessage());
        } catch (InvalidReservationIdException e) {
            logger.error(e.getMessage());
        }
    }


}
