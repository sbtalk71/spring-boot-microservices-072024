package com.demo.spring.util;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseData {
	private String status;

	public ResponseData() {
		// TODO Auto-generated constructor stub
	}
	public ResponseData(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
