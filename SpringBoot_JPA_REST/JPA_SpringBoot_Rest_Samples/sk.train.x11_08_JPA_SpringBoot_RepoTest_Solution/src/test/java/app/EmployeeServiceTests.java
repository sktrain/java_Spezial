package app;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import app.dao.EmpRepository;
import app.model.Employee;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EmployeeServiceTests {

//	@Test
//	void contextLoads() {
//	}
//

	@Autowired private ApplicationContext ctx;
	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager em;
	@Autowired
	private EmpRepository myserv;

	@Test
	void datasource_jdbctemplate_entitymanager_repository_not_null() {
		assertThat( dataSource ).isNotNull();
		assertThat( jdbcTemplate ).isNotNull();
		assertThat( em ).isNotNull();
		//Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.err::println);
	}
	
	//private Employee emp;
	
	//@Test
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
		
		Employee erg = myserv.save(emp);
		assertSame(erg, emp);

		Optional<Employee> emp1 = myserv.findById(471L);
		assertTrue(myserv.findById(471L).isPresent());

		emp.setSalary(new BigDecimal(8000L));
		erg = myserv.save(emp);
		assertSame(erg, emp);
		//System.err.println(erg == emp);

		emp1 = myserv.findById(471L);
		assertEquals(emp1.get().getSalary(), 8000L);
//		if (emp1.isPresent()) {
//			System.err.println(emp1.get().getSalary());
//		}

		myserv.deleteById(471L);
		
		assertTrue(myserv.findById(471L).isEmpty());		
	}
	
	@Test
	void chefIndianerTest() {
		
		assertEquals(myserv.count(), myserv.getChefsNative().size()
				                            + myserv.getIndianerNative().size());	
	}
	
	//usw. ...
	
}
