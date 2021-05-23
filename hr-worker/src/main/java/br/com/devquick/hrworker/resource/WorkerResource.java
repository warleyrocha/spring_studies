package br.com.devquick.hrworker.resource;

import br.com.devquick.hrworker.entities.Worker;
import br.com.devquick.hrworker.service.WorkerService;
import br.com.devquick.hrworker.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "worker")
@RequiredArgsConstructor
public class WorkerResource {

    private final WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(workerService.findById(id));
    }
}
