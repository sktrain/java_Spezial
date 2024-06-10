/* Es werden eine Anzahl Mitarbeiter als Testdaten generiert und sowohl 
 * als Liste als auch als Array verwaltet.
 */

package sk.train.ma_verwaltung;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Starter {

	public static void main(String[] args) {

		MitarbeiterVerwaltung mv = new MitarbeiterVerwaltung();
		
		System.out.println(mv);
		

//		System.out.println("\n***********************************\n");
//
//		for (Mitarbeiter m : mv.getMarray())
//			System.out.println(m);
//
//		System.out.println("\n***********************************\n");
//
//		for (Mitarbeiter m : mv.getMlist())
//			System.out.println(m);
	
	}

}
