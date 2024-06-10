package sk.train.ma_verwaltung_strategy_gui_db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;


public class MitarbeiterVerwaltung {
	
	private TreeMap<String, Mitarbeiter> map;
	private Connection con;
	
//	public MitarbeiterVerwaltung() {
//		
//		map = new TreeMap<>();
//				
//		//Füllschleife: 100 Mitarbeiter erzeugen und einfüllen
//		// wechselweise  Arbeiter/Fixgehalt
//		// zufällige Gehälter
//		// Namensgebung anhand Füllschleife
//		
//		Mitarbeiter m;
//		Gehaltsmodell gehaltsmodell;
//		for (int i = 0; i < 100; ++i) {
//			if (i % 2 == 0) {
//				// Nutzung der GehaltsmodellFactory
//				gehaltsmodell = GehaltsmodellFactory.getGehaltsmodell("F");
//				m = new Mitarbeiter(i, "Max", "Mustermann" + i, LocalDate.of(1976, 1 + (int) (Math.random() * 12), 1),
//						LocalDate.of(2000, 1, 1), Geschlecht.M, gehaltsmodell);
//				map.put(m.getPersnr(), m);
//			} else {
//				// Nutzung der GehaltsmodellFactory
//				gehaltsmodell = GehaltsmodellFactory.getGehaltsmodell("A");
//				m = new Mitarbeiter(i, "Max", "Mustermann" + i, LocalDate.of(1976, 1 + (int) (Math.random() * 12), 1),
//						LocalDate.of(2000, 1, 1), Geschlecht.M, gehaltsmodell);
//				map.put(m.getPersnr(), m);
//			}
//
//		}
//	}
	
	public MitarbeiterVerwaltung(Connection con) throws SQLException {
		this.con = con;
		
		// in der Employees-Tabelle gibt es unterschiedliche Spalten und nur Fixgehalt bzw. Provisionsatz 
		
		//Daten einlesen und Map füllen
		
		map = new TreeMap<>();
		
		Statement st = con.createStatement();
		String query = "SELECT employee_id, first_name, last_name, hire_date, salary from hr.employees";
		ResultSet rs = st.executeQuery(query);
		//int  anzahlspalten = rs.getMetaData().getColumnCount();
		//System.out.println("Insgesamt Spalten verfügbar: " + anzahlspalten);
		while (rs.next()){	
			Mitarbeiter m = new Mitarbeiter(rs.getInt("employee_id"), 
					                        rs.getString("first_name"),
					                        rs.getString("last_name"),
					                        LocalDate.of(1980, 1, 1),	//Gebdatum nicht in Tabelle
					                        rs.getDate("hire_date").toLocalDate(),
					                        Geschlecht.D,	//Geschlecht nicht in Tabelle
					                        new FixGehaltModell(rs.getBigDecimal("salary")));
			map.put(m.getPersnr(),m);
		}
		st.close();
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
	
	public void addMitarbeiter(Mitarbeiter m) throws SQLException {
		if (map.containsKey(m.getPersnr())) {
			throw new RuntimeException("Personalnummer existiert schon");
		} else {
			map.put(m.getPersnr(), m);
			//DB-Zugriff
			PreparedStatement st = con.prepareStatement("INSERT INTO hr.employees (employee_id, first_name, last_name, hire_date, salary, job_id)\r\n"
					                    + "VALUES (?, ?, ?, ?, ?, ?)");
			st.setInt(1, Integer.parseInt(m.getPersnr().substring(2)));  //Personalnummer ist String
			st.setString(2, m.getVorname());
			st.setString(3, m.getNachname());
			st.setDate(4, Date.valueOf(m.getEinstdatum()));
			st.setBigDecimal(5, m.getGmodell().getGehalt());
			st.setString(6, "IT_PROG");
			st.executeUpdate();
			st.close();
		}
	}
	
	public void delMitarbeiter(Mitarbeiter m) throws SQLException {
		if (map.remove(m.getPersnr()) == null){
			throw new RuntimeException("Mitarbeiter existiert nicht");
		} else {
			//DB-Zugriff
			PreparedStatement st = con.prepareStatement("DELETE FROM hr.employees WHERE employee_id = ?");
			st.setInt(1, Integer.parseInt(m.getPersnr().substring(2)));  //Personalnummer ist String
			st.executeUpdate();
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











