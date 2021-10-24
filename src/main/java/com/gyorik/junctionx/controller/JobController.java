package com.gyorik.junctionx.controller;

import com.gyorik.junctionx.domain.Job;
import com.gyorik.junctionx.exception.JobNotFoundException;
import com.gyorik.junctionx.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private final JobRepository repository;

    JobController(JobRepository repository) {
        this.repository = repository;
    }


    
    // Aggregate root
    // tag::get-aggregate-root[]
    @CrossOrigin
    @GetMapping("/api/jobs")
    List<Job> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @CrossOrigin
    @PostMapping("/api/jobs")
    Job newJob(@RequestBody Job newJob) {
        return repository.save(newJob);
    }

    // Single item

    @CrossOrigin
    @GetMapping("/api/jobs/{id}")
    Job one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/api/jobs/{id}")
    Job replaceJob(@RequestBody Job newJob, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.CopyJob(newJob);
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return repository.save(newJob);
                });
    }

    @CrossOrigin
    @DeleteMapping("/api/jobs/{id}")
    void deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
    }
}