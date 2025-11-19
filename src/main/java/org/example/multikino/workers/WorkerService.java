package org.example.multikino.workers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class WorkerService {
  private final WorkerRepository workerRepository;
  private final Set<String> allRoles = Set.of("kasjer", "ochroniarz", "kierownik");

  private static void validateName(String name) {
    boolean bSpace = false;
    for (char c : name.toCharArray()) {
      if (c == ' ') {
        if (bSpace) {
          throw new IllegalArgumentException("Za duzo spacji");
        }
        bSpace = true;
        continue;
      }
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("Imie i nazwisko moze zawierac tylko litery");
      }
    }
  }

  public List<WorkerResponse> findAllWorkers() {
    return workerRepository.findAll().stream().map(this::mapToWorkerResponse).toList();
  }

  private WorkerResponse mapToWorkerResponse(Worker worker) {
    return new WorkerResponse(worker.getId(), worker.getName(), worker.getRole());
  }

  public WorkerResponse getWorkerById(long id) {
    return workerRepository.findById(id).map(this::mapToWorkerResponse).
        orElseThrow(() -> new EntityNotFoundException("Brak pracownika o wskazanym ID"));
  }

  public WorkerResponse createWorker(@Valid WorkerRequest workerRequest) {
    Worker w1 = new Worker();
    String name = workerRequest.name().trim();
    validateName(name);
    w1.setName(workerRequest.name());
    validateRole(workerRequest.role().trim());
    w1.setRole(workerRequest.role().trim());
    w1 = workerRepository.save(w1);
    return mapToWorkerResponse(w1);
  }

  private void validateRole(String role) {
    if (!allRoles.contains(role)) {
      throw new IllegalArgumentException("zła rola pracownika");

    }
  }

  public void deleteWorker(long id) {
    if (!workerRepository.existsById(id)) {
      throw new EntityNotFoundException("Brak pracownika o wskazanym id");
    }
    workerRepository.deleteById(id);
  }

  public WorkerResponse updateWorker(long id, WorkerPatch workerPatch) {
    Worker w1 = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Brak pracownika o wskazanym id"));
    if (workerPatch.role() != null) {
      String role = workerPatch.role().trim();
      validateRole(role);
      w1.setRole(role);
    }
    if (workerPatch.name() != null) {
      String name = workerPatch.name().trim();
      validateName(name);
      w1.setName(name);
    }
    w1 = workerRepository.save(w1);
    return mapToWorkerResponse(w1);
  }
}

