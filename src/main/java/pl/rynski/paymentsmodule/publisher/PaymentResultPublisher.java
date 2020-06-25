package pl.rynski.paymentsmodule.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rynski.paymentsmodule.model.PaymentResult;

@Service
public class PaymentResultPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void insertPaymentResult(PaymentResult payment) {
        rabbitTemplate.convertAndSend("resultOfPayment", payment);
    }
}
