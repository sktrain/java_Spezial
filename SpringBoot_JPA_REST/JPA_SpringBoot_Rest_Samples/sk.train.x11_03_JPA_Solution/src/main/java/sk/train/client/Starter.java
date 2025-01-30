package sk.train.client;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import sk.train.dao.EmpService;
import sk.train.model.Department;
import sk.train.model.Employee;

public class Starter {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Muster_JPA_Hibernate_H2_Local");
        EntityManager em = emf.createEntityManager();


        EmpService myserv = new EmpService(em);

        Employee emp = new Employee();
        emp.setEmployeeId(471);
        emp.setFirstName("Max");
        emp.setLastName("Mustermann");
        emp.setHireDate(Date.valueOf(LocalDate.of(2000, 1, 1)));
        emp.setJobId("IT_PROG");
        emp.setPhoneNumber("1111");
        emp.setSalary(new BigDecimal(5000l));
        emp.setEmail("Mustermann@murks.de" + 4711);

        EntityTransaction t = em.getTransaction();
        t.begin();
        myserv.createEmp(emp);
        t.commit();

        t = em.getTransaction();
        t.begin();
        Optional<Employee> optionalemp1 = myserv.readEmp(471);
        optionalemp1.ifPresent(employee -> System.out.println(employee.getLastName()));
        t.commit();

        t = em.getTransaction();
        t.begin();
        myserv.setSalaryEmp(471, new BigDecimal(8000L));
        t.commit();

        t = em.getTransaction();
        t.begin();
        optionalemp1 = myserv.readEmp(471);
        optionalemp1.ifPresent(employee -> System.out.println(employee.getSalary()));
        t.commit();

        t = em.getTransaction();
        t.begin();
        myserv.removeEmp(471);
        t.commit();

        myserv.getEmps().forEach(System.out::println);

        System.out.println("\n ********************* jetzt zu den Departments *************\n");

        List<Department> deplist = myserv.getDeps();
        deplist.forEach(System.out::println);

        Optional<Department> odep = myserv.readDep(50L);
        odep.ifPresent(department ->
                System.out.println("Hier kommt der Abteilungsleiter: " + (department.getDepManager())));

        //jetzt mal alle Angestellten
        System.out.println("\n ********************* alle Angestellten im Department *************\n");
        Department dep = null;
        if (odep.isPresent()) {
            dep = odep.get();
            dep.getEmployeesInDep().forEach(employee -> System.out.println(employee));
        }

        t = em.getTransaction();
        t.begin();
        Department newdep = new Department();
        Employee depmanager = myserv.readDep(50L).get().getDepManager();
        newdep.setDepManager(depmanager);
        newdep.setDepartmentId(1L);
        newdep.setDepartmentName("KarrersDepartment");
        myserv.createDep(newdep);
        t.commit();

        System.out.println(myserv.readDep(1L).get());

        t = em.getTransaction();
        t.begin();
        Department newdep1 = new Department();
        newdep.setDepartmentId(1L);
        newdep.setDepartmentName("KarrersDepartment2");
        myserv.updateDep(newdep1);
        t.commit();


        System.out.println(myserv.readDep(1L).get());

        t = em.getTransaction();
        t.begin();
        myserv.removeDep(1L);
        t.commit();


        System.out.println("\n ********************* jetzt zu den Query-Möglichkeiten *************\n");


        System.out.println("Angestellte mit Gehalt >= 5000");
        myserv.getempsBySalary(new BigDecimal("5000")).forEach(System.out::println);

        System.out.println("Gehaltssumme: " + myserv.getSumSalary());

        System.out.println("\n************** Liste der Namen **********************\n");
        List<Object[]> names = myserv.getNamesAsParts();
        for (Object[] oarray : names) {
            System.out.println(oarray[0] + ", " + oarray[1]);
        }

        System.out.println("\n************** Liste der Namen via KonstruktorAusdruck **********************\n");
        myserv.getNames().forEach(System.out::println);

        System.out.println("\n********************* Liste der Chefs via JPQL ******************\n");
        myserv.getChefs().forEach(System.out::println);

        System.out.println("\n********************* Liste der Indianer via JPQL ******************\n");
        myserv.getIndianer().forEach(System.out::println);

        System.out.println("\n********************* Liste der Chefs via native SQL ******************\n");
        myserv.getChefsNative().forEach(System.out::println);

        System.out.println("\n********************* Liste der Indianer via native SQL ******************\n");
        myserv.getIndianerNative().forEach(System.out::println);

        System.out.println("\n********************* Liste der Chefs via Criteria-API ******************\n");
        //Criteria-Api-Variante
        myserv.getChefsCriteria().forEach(System.out::println);


        System.out.println("\n******************* StoredProcedure bzw. StoredFunction nutzen ***********************\n");
//        //Aufruf einer Stored_Procedure (ab JPA 2.1 unterstützt)
//        System.out.println(myserv.add1(10, 20));
//
//        System.out.println(myserv.add2(4,4));
//
//        //Aufruf einer Stored Fucnction
//        System.out.println(myserv.addFunction(3,3));

        System.out.println("\n Prozeduraufruf");
        System.out.println(myserv.stringLengthAsProcedure("otto"));


        System.out.println("\n Funktionsaufruf");
        myserv.getEmpsByNameLength(5).forEach(System.out::println);
        System.out.println("\n**************************************************************************\n");
        myserv.getEmpsByNameLengthFunction(4).forEach(System.out::println);

        System.out.println("direkte Verwendung der char_length-Fkt.");
        System.out.println(myserv.stringLengthAsFunctionInSelect("max"));

        //Alternative beim Funktionsaufruf via JPQL
        System.out.println("\n******************* Alternativen beim Funktionsaufruf ***********************\n");



    }

}
