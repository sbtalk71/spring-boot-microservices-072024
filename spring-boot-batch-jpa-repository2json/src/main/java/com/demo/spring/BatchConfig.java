package com.demo.spring;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	EmpRepository empRepository;

	@Bean
	public ItemReader<Emp> itemReader() {

		Map<String, Direction> map= new HashMap<>();
		map.put("name", Direction.ASC);
		
		return new RepositoryItemReaderBuilder<Emp>()
				.name("RepoReader")
				.repository(empRepository)
				.methodName("findAll")
				.pageSize(3)
				.sorts(map)
				.build();
				

	}

	

	@Bean
	public ItemProcessor<Emp, Emp> processor() {
		return new EmpItemProcessor();
	}

	@Bean
	public ItemWriter<Emp> itemWriter() {
		return new JsonFileItemWriterBuilder<Emp>()
				.name("jsonFileWriter")
				.resource(new FileSystemResource("employees.json"))
				.jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
				.shouldDeleteIfExists(true)
				.build();	
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager tx) {
		return new StepBuilder("step1", jobRepository)
				.<Emp, Emp>chunk(2, tx)
				.reader(itemReader())
				.processor(processor())
				.writer(itemWriter())
				.build();

	}

	@Bean
	public Job xml2mysqlJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("xml2json", jobRepository).start(step1).build();
	}

}
