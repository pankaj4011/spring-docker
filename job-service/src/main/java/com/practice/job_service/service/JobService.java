package com.practice.job_service.service;

import com.practice.job_service.dto.JobDto;
import com.practice.job_service.entity.Job;
import com.practice.job_service.repository.JobRepository;
import com.practice.job_service.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public List<JobDto> allJobs(){
         return jobRepository.findAll().stream().map(EntityDtoUtil::todto).toList();
    }
    public List<JobDto> allJobsBySkills(Set<String> skills){
        return this.jobRepository.findBySkillsIn(skills).stream().map(EntityDtoUtil::todto).toList();
    }
    public Job saveJob(JobDto jobDto){
            Job job = EntityDtoUtil.toEntity(jobDto);
            return  this.jobRepository.save(job);
    }
}
