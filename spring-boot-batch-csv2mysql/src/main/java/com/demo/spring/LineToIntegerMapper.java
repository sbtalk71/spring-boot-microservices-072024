package com.demo.spring;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class LineToIntegerMapper implements FieldSetMapper<Integer> {

	@Override
	public Integer mapFieldSet(FieldSet fieldSet) throws BindException {
		
		return fieldSet.readInt("empId");
	}

}
