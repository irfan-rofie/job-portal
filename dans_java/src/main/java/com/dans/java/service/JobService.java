package com.dans.java.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dans.java.response.JobResponse;

@Service
public class JobService {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String JOBS_API_URL = "https://dev6.dansmultipro.com/api/recruitment/positions.json";
	
	private static final String JOB_API_URL = "https://dev6.dansmultipro.com/api/recruitment/positions";
	
	public List<JobResponse> getJobs() {
		JobResponse[] jobs = restTemplate.getForObject(JOBS_API_URL, JobResponse[].class);
		return Arrays.asList(jobs);
    }
	
	public JobResponse getJob(String id) {
		JobResponse job = restTemplate.getForObject(JOB_API_URL + "/" + id, JobResponse.class);
		return job;
    }
}
