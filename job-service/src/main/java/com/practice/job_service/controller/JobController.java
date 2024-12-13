package com.practice.job_service.controller;

import com.practice.job_service.dto.JobDto;
import com.practice.job_service.entity.Job;
import com.practice.job_service.service.JobService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/job")

public class JobController {
    @Autowired
    private JobService jobService;

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JobController.class);
    @GetMapping("/all")
    public List<JobDto> all(){
        return  this.jobService.allJobs();
    }

    @GetMapping("/search")
    public List<JobDto> search(@RequestParam Set<String> skills){
        return  this.jobService.allJobsBySkills(skills);
    }

    @PostMapping("save")
    public Job save(@RequestBody JobDto jobDto){
        log.info("payload received {}",jobDto);
        return this.jobService.saveJob(jobDto);
    }
}
