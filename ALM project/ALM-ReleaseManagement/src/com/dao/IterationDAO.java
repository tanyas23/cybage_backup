package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.IterationEntity;


public class IterationDAO implements DAOable {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ALM");
	EntityManager em=emf.createEntityManager();

	@Override
	public void insert(Object o) {
		// Write Insert Function here
		  em.getTransaction().begin();
		  //to Insert		
		  em.persist((IterationEntity)o);
		  em.getTransaction().commit();
	}

	@Override
	public void edit(Object o) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		 String updateStatement="UPDATE IterationEntity "
								+ "SET "
								+ "IterationDescription = :IterationDescription, "
								+ "IterationEndDate = :IterationEndDate, "
								+ "IterationItems = :IterationItems, "
								+ "IterationStartDate = :IterationStartDate, "
								+ "IterationStatus = :IterationStatus, "
								+ "IterationType = :IterationType "
								+ "WHERE IterationTitle = :IterationTitle";
		
		Query query = em.createQuery(updateStatement);
		query.setParameter("IterationDescription",((IterationEntity) o).getIterationDescription());
		query.setParameter("IterationStartDate",((IterationEntity) o).getIterationStartDate());
		query.setParameter("IterationEndDate",((IterationEntity) o).getIterationEndDate());
		query.setParameter("IterationItems",((IterationEntity) o).getIterationItems());		
		query.setParameter("IterationStatus",((IterationEntity) o).getIterationStatus());
		query.setParameter("IterationType",((IterationEntity) o).getIterationType());
		query.setParameter("IterationTitle",((IterationEntity) o).getIterationTitle());
		try{
			query.executeUpdate();
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public String displayAll() {
		ArrayList<String> index = new ArrayList<String>();
		ArrayList<String> IterationTitle = new ArrayList<String>();
		ArrayList<String> IterationDescription = new ArrayList<String>();
		ArrayList<String> IterationEndDate = new ArrayList<String>();
		ArrayList<String> IterationItems = new ArrayList<String>();
		ArrayList<String> IterationStartDate = new ArrayList<String>();
		ArrayList<String> IterationStatus = new ArrayList<String>();
		ArrayList<String> IterationType = new ArrayList<String>();
		
		Query query = em.createQuery("select index from IterationEntity");//Use Class Name not table name
		index= (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationTitle from IterationEntity");//Use Class Name not table name
		IterationTitle= (ArrayList<String>) query.getResultList();
		  
		query = em.createQuery("select IterationDescription from IterationEntity");//Use Class Name not table name
		IterationDescription = (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationEndDate from IterationEntity");//Use Class Name not table name
		IterationEndDate = (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationItems from IterationEntity");//Use Class Name not table name
		IterationItems = (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationStartDate from IterationEntity");//Use Class Name not table name
		IterationStartDate = (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationStatus from IterationEntity");//Use Class Name not table name
		IterationStatus = (ArrayList<String>) query.getResultList();
		
		query = em.createQuery("select IterationType from IterationEntity");//Use Class Name not table name
		IterationType = (ArrayList<String>) query.getResultList();		
		
		
		String s ="[";
		for (int j = 0;j< IterationType.size(); j++)
		{	
			s=s+"{";
			s=s+"\"index\":\""+index.get(j)+"\",";
			s=s+"\"Title\":\""+IterationTitle.get(j)+"\",";
			s=s+"\"Discription\":\""+IterationDescription.get(j)+"\",";
			s=s+"\"StartDate\":\""+IterationStartDate.get(j)+"\",";
			s=s+"\"EndDate\":\""+IterationEndDate.get(j)+"\",";
			s=s+"\"Items\":\""+IterationItems.get(j)+"\",";
			s=s+"\"Status\":\""+IterationStatus.get(j)+"\",";
			s=s+"\"Type\":\""+IterationType.get(j)+"\"";
			s=s+"}";
			if(j <(IterationType.size()-1))
			{
				s=s+",";
			}
		}
		s=s+"]";
		return s;
		//return "[{\"firstName\":\"Jason\",\"lastName\":\"Smith\"},{\"firstName\":\"Joan\",\"lastName\":\"Smith\"}]" ;	   
		
	}

}
