package com.alm.demo.sj.dao;

import java.util.ArrayList;




public interface ProjectEventDao 
{
	public boolean addProjectEvent(com.alm.demo.sj.entity.ProjectEvent projectevent) throws Exception;
	public ArrayList<com.alm.demo.sj.entity.ProjectEvent> getAllProjectEvents() throws Exception;
	public com.alm.demo.sj.entity.ProjectEvent getProjectEvent(int pid)throws Exception;
}
