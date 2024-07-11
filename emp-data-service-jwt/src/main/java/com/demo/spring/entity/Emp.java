package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EMP")
@XmlRootElement
public class Emp {
	@Id
	@Column(name = "EMPNO")
	private Integer empId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String city;

	@Column(name = "SALARY")
	private Double salary;

	public Emp() {
	}

	public Emp(Integer empId, String name, String city, Double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
