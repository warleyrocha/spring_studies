package br.com.devquick.hrpayroll.service;

import br.com.devquick.hrpayroll.entities.Payment;
import br.com.devquick.hrpayroll.entities.Worker;
import br.com.devquick.hrpayroll.feing.WorkerFeingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public final WorkerFeingClient workerFeingClient;

    public Payment getPayment(Long workerId, int days) {

        ResponseEntity<Worker> responseWorker = workerFeingClient.findById(workerId);
        if (responseWorker.getStatusCode().is2xxSuccessful()) {
            Worker worker = responseWorker.getBody();
            return Payment.builder()
                    .name(worker.getName())
                    .days(days)
                    .dailyIncome(worker.getDailyIncome()).build();
        }
        return null;
    }
}
