package com.practice.job_service.repository;

import com.practice.job_service.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface JobRepository extends CrudRepository<Job, String> {

    List<Job> findAll();
    List<Job> findBySkillsIn(Set<String> skills);
}
