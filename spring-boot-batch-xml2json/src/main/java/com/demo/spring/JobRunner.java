package com.demo.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements CommandLineRunner {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			JobParameters params = new JobParametersBuilder()
					.addString("jobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
			JobExecution je = jobLauncher.run(job, params);
			
			System.out.println(je.getExitStatus());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JOb Failed..");
		}


	}

}
