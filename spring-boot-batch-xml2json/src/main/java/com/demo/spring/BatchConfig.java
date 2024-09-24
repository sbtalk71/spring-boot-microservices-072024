package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

	@Value("classpath:input/employees.xml")
	private Resource input;

	@Autowired
	DataSource dataSource;

	@Bean
	public ItemReader<Emp> itemReader() {

		return new StaxEventItemReaderBuilder<Emp>()
				.name("xmlreader").resource(input)
				.addFragmentRootElements("emp")
				.unmarshaller(myunmarshaller()).build();

	}

	public Unmarshaller myunmarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Emp.class);
		return marshaller;

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
		return new StepBuilder("step1", jobRepository).<Emp, Emp>chunk(2, tx).reader(itemReader())
				.processor(processor()).writer(itemWriter()).build();

	}

	@Bean
	public Job xml2mysqlJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("xml2json", jobRepository).start(step1).build();
	}

}
