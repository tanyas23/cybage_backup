package com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.IterationDAO;
import com.dao.LoginDAO;
import com.dao.ReleaseDAO;
import com.entities.*;

@Controller
@RequestMapping("/releasemanagement")
public class ReleaseMgtCont {
	//For JPA
	private static final String PERSISTENCE_UNIT_NAME = "ALM";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();	
	IterationDAO id= new IterationDAO();
	ReleaseDAO rd= new ReleaseDAO();
	LoginDAO ld= new LoginDAO();
	
	public ReleaseMgtCont() {
		System.out.println("ReleaseController const");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login() throws Exception 
	{
		System.out.println("inside Login");	
		ModelAndView model = new ModelAndView("login");
		return model; 


	}
	
	@RequestMapping(value="/loginchecker")
	public ModelAndView loginchecker(@ModelAttribute ("login") LoginEntity le) throws Exception 
	{
		System.out.println("inside Loginchcker");	
		ModelAndView model = new ModelAndView("login");
		ModelAndView model1 = new ModelAndView("homepage");	
		if(ld.logincheck(le))
			return model1;
		else
			return model;


	}
	
	
	
	@RequestMapping(value="/homepage")
	public ModelAndView home() throws Exception 
	{
		System.out.println("inside Homepage");		
		ModelAndView model = new ModelAndView("homepage");
		return model;
	}
	
	@RequestMapping(value ="/newiterationsubmit")
	public ModelAndView insertIteration(@ModelAttribute ("newiteration") IterationEntity ie)
	{
		System.out.println("inside new Iteration submit");
		id.insert(ie);
		System.out.println("inside new Iteration submit");
		ModelAndView model = new ModelAndView("homepage");
		model.addObject("message","New Iteration added");
		return model;
		
	}
	
	@RequestMapping(value ="/edititerationsubmit")
	public ModelAndView editIteration(@ModelAttribute ("edititeration") IterationEntity ie)
	{

		id.edit(ie);
		System.out.println("inside edit Iteration submit");
		ModelAndView model = new ModelAndView("homepage");
		return model;
		
	}

	
	@RequestMapping(value="/searchiterations")
	public  @ResponseBody String searchiterations() throws Exception 
	{
		System.out.println("inside Search Iterations");		
		return id.displayAll();
	}
	
	/*
	 * Release Part
	 * 
	 * 
	 * */
	
	@RequestMapping(value ="/newreleasesubmit")
	public ModelAndView insertrelease(@ModelAttribute ("newrelease") ReleaseEntity re)
	{
		System.out.println(re.toString());
		System.out.println("inside new Iteration submit");
		rd.insert(re);
		System.out.println("inside new Iteration submit");
		ModelAndView model = new ModelAndView("homepage");
		return model;
		
	}
	
	@RequestMapping(value ="/editreleasesubmit")
	public ModelAndView editRelease(@ModelAttribute ("editrelease") ReleaseEntity re)
	{
		rd.edit(re);
		System.out.println("inside edit Release submit");
		ModelAndView model = new ModelAndView("homepage");
		return model;
		
	}
	
	@RequestMapping(value="/searchrelease")
	public  @ResponseBody String searchrelease() throws Exception 
	{
		System.out.println("inside Search Release");		
		return rd.displayAll();
	}
	
	
}
