package com.practice.candidate_service.client;

import com.practice.candidate_service.dto.JobDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@Service
public class JobClient {
    @Autowired
    private  RestTemplate restTemplate;
    private static  final Logger log = LoggerFactory.getLogger(JobClient.class);

    @Value("${job.service.url}")
    private String url;

    public List<JobDto> getRecommendedJobs(Set<String> skills) throws URISyntaxException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(new URI(url))
                .path("search")
                .queryParam("skills",skills);
        log.info("final Url "+builder.toUriString());
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<JobDto>>(){}).getBody();

    }
}
