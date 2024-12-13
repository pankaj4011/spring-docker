package com.practice.candidate_service.util;

import com.practice.candidate_service.dto.CandidateDetailsDto;
import com.practice.candidate_service.dto.CandidateDto;
import com.practice.candidate_service.entity.Candidate;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static CandidateDto toDto(Candidate candidate){
        CandidateDto candidateDto = new CandidateDto();
        BeanUtils.copyProperties(candidate,candidateDto);
        candidateDto.setHostName(AppUtil.getHostName());
        return candidateDto;
    }

    public static CandidateDetailsDto toDetailsDto(Candidate candidate){
        CandidateDetailsDto detailsDto = new CandidateDetailsDto();
        BeanUtils.copyProperties(candidate,detailsDto);
        detailsDto.setHostName(AppUtil.getHostName());
        return detailsDto;
    }

    public static Candidate toEntity(CandidateDto candidateDto){
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDto,candidate);
        return candidate;
    }
}
