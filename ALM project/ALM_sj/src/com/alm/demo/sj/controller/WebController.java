package com.alm.demo.sj.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alm.demo.sj.AllException;
import com.alm.demo.sj.service.ProjectEventService;
import com.alm.demo.sj.service.ProjectEventServiceImpl;


@Controller
public class WebController 
{
	
	@Autowired
	private ProjectEventService projectEventService;
	//private ProjectEventServiceImpl projectEventService;
	
	public ProjectEventService getProjectEventService() {
		return projectEventService;
	}
	public void setProjectEventService(ProjectEventServiceImpl projectEventService) {
		this.projectEventService = projectEventService;
	}
	@RequestMapping(value="/projectEvent", method=RequestMethod.POST)
	public String submitProjectEvent(@RequestBody com.alm.demo.sj.entity.ProjectEvent projectEvent) throws Exception
	{
		System.out.println("enter here");
		System.out.println(projectEvent);
		projectEventService.addProjectEvent(projectEvent);
		return "";
	}
	@RequestMapping(value="/projectEventsAll", method=RequestMethod.GET)
	public @ResponseBody ArrayList<com.alm.demo.sj.entity.ProjectEvent> getProjectEvents() throws NumberFormatException, Exception 
	{		
		System.out.println("why here also");
		 ArrayList<com.alm.demo.sj.entity.ProjectEvent> temp=projectEventService.getAllProjectEvents();
			if(temp!=null)
			{
				return temp;
			}
			else
			{
				throw new Exception("ID not Found");
			}
	}
	@RequestMapping(value="/projectEvent/{id}", method=RequestMethod.GET)
	public @ResponseBody com.alm.demo.sj.entity.ProjectEvent getProjectEvent(@PathVariable("id") String id) throws NumberFormatException, Exception 
	{			
		System.out.println("why here");
		 com.alm.demo.sj.entity.ProjectEvent temp= projectEventService.getProjectEvent(Integer.parseInt(id));
			if(temp!=null)
			{
				return temp;
			}
			else
			{
				throw new Exception("ID not Found");
			}
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public AllException handleException(Exception e) {
		return new AllException(e.getMessage());
	}
}