package com.practice.candidate_service.controller;

import com.practice.candidate_service.dto.CandidateDetailsDto;
import com.practice.candidate_service.dto.CandidateDto;
import com.practice.candidate_service.entity.Candidate;
import com.practice.candidate_service.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public List<CandidateDto> getAllCandidates(){
        return candidateService.getAllCandidates();
    }

    @GetMapping("{id}")
    public CandidateDetailsDto getCandidateById(@PathVariable String id){
        return candidateService.getCandidate(id);
    }

    @PostMapping
    public CandidateDto addNewCandidate(@RequestBody CandidateDto candidateDto){
        return candidateService.addNewCandidate(candidateDto);
        }
}
