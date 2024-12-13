package com.practice.candidate_service.repository;

import com.practice.candidate_service.entity.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, String> {
    List<Candidate> findAll();
}
