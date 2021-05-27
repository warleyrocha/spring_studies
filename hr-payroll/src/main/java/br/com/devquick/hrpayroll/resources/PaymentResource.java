package br.com.devquick.hrpayroll.resources;

import br.com.devquick.hrpayroll.entities.Payment;
import br.com.devquick.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getpaymentAlternative")
    @GetMapping("{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> getpaymentAlternative(Long workerId, Integer days) {
        return ResponseEntity.ok(
                Payment.builder().name("Brann").days(days).dailyIncome(BigDecimal.valueOf(400)).build());
    }

}
