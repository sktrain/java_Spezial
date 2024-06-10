
package sk.train.ma_basic;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Starter {

	public static void main(String[] args) {

      Mitarbeiter m1 ;
      
      LocalDate d = LocalDate.of(2000, 1, 1);
      
      m1 = new Mitarbeiter( 1, "Stephan", "Karrer", LocalDate.of(1959,8, 14),
    		                LocalDate.of(2015, 1, 1), new BigDecimal("5000"));
      
      Mitarbeiter m2 = new Mitarbeiter(1,  "Stephan", "Karrer", LocalDate.of(1959,8, 14),
              LocalDate.of(2015, 1, 1), new BigDecimal(5000));
      
      System.out.println(m1 == m2);
      System.out.println(m1.equals(m2));
      
      System.out.println(m1.getPersnr());
      System.out.println(m2.getPersnr());
      
      m2 = m1;
      
      m1.setNachname("Muster");
      System.out.println(m2.getNachname());
      
      System.out.println(m1 == m2);
      System.out.println(m1.equals(m2));

	}

}







