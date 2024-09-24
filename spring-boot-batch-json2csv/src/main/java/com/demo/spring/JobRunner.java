package com.demo.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobRunner  {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	
	@Scheduled(fixedRate = 60000)
	public void run() throws Exception {
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
