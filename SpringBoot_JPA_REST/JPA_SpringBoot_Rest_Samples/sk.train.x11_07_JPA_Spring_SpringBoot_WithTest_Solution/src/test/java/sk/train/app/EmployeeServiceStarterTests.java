package sk.train.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.train.model.Employee;
import sk.train.repositories.EmpRepository;


@SpringBootTest()
class EmployeeServiceStarterTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private EmpRepository myserv;
	
	//private Employee emp;
	
	@Test
	void crudTest() {
		
		Employee emp = new Employee();
		emp.setEmployeeId(471);
		emp.setFirstName("Max");
		emp.setLastName("Mustermann");
		emp.setHireDate(new Date());
		emp.setJobId("IT_PROG");
		emp.setPhoneNumber("1111");
		emp.setSalary(new BigDecimal(5000l));
		emp.setEmail("Mustermann@murks.de" + 4711);
		
		
		myserv.save(emp);
		
		Employee emp1 = myserv.findById(471L).get();
		System.err.println(emp1);
		
		emp1.setSalary(new BigDecimal(8000L));
		myserv.save(emp1);
		
		emp1 = myserv.findById(471L).get();
		System.err.println(emp1.getSalary());
		
		myserv.deleteById(471L);
		
		assertTrue(myserv.findById(471L).isEmpty());
		
		
	}
	
	

}