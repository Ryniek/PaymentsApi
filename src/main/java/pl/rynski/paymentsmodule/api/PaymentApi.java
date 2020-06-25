package pl.rynski.paymentsmodule.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rynski.paymentsmodule.entity.PaymentEntity;
import pl.rynski.paymentsmodule.service.PaymentApiService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentApi {

    private PaymentApiService paymentApiService;

    @Autowired
    public PaymentApi(PaymentApiService paymentApiService) {
        this.paymentApiService = paymentApiService;
    }

    @GetMapping()
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> payments = paymentApiService.getAllPayments();
        if(payments != null) {
            return new ResponseEntity<>(payments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable Long id) {
        Optional<PaymentEntity> payment = paymentApiService.getPaymentById(id);
        if(payment.isPresent()) {
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
