package com.practice.candidate_service.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class CandidateDto {

    private String id;
    private String name;
    private Set<String> skills;
    private String hostName;
}
