/* Zeigt saubere Vererbung:
 * Arbeiter und FixGehaltMitarbeiter sind Kindklassen von Mitarbeiter.
 * Nachteil: Mitarbeiter hat aber kein Gehalt mehr und somit keine 
 * getGehalt-Methode!
 */



package sk.train.ma_vererbung_sauber;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Starter {

	public static void main(String[] args) {

      Mitarbeiter m1 ;
      
      m1 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1959,8, 14),
    		                LocalDate.of(2015, 1, 1) //, new BigDecimal(5000)
    		                );
      
      Mitarbeiter m2 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1959,8, 14),
              LocalDate.of(2015, 1, 1) //, new BigDecimal(5000)
              );
      
      System.out.println(m1 == m2);
      System.out.println(m1.equals(m2));
      
      System.out.println(m1.getPersnr());
      System.out.println(m2.getPersnr());
      
      Arbeiter a1 = new Arbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1),
    		                     new BigDecimal(17.25), new BigDecimal(100));
      System.out.println(a1);
      
      //a1.setGehalt(new BigDecimal(50000));
      
      FixGehaltMitarbeiter f1 = new FixGehaltMitarbeiter("Erika","Musterfrau", LocalDate.of(1970,1,1),
      													LocalDate.of(2000,1,1), new BigDecimal(6000));
      
      System.out.println(f1);
      
      
     Arbeiter a2 = new Arbeiter("Erika", "Musterfrau", null, null, Geschlecht.W, new BigDecimal(17.5), 
    		  						new BigDecimal(100));
      System.out.println(a2);
      

	}

}







