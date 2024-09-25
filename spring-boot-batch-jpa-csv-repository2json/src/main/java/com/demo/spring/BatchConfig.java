package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

	
	@Autowired
	DataSource dataSource;
	
	@Value("classpath:input/employees.csv")
	private Resource input;
	
	@Autowired
	EmpItemProcessor itemProcessor;

	@Bean
	public ItemReader<Integer> itemReader() {

		FlatFileItemReader<Integer> reader = new FlatFileItemReader<>();
		reader.setResource(input);

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
		tokenizer.setNames("empId");

		DefaultLineMapper<Integer> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(new LineToIntegerMapper());

		reader.setLineMapper(lineMapper);
		return reader;
				

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
				.<Integer, Emp>chunk(2, tx)
				.reader(itemReader())
				.processor(itemProcessor)
				.writer(itemWriter())
				.faultTolerant()
				//.retry(RuntimeException.class)
				//.retryLimit(3)
				.skip(RuntimeException.class)
				.skipLimit(2)
				.build();

	}

	@Bean
	public Job xml2mysqlJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("xml2json", jobRepository).start(step1).build();
	}

}
