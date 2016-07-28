package com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.IterationDAO;
import com.entities.*;
@Controller
@RequestMapping("/releasemanagement")
public class ReleaseMgtCont {
	//For JPA
	private static final String PERSISTENCE_UNIT_NAME = "ALM";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();	
	IterationDAO id= new IterationDAO();
	//Query query = em.createQuery("select name from Emp");
	
	
	public ReleaseMgtCont() {
		System.out.println("ReleaseController const");
	}
	
	@RequestMapping("/homepage")
	public String home() throws Exception 
	{
		System.out.println("Works");
		return "redirect:/app/partials/homepage.html";
		/*ModelAndView model = new ModelAndView("homepage");
		return model;*/
	}
	
	@RequestMapping(value ="/newiterationsubmit" , method=RequestMethod.POST)
	public ModelAndView insertIteration(IterationEntity ie)
	{
		id.insert(ie);
		ModelAndView model = new ModelAndView("homepage");
		return model;
		
	}

	/*@RequestMapping("/welcome/{username}/{hobby}")
	protected ModelAndView handleRequestInternal1(@PathVariable("username") String name,@PathVariable("hobby") String hobby) throws Exception 
	{
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("message","The hobby of "+name+" is "+hobby);
		return model;
	}

	//Works with Request Method Post
	@RequestMapping(value ="/formone1" , method=RequestMethod.POST)
	public ModelAndView formTest2(@RequestParam("studentname")String studentname,@RequestParam("studentnumber")String studentnumber)
	{
		ModelAndView model = new ModelAndView("DisplayFormData");
		model.addObject("studentname","studentname");
		model.addObject("studentnumber","studentnumber");
		return model;
		
	}
	
	//Works with Map of RequestParam
	@RequestMapping(value ="/formone2" , method=RequestMethod.POST)
	public ModelAndView formTest3(@RequestParam Map<String,String> reqParam)
	{
		ModelAndView model = new ModelAndView("DisplayFormData");
		model.addObject("studentname",reqParam.get("studentname"));
		model.addObject("studentnumber",reqParam.get("studentnumber"));
		return model;
		
	}
	
	//@ModelAttribute
	@RequestMapping(value ="/formone3" , method=RequestMethod.POST)
	public ModelAndView formTest4(@ModelAttribute ("studentone") StudentClass stu)
	{
		
		ModelAndView model = new ModelAndView("DisplayFormModel");
		return model;
		
	}
	
	@RequestMapping(value ="/test123" , method=RequestMethod.POST)
	public ModelAndView test123(@ModelAttribute ("Employee") Emp e)
	{
		  
		  Emp m= new Manager();
		  em.getTransaction().begin();

			 
		  //to Insert
		  e.setId("5");
		  e.setName("Arjun");
		  m.setId("6");
		  m.setName("Arjun");
		  ((Manager) m).setSalary(100);
		  em.persist(e);
		  em.persist(m);
		  em.getTransaction().commit();
		  //To read
		  Query query = em.createQuery("select name from Emp");//Use Class Name not table name
		  List l= query.getResultList();
		  Iterator itr= l.iterator();
			 while(itr.hasNext()){
				 System.out.println(itr.next());
			 }
			 em.getTransaction().commit(); 
		ModelAndView model = new ModelAndView("DisplayFromEmp");
		return model;
		
	}
	*/
	
}
