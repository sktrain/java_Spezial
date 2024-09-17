/* Mitarbeiterklasse schreibt als abstrakte Klasse getGehalt-Methode vor.
 * Somit kann in der Mitarbeiterverwaltung die Gehaltssumme berechnet werden.
 * Nebenbei werden eine Anzahl Mitarbeiter als Testdaten generiert und sowohl 
 * als Liste als auch als Array verwaltet.
 * Zus�tzlich Ausgabe im Textformat in Datei.
 */

package sk.train.ma_verwaltung_abstract;

import java.util.Arrays;

public class Starter {

	public static void main(String[] args) {

		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
		
//		System.out.println(mv);
//		
		System.out.println("\n***********************************\n");

		System.out.println("Gehaltsumme: " + mv.getGehaltssumme());
		
		Mitarbeiter[] marray = mv.getMarray();
		
		for ( Mitarbeiter m : marray) {
			System.out.println(m);
		}
		
				
		//mal die Exception provozieren
//		mv.getMlist().get(0).setNachname("A");


		
//		Writer out = null;
//		
//		try {
//		    out = Files.newBufferedWriter(Paths.get("mitarbeiter.txt"), StandardCharsets.ISO_8859_1);
//			for (Mitarbeiter m : mv.getMarray()) {
//				out.write(m.toString());
//			    out.write(System.lineSeparator());
//			}
//			out.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

}
