package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReleaseDAO implements DAOable {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ALM");
	EntityManager em=emf.createEntityManager();
	
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
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
