package br.com.devquick.hrworker.service;

import br.com.devquick.hrworker.entities.Worker;
import br.com.devquick.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Optional<Worker> findById(Long id) {
        return workerRepository.findById(id);
    }
}
