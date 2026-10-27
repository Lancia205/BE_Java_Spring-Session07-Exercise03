
package com.example.session07.controller;

import com.example.session07.dto.CandidateCreateDTO;
import com.example.session07.entity.Candidate;
import com.example.session07.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.session07.dto.ApiResponse;
import com.example.session07.dto.CandidateUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository repository;

    public CandidateController(CandidateRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Candidate create(@Valid @RequestBody CandidateCreateDTO dto) {
        Candidate candidate = new Candidate();
        candidate.setFullName(dto.getFullName());
        candidate.setEmail(dto.getEmail());
        candidate.setAge(dto.getAge());
        candidate.setYearsOfExperience(dto.getYearsOfExperience());

        return repository.save(candidate);
    }

    @PutMapping("/update/{id}")
    public Candidate update(
            @PathVariable Integer id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        Candidate candidate = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy ứng viên"));
        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return repository.save(candidate);
    }
}
