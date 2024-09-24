package com.demo.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BatchConfig.class);

		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");

		Job job = (Job) ctx.getBean("firstJob");

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
