package br.com.devquick.hrpayroll.feing;

import br.com.devquick.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/worker")
public interface WorkerFeingClient {

    @GetMapping("{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
