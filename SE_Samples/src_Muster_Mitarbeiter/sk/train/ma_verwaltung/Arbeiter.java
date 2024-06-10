package sk.train.ma_verwaltung;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Arbeiter extends Mitarbeiter {
	
	//Datenattribute
	private BigDecimal stdlohn;
	private BigDecimal stdzahl;
	
	
	//Konstruktoren	
	public Arbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum, 
			BigDecimal stdlohn, BigDecimal stdzahl) {
		super(vorname, nachname, gebdatum, einstdatum //, stdlohn.multiply(stdzahl)
				);
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}
	
	
	
	public Arbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum, Geschlecht geschlecht,
			BigDecimal stdlohn, BigDecimal stdzahl) {
		super(vorname, nachname, gebdatum, einstdatum, geschlecht);
		this.stdlohn = stdlohn;
		this.stdzahl = stdzahl;
	}



	//getter/setter
	public BigDecimal getStdlohn() {
		return stdlohn;
	}
	
	public void setStdlohn(BigDecimal stdlohn) {
		this.stdlohn = stdlohn;
		//super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	public BigDecimal getStdzahl() {
		return stdzahl;
	}
	
	public void setStdzahl(BigDecimal stdzahl) {
		this.stdzahl = stdzahl;
		//super.setGehalt(stdlohn.multiply(stdzahl));
	}
	
	//optionale Methode: getGehalt
	public BigDecimal getGehalt() {
		return stdlohn.multiply(stdzahl);
	}


	//Standardmethoden
	@Override
	public String toString() {
		return "Arbeiter [stdlohn=" + stdlohn + ", stdzahl=" + stdzahl + ", Mitarbeiter="+ super.toString() + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((stdlohn == null) ? 0 : stdlohn.hashCode());
		result = prime * result + ((stdzahl == null) ? 0 : stdzahl.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbeiter other = (Arbeiter) obj;
		if (stdlohn == null) {
			if (other.stdlohn != null)
				return false;
		} else if (!stdlohn.equals(other.stdlohn))
			return false;
		if (stdzahl == null) {
			if (other.stdzahl != null)
				return false;
		} else if (!stdzahl.equals(other.stdzahl))
			return false;
		return true;
	}
	
	

}
