package sk.train.ma_verwaltung_strategy_gui;

import java.util.Comparator;

public class NachnamenComparator implements Comparator<Mitarbeiter> {

	@Override
	public int compare(Mitarbeiter arg0, Mitarbeiter arg1) {
		return arg0.getNachname().compareTo(arg1.getNachname());
	}

}
