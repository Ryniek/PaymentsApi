package pl.rynski.paymentsmodule;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.rynski.paymentsmodule.publisher.PaymentResultPublisher;

@SpringBootApplication
public class PaymentsModuleApplication {

    @Autowired
    private PaymentResultPublisher paymentResultPublisher;

    public static void main(String[] args) {
        SpringApplication.run(PaymentsModuleApplication.class, args);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

/*    @EventListener(ApplicationReadyEvent.class)
    public void lala() {
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setPaid(false);
        paymentResult.setReservationId(1L);
        paymentResultPublisher.insertPayment(paymentResult);
    }*/
}
