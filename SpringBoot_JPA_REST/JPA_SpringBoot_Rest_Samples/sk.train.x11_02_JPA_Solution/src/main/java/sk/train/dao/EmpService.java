package sk.train.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import sk.train.model.Department;
import sk.train.model.Employee;

public class EmpService {
	
	//@PersistenceContext
	private EntityManager myem;

	
	//default-Konstruktor
	public EmpService(EntityManager myem) {
		super();
		this.myem = myem;
	}
	
	public void createEmp(Employee emp){
		myem.persist(emp);		
	}
	
	public Optional<Employee> readEmp(long id){
		return Optional.ofNullable(myem.find(Employee.class, id));
	}
	
	public void removeEmp(long id){
		Employee emp = myem.find(Employee.class, id);
		if (emp != null)
		myem.remove(emp);
	}
	
	public void setSalaryEmp(long id, BigDecimal sal){
		Employee emp = myem.find(Employee.class, id);
		if (emp != null)
			emp.setSalary(sal);
	}
	
	public List<Employee> getEmps(){
		//alle Angestellten: Named Query nutzen
		return myem.createNamedQuery("Employee.findAll", Employee.class).getResultList();
	}
	
	//Ergaenzungen bzgl. Departments
	public List<Department> getDeps(){
		return myem.createNamedQuery("Department.findAll", Department.class).getResultList();
	}
	
	public Optional<Department> readDep(long id){
		return Optional.ofNullable(myem.find(Department.class, id));

	}

	public void createDep(Department dep){
		myem.persist(dep);
	}

	public void removeDep(long id){
		Department dep = myem.find(Department.class, id);
		if (dep != null)
			myem.remove(dep);
	}

	public void updateDep(Department  dep){
		if (myem.find(Department.class, dep.getDepartmentId()) != null){
			myem.merge(dep);
		}
	}
}
