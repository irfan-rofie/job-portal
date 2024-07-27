package com.dans.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dans.java.response.JobResponse;
import com.dans.java.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
    private JobService jobService;
	
	@GetMapping()
	public ResponseEntity<List<JobResponse>> getJobs() {
		List<JobResponse> jobs = jobService.getJobs();
		return ResponseEntity.ok(jobs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobResponse> getJob(@PathVariable String id) {
		JobResponse job = jobService.getJob(id);
		return ResponseEntity.ok(job);
	}
}
