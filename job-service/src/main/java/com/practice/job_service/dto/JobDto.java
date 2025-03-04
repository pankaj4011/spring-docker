package com.practice.job_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class JobDto {

    private String id;

    private String description;

    private String company;

    private Set<String> skills;

    private Integer salary;

    private Boolean isRemote;

    private String hostName;
}
