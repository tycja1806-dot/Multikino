package org.example.multikino.workers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/workers")

public class WorkerController {
private final WorkerService workerService;

@GetMapping
@ResponseStatus(HttpStatus.OK)
  public List<WorkerResponse> getAllWorkers(){
return workerService.findAllWorkers();
}

@GetMapping("/{id}")
@ ResponseStatus(HttpStatus.OK)
  public WorkerResponse findWorkerById(@PathVariable long id){
  return workerService.getWorkerById(id);
}

@PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorkerResponse createWorker(@RequestBody @Valid WorkerRequest workerRequest){
  return workerService.createWorker(workerRequest);
}

@DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWorker(@PathVariable long id){
  workerService.deleteWorker (id);
}

@PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public WorkerResponse updateWorker(@PathVariable long id, @RequestBody WorkerPatch workerPatch){
    return workerService.updateWorker(id, workerPatch);
}





}
