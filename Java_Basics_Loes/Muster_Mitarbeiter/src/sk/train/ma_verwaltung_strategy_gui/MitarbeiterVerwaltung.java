package sk.train.ma_verwaltung_strategy_gui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;



public class MitarbeiterVerwaltung {
	
	private TreeMap<String, Mitarbeiter> map;
	
	public MitarbeiterVerwaltung() {
		
		map = new TreeMap<>();
				
		//Füllschleife: 100 Mitarbeiter erzeugen und einfüllen
		// wechselweise  Arbeiter/Fixgehalt
		// zufällige Gehälter
		// Namensgebung anhand Füllschleife
		
		Mitarbeiter m;
		Gehaltsmodell gehaltsmodell;
		for (int i = 0; i < 100; ++i) {
			if (i%2 == 0) {
				//Nutzung der GehaltsmodellFactory
				gehaltsmodell = GehaltsmodellFactory.getGehaltsmodell("F");
				m = new Mitarbeiter(i , "Max", "Mustermann" + i,
						  LocalDate.of(1976, 1 + (int)(Math.random()*12), 1), 
						  LocalDate.of(2000,1, 1), Geschlecht.M, 
						  gehaltsmodell);
				map.put(m.getPersnr(), m);
			} else {
				//Nutzung der GehaltsmodellFactory
				gehaltsmodell = GehaltsmodellFactory.getGehaltsmodell("A");
				m = new Mitarbeiter(i, "Max", "Mustermann" + i,
						  LocalDate.of(1976, 1 + (int)(Math.random()*12), 1), 
						  LocalDate.of(2000,1, 1), Geschlecht.M, 
						  gehaltsmodell);
				map.put(m.getPersnr(), m);
			}
			
		}
	}
	
	public BigDecimal getGehaltssumme() {
		
		BigDecimal result = BigDecimal.ZERO;
		for (Mitarbeiter m : map.values()) {
			result = result.add(m.getGmodell().getGehalt());
		}
		return result;
	}

	public List<Mitarbeiter> getMlist(Comparator<Mitarbeiter> comp) {
		ArrayList<Mitarbeiter> alm = new ArrayList<>();
		alm.addAll(map.values());
		alm.sort(comp);
		return alm;
	}
	
	public void addMitarbeiter(Mitarbeiter m) {
		if (map.containsKey(m.getPersnr())) {
			throw new RuntimeException("Personalnummer existiert schon");
		} else {
			map.put(m.getPersnr(), m);
		}
	}
	
	public void delMitarbeiter(Mitarbeiter m) {
		if (map.remove(m.getPersnr()) == null){
			throw new RuntimeException("Mitarbeiter existiert nicht");
		}
	}
	
	
	
	/********* Standardmethoden **************/

	@Override
	public String toString() {
		//return "MitarbeiterVerwaltung [marray=" + Arrays.toString(marray) + ", mlist=" + mlist + "]";
		//Standard-Ausgabe des Arrays bzw. der Liste macht keine Zeilenumbrüche
		//deshalb per Schleife zeilenweise (analog direkter Ausgabeschleife)
		StringBuilder sb = new StringBuilder();
		for (Mitarbeiter m: map.values()) {
			sb.append(m.toString()).append('\n');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
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
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}
	

}











