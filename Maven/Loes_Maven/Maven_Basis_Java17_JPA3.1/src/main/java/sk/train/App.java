package sk.train;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
