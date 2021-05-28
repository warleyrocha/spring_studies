package br.com.devquick.hrworker.resource;

import br.com.devquick.hrworker.entities.Worker;
import br.com.devquick.hrworker.service.WorkerService;
import br.com.devquick.hrworker.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "worker")
@RequiredArgsConstructor
@Log4j2
public class WorkerResource {

    private final WorkerService workerService;

    private final Environment env;

    @Value("${test.config}")
    private String testConfig;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        log.info("PORT = " + env.getProperty("local.server.port"));
        return ResponseUtil.wrapOrNotFound(workerService.findById(id));
    }

    @GetMapping("/configs")
    public ResponseEntity getConfigs() {
        log.info("Config = " + testConfig);
        return ResponseEntity.noContent().build();
    }

}
