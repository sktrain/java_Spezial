package sk.train.ma_verwaltung_strategy;

import java.math.BigDecimal;

public class GehaltsmodellFactory {

	public static Gehaltsmodell getGehaltsmodell(String type) {
		if (type.equals("A"))
			return new ArbeiterModell(new BigDecimal((int)(Math.random()*100)),	new BigDecimal(120));
		else return new FixGehaltModell(new BigDecimal((int)(Math.random()*10000))); }
	 

}
