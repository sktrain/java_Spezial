package sk.train.ma_verwaltung_abstract;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MitarbeiterVerwaltung {
	
	private Mitarbeiter[] marray;
	private List<Mitarbeiter> mlist;
	
	public MitarbeiterVerwaltung() {
		marray = new Mitarbeiter[100];
		
		mlist = new ArrayList<Mitarbeiter>();
		
		//Füllschleife: 100 Miarbeiter erzeugen und einf�llen
		// wechselweise  Arbeiter/Fixgehalt
		// zufällige Gehälter
		// Namensgebung anhand Füllschleife
		
		Mitarbeiter m;
		for (int i = 0; i < marray.length; ++i) {
			if (i%2 == 0) {
				m = new FixGehaltMitarbeiter("Max", "Mustermann" + i,
						  LocalDate.of(1976, 1 + (int)(Math.random()*12), 1), 
						  LocalDate.of(2000,1, 1), Geschlecht.M, 
						  new BigDecimal((int)(Math.random()*10000)));
				marray[i] = m;
				mlist.add(m);
			} else {
				m = new Arbeiter("Erika", "Maulwurf" + i,
						  LocalDate.of(1976, 1 + (int)(Math.random()*12), 1), 
						  LocalDate.of(2000,1, 1), Geschlecht.W, 
						  new BigDecimal((int)(Math.random()*100)),
						  new BigDecimal(120));
				marray[i] = m;
				mlist.add(m);
			}
		}
	}
	
	public BigDecimal getGehaltssumme() {
		
		BigDecimal result = BigDecimal.ZERO;
		for (Mitarbeiter m : marray) {
			result = result.add(m.getGehalt());
		}
		return result;
	}

	public Mitarbeiter[] getMarray() {
		return marray;
	}

	public List<Mitarbeiter> getMlist() {
		return mlist;
	}
	 
	@Override
	public String toString() {
		//return "MitarbeiterVerwaltung [marray=" + Arrays.toString(marray) + ", mlist=" + mlist + "]";
		//Standard-Ausgabe des Arrays bzw. der Liste macht keine Zeilenumbrüche
		//deshalb per Schleife zeilenweise (analog direkter Ausgabeschleife)
		StringBuilder sb = new StringBuilder();
		for (Mitarbeiter m: marray) {
			sb.append(m.toString()).append('\n');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(marray);
		result = prime * result + ((mlist == null) ? 0 : mlist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MitarbeiterVerwaltung other = (MitarbeiterVerwaltung) obj;
		if (!Arrays.equals(marray, other.marray))
			return false;
		if (mlist == null) {
			if (other.mlist != null)
				return false;
		} else if (!mlist.equals(other.mlist))
			return false;
		return true;
	}
	

}











