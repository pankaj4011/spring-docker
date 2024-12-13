package com.practice.job_service.util;

import com.practice.job_service.dto.JobDto;
import com.practice.job_service.entity.Job;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static JobDto todto(Job job){
        JobDto jobDto = new JobDto();
        BeanUtils.copyProperties(job,jobDto);
        jobDto.setHostName(AppUtil.getHostName());
        return jobDto;
    }

    public static Job toEntity(JobDto jobDto){
        Job job = new Job();
        BeanUtils.copyProperties(jobDto,job);
        return job;
    }
}
