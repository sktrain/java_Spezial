
package sk.train.ma_basic_overwrite;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Starter {

	public static void main(String[] args) {

      Mitarbeiter m1 ;
      
      m1 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1969,8, 14),
    		                LocalDate.of(2015, 1, 1), new BigDecimal(5000));
      
      Mitarbeiter m2 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1969,8, 14),
              LocalDate.of(2015, 1, 1), new BigDecimal(5000));
      
      System.out.println(m1);
      System.out.println(m2);
      
      System.out.println(m1 == m2);
      System.out.println(m1.equals(m2));
      
      System.out.println(m1.getPersnr());
      System.out.println(m2.getPersnr());
      
      System.out.println(m1.getGes());
      System.out.println(m1.getGes().name());

	}

}







