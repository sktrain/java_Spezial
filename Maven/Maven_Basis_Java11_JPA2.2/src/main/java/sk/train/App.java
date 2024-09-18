package sk.train;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String... args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Muster_JPA_Hibernate_Local");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);
        
    }
}
