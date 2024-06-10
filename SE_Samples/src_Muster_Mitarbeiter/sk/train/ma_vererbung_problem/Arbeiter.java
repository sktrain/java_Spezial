package sk.train.ma_vererbung_problem;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Arbeiter extends Mitarbeiter {
	
	//Datenattribute
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	
	//Konstruktoren	
	public Arbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum, Geschlecht ges,
			BigDecimal stdlohn, BigDecimal stdzahl) {
		super(vorname, nachname, gebdatum, einstdatum, stdlohn.multiply(stdzahl), ges);
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}
	
	//getter/setter
	public BigDecimal getStdlohn() {
		return stdlohn;
	}
	
	public void setStdlohn(BigDecimal stdlohn) {
		this.stdlohn = stdlohn;
		super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	public BigDecimal getStdzahl() {
		return stdzahl;
	}
	
	public void setStdzahl(BigDecimal stdzahl) {
		this.stdzahl = stdzahl;
		super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	//sollte der Arbeiter auch die Standardmethoden überschreiben?

}
