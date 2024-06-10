/* Mitarbeiter-L�sung erweitert um verschiedene Sortiervarianten:
 * Lambdas werden kurz eingeführt.
 */

package sk.train.ma_verwaltung_strategy;

import java.util.Comparator;

public class Starter {

	public static void main(String[] args) {

		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
		
		//System.out.println(Objects.isNull(mv));

//		print(mv);
		
//		printNaturalOrder(mv);
//		
//		printSortedByName(mv);
//
//		printSortedByGebDatum1(mv);
//
		printSortedByGebDatum2(mv);
//
//		printSortedByGebDatumAndGehalt(mv);

	}
	

	private static void print(MitarbeiterVerwaltung mv) {
		//Ausgabe sortiert nach dem Key, da TreeMaps die Values nicht geordnet speichern
		System.out.println(mv);   //vorausgesetzt entsprechende toString-Methode
		

	}

	private static void printNaturalOrder(MitarbeiterVerwaltung mv) {
		// Jetzt nach Gehältern sortiert (natural order)
		System.out.println("\n***********Hier nach Gehalt sortiert**************\n");
		mv.getMlist(Comparator.naturalOrder()).forEach(System.out::println);
	}

	private static void printSortedByName(MitarbeiterVerwaltung mv) {
		// jetzt nach Nachnamen sortiert
		System.out.println("\n***********Hier nach Nachnamen sortiert**************\n");
		mv.getMlist(new NachnamenComparator()).forEach(System.out::println);
	}

	private static void printSortedByGebDatum1(MitarbeiterVerwaltung mv) {
		// jetzt mal nur per Lambda nach den Geburtsdaten und Ausgabe mit
		// foreach-Lambda-Version
		System.out.println("\n***********Hier nach Geburtsdatum sortiert**************\n");
		Comparator<Mitarbeiter> cgebdatum = (Mitarbeiter m1, Mitarbeiter m2) -> {
			return m1.getGebdatum().compareTo(m2.getGebdatum());
		};
		mv.getMlist(cgebdatum).forEach(System.out::println);
	}
	
	private static void printSortedByGebDatum2(MitarbeiterVerwaltung mv) {
		// jetzt mal nur per Lambda nach den Geburtsdaten unter Nutzung statischer Factory-Methode
		// und Ausgabe mit foreach-Lambda-Version
		System.out.println("\n***********Hier nach Geburtsdatum sortiert**************\n");
		//Comparator<Mitarbeiter> cgebdatum = Comparator.comparing((Mitarbeiter m) -> m.getGebdatum());
		//noch kompakter als Methodenreferenz
		Comparator<Mitarbeiter> cgebdatum = Comparator.comparing(Mitarbeiter::getGebdatum);
		mv.getMlist(cgebdatum).forEach(System.out::println);
	}
	
	private static void printSortedByGebDatumAndGehalt(MitarbeiterVerwaltung mv) {
		// und jetzt mal zuerst nach den Geburtsdaten und dann nachsortiert anhand der Gehälter
		System.out.println("\n******Hier nach Geburtsdatum und Gehalt sortiert************\n");
		Comparator<Mitarbeiter> cgebdatum = (Mitarbeiter m1, Mitarbeiter m2) -> {
			return m1.getGebdatum().compareTo(m2.getGebdatum());
		};
		Comparator<Mitarbeiter> cgehalt = (Mitarbeiter m1, Mitarbeiter m2) -> {
			return m1.getGmodell().getGehalt().compareTo(m2.getGmodell().getGehalt());
		};
		mv.getMlist(cgebdatum.thenComparing(cgehalt)).forEach(System.out::println);;
		
	}

}
