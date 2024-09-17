/* Zeigt nicht saubere Vererbung:
 * Mitarbeiter in der momentanen Form ist keine geeignete Elternklasse 
 * f�r Arbeiter
 */



package sk.train.ma_vererbung_problem;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Starter {

	public static void main(String[] args) {
      
      Arbeiter a1 = new Arbeiter("Max", "Maulwurf", LocalDate.of(1960, 1, 1), LocalDate.of(2014,  1, 1), Geschlecht.M,
    		                     new BigDecimal(17.25), new BigDecimal(100));
      
      System.out.println(a1.getGehalt());        
      
      
      System.out.println(a1);
      
      a1.setGehalt(new BigDecimal(50000));
      
      System.out.println(a1.getGehalt());     
      
      System.out.println(a1);
      

	}

}







