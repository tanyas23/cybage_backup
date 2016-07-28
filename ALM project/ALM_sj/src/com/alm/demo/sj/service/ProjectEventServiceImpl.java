package com.alm.demo.sj.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alm.demo.sj.dao.ProjectEventDao;
import com.alm.demo.sj.entity.ProjectEvent;




@Service
public class ProjectEventServiceImpl implements ProjectEventService
{
	@Autowired
	private ProjectEventDao projectEventDao;
	@Override
	@Transactional
	public boolean addProjectEvent(ProjectEvent projectevent)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in add service");
		return projectEventDao.addProjectEvent(projectevent);
	}
	@Override
	@Transactional
	public ArrayList<ProjectEvent> getAllProjectEvents() throws Exception{
		// TODO Auto-generated method stub
		return projectEventDao.getAllProjectEvents();
	}
	@Override
	@Transactional
	public ProjectEvent getProjectEvent(int pid) throws Exception{
		// TODO Auto-generated method stub
		return projectEventDao.getProjectEvent(pid);
	}
}