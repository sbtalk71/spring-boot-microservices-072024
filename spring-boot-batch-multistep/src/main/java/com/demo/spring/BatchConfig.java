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
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.WritableResource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {
	
	@Value("http://localhost:8080/emp")
	private UrlResource jsoninput;

	@Value("file:xml/employees.xml")
	private WritableResource output;

	
	@Value("file:xml/employees.xml")
	private Resource input;
	
	

	@Autowired
	DataSource dataSource;

	//JSOn Starts
	
	@Bean
	public ItemReader<Emp> jsonReader() {
		JsonItemReader<Emp> jsonReader= new JsonItemReader<>();
		
		jsonReader.setResource(jsoninput);
		jsonReader.setJsonObjectReader(new JacksonJsonObjectReader<>(Emp.class));
		jsonReader.setName("jsonReader");
		return jsonReader;

	}
	
		
	@Bean
	public ItemWriter<Emp> xmlWriter() {

		return new StaxEventItemWriterBuilder<Emp>().name("empXmlWriter").rootTagName("employees").resource(output)
				.marshaller(marshaller()).overwriteOutput(true).build();
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Emp.class);
		return marshaller;
	}
	
	
	//JSON Ends
	
	//XML Starts
	@Bean
	public ItemReader<Emp> xmlReader() {

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
	public ItemWriter<Emp> dbWriter() {

		return new JdbcBatchItemWriterBuilder<Emp>().dataSource(dataSource)
				.sql("insert into emp(empno, name,address,salary) values(:empId,:name,:city,:salary)")
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>()).build();
	}
	//XML Ends

	@Bean
	public ItemProcessor<Emp, Emp> processor() {
		return new EmpItemProcessor();
	}

	

	@Bean
	
	public Step step1(JobRepository jobRepository, PlatformTransactionManager tx) {
		return new StepBuilder("step1", jobRepository)
				.<Emp, Emp>chunk(2, tx).reader(jsonReader())
				.processor(processor())
				.writer(xmlWriter()).build();

	}
	
	@Bean
	public Step step2(JobRepository jobRepository, PlatformTransactionManager tx) {
		return new StepBuilder("step2", jobRepository)
				.<Emp, Emp>chunk(2, tx).reader(xmlReader())
				.processor(processor())
				.writer(dbWriter()).build();

	}

	@Bean
	public Job xml2mysqlJob(JobRepository jobRepository, @Qualifier("step1")Step step1,@Qualifier("step2")Step step2) {
		return new JobBuilder("multistep-job", jobRepository).start(step1).next(step2).build();
	}

}
