package sk.train.ma_verwaltung_strategy;

import java.math.BigDecimal;

public interface Gehaltsmodell {
	
	public abstract BigDecimal getGehalt();
	
	public static Gehaltsmodell getGehaltsmodell(String type) {
		if (type.equals("A")) return new ArbeiterModell(new BigDecimal(17), new BigDecimal(120));
		else return new FixGehaltModell(new BigDecimal(5000));
	}

}
