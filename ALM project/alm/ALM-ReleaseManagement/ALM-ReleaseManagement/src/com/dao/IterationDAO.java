package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.entities.IterationEntity;

public class IterationDAO implements DAOable {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ALM");
	EntityManager em=emf.createEntityManager();
	@Override
	public void insert(Object o) {
		// Write Insert Function here
		em.getTransaction().begin();
		  //to Insert
		  ((IterationEntity) o).setTitle("1");
		  ((IterationEntity) o).setDescription("2");
		  ((IterationEntity) o).setStartDate("3");
		  ((IterationEntity) o).setEndDate("4");
		  ((IterationEntity) o).setItems("5");
		  ((IterationEntity) o).setStatus("6");
		  ((IterationEntity) o).setType("7");	  
		  em.persist(o);
		  em.getTransaction().commit();
	}

	@Override
	public void edit(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		
	}

}
