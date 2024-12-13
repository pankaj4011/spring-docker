package com.practice.candidate_service.service;

import com.practice.candidate_service.client.JobClient;
import com.practice.candidate_service.dto.CandidateDetailsDto;
import com.practice.candidate_service.dto.CandidateDto;
import com.practice.candidate_service.entity.Candidate;
import com.practice.candidate_service.repository.CandidateRepository;
import com.practice.candidate_service.util.EntityDtoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repository;

    @Autowired
    private JobClient client;

    private static  final Logger log = LoggerFactory.getLogger(CandidateService.class);

    public List<CandidateDto> getAllCandidates(){
       return  this.repository.findAll().stream().map(EntityDtoUtil::toDto).toList();
    }

    private CandidateDetailsDto addRecommendedJobs(CandidateDetailsDto detailsDto) throws URISyntaxException {
          detailsDto.setRecommendedJobs(this.client.getRecommendedJobs(detailsDto.getSkills()));
          return detailsDto;
    }

    public CandidateDetailsDto getCandidate(String id){
        Optional<CandidateDetailsDto> optional = this.repository.findById(id).map(EntityDtoUtil::toDetailsDto)
                .map(detailsDto -> {
                    try {
                        return addRecommendedJobs(detailsDto);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                });
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw  new RuntimeException("ID not found");
        }

    }

    public CandidateDto addNewCandidate(CandidateDto candidateDto){
        Candidate candidate = EntityDtoUtil.toEntity(candidateDto);
        return  EntityDtoUtil.toDto(this.repository.save(candidate));
    }
}
