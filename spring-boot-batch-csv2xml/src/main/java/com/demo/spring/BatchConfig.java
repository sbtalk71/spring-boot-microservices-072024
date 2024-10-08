package com.demo.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

	@Value("classpath:input/employees.csv")
	private Resource input;

	@Value("file:xml/employees.xml")
	private WritableResource output;

	@Bean
	public ItemReader<Emp> itemReader() {

		FlatFileItemReader<Emp> reader = new FlatFileItemReader<>();
		reader.setResource(input);

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
		tokenizer.setNames("empId", "name", "city", "salary");

		DefaultLineMapper<Emp> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(new LineToEmpMapper());

		reader.setLineMapper(lineMapper);
		return reader;

	}

	@Bean
	public ItemProcessor<Emp, Emp> processor() {
		return new EmpItemProcessor();
	}

	@Bean
	public ItemWriter<Emp> itemWriter() {

		return new StaxEventItemWriterBuilder<Emp>().name("empXmlWriter").rootTagName("employees").resource(output)
				.marshaller(marshaller()).overwriteOutput(true).build();
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Emp.class);
		return marshaller;
	}
	
	@Bean
	public Step step1(JobRepository jobRepository,PlatformTransactionManager tx) {
		return new StepBuilder("step1",jobRepository)
				.<Emp,Emp>chunk(2, tx)
				.reader(itemReader())
				.processor(processor())
				.writer(itemWriter())
				.build();
				
	}
	
	@Bean
	public Job csv2xmlJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("csv2xmlJob", jobRepository).start(step1).build();
	}

}
