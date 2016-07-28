package com.alm.demo.sj.service;

import java.util.ArrayList;

import com.alm.demo.sj.entity.ProjectEvent;




public interface ProjectEventService 
{
	public boolean addProjectEvent(ProjectEvent projectevent)throws Exception;
	public ArrayList<ProjectEvent> getAllProjectEvents()throws Exception;
	ProjectEvent getProjectEvent(int pid)throws Exception;
}