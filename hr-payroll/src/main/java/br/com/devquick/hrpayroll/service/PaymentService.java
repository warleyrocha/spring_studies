package br.com.devquick.hrpayroll.service;

import br.com.devquick.hrpayroll.entities.Payment;
import br.com.devquick.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public final RestTemplate restTemplate;

    @Value(value = "${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap();
        uriVariables.put("id", workerId.toString());

        Worker worker = restTemplate.getForObject(workerHost + "/{id}", Worker.class, uriVariables);
        return Payment.builder()
                .name(worker.getName())
                .days(days)
                .dailyIncome(worker.getDailyIncome()).build();
    }
}
