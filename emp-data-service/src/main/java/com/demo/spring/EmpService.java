package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repositories.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;

	public List<Emp> listAll() {
		return empRepository.findAll();
	}

	public Optional<Emp> findOneById(int id) {
		Optional<Emp> empOp = empRepository.findById(id);
		return empOp;
	}

	public Emp findOneByIdAlt(int id) throws EmpNotFoundException {
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return empOp.get();
		} else {
			throw new EmpNotFoundException("Emp Not Found with id" + id);
		}
	}

	public Emp save(Emp e) throws EmpExistsException {

		if (empRepository.existsById(e.getEmpId())) {
			throw new EmpExistsException("Emp Exists with id " + e.getEmpId());
		} else {
			Emp emp = empRepository.save(e);
			return emp;
		}
	}
	
	public String remove(int id) throws EmpNotFoundException{
		
		if(empRepository.existsById(id)) {
				empRepository.deleteById(id);
				
			}else {
				throw new EmpNotFoundException("Emp Not found with id "+id);
			}
			
			return "Deleted Emp";
		
	}
	
	
	public int addBonusToEmp(int id,double amount) throws EmpNotFoundException {
		int count=0;
		if (empRepository.existsById(id)) {
			count=empRepository.addBonus(id, amount);
		} else {
			throw new EmpNotFoundException("EMp Not found with id "+id);
			
		}
		return count;
	}
}
