package com.demo.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping("/start")
	public String startJob() {
		String resp="";
		try {
			JobParameters params = new JobParametersBuilder()
					.addString("jobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
			JobExecution je = jobLauncher.run(job, params);
			
			resp=je.getExitStatus().getExitDescription();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JOb Failed..");
		}
		
		return resp;
	}
}
