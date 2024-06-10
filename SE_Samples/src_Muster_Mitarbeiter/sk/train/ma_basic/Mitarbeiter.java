package sk.train.ma_basic;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mitarbeiter {
	
	//Datenattribute
	private String persnr;
	private String vorname;
	private String nachname;
	private LocalDate gebdatum;
	private LocalDate einstdatum;
	private BigDecimal gehalt;
	
	
	//Konstruktoren
	public Mitarbeiter(int persnr, String vorname, String nachname, LocalDate gebdatum,
                       LocalDate einstdatum, BigDecimal gehalt) {
		super();
		this.persnr = "PO"+persnr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebdatum = gebdatum;
		this.einstdatum = einstdatum;
		this.gehalt = gehalt;
	}	
	


	//Getter/Setter
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getPersnr() {
		return persnr;
	}

	public LocalDate getGebdatum() {
		return gebdatum;
	}

	public LocalDate getEinstdatum() {
		return einstdatum;
	}
	
	public BigDecimal getGehalt() {
		return gehalt;
	}
	
	public void setGehalt(BigDecimal gehalt) {
		this.gehalt = gehalt;
	}
	
}
