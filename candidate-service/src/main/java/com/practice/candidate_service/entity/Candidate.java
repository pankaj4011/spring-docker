package com.practice.candidate_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Document
public class Candidate {
    @Id
    private String id;
    private String name;
    private Set<String> skills;
}
