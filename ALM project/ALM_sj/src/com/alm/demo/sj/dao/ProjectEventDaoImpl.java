package com.alm.demo.sj.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alm.demo.sj.entity.ProjectEvent;




@Repository
public class ProjectEventDaoImpl implements ProjectEventDao
{
	@PersistenceContext
	@Autowired
	private EntityManager emf;

	@Override
	public boolean addProjectEvent(ProjectEvent projectevent) throws Exception{
		System.out.println("in add dao");
		emf.persist(projectevent);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ProjectEvent> getAllProjectEvents() throws Exception{
		// TODO Auto-generated method stub
		return (ArrayList<ProjectEvent>) emf.createQuery("SELECT pe FROM ProjectEvent pe" ).getResultList();
	}

	@Override
	public ProjectEvent getProjectEvent(int pid) throws Exception{
		return (ProjectEvent) emf.createQuery("SELECT pevt FROM ProjectEvent pevt WHERE pevt.peventid=:peventid").
					
					setParameter("peventid", pid).getSingleResult();
	}
}
