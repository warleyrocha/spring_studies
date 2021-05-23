package br.com.devquick.hrpayroll.service;

import br.com.devquick.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return Payment.builder().name("Bob").days(days).dailyIncome(BigDecimal.TEN).build();
    }
}
