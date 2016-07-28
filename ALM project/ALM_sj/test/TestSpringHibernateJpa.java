
 
import java.util.List;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alm.demo.sj.entity.ProjectEvent;
import com.alm.demo.sj.service.ProjectEventService;
 
public class TestSpringHibernateJpa {
 
    public static void main(String[] args) throws Exception {
        System.out.println("************** BEGINNING PROGRAM **************");
          
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ProjectEventService  projectEventService = (ProjectEventService) context.getBean("projectEventService");
         
          ProjectEvent pe =new ProjectEvent();
          projectEventService.addProjectEvent(pe);
        
       
       // System.out.println("Person : " + person + " added successfully");
         
      //  List<Person> persons = personService.fetchAllPersons();
     //   System.out.println("The list of all persons = " + persons);
         
    //    System.out.println("************** ENDING PROGRAM *****************");
    }
}
