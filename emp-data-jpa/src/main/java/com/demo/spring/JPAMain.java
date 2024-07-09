package com.demo.spring;

import com.demo.spring.entity.Emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mariadb");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Emp emp = new Emp(120, "Sumant", "Ranchi", 67000);

			em.persist(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
