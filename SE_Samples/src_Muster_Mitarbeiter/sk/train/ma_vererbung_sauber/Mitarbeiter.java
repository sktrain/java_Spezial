package sk.train.ma_vererbung_sauber;

import java.time.LocalDate;

public class Mitarbeiter {
	
	//statische Elemente
	private static int zaehler = 100000;
	
	//Datenattribute
	private String persnr;
	private String vorname;
	private String nachname;
	private LocalDate gebdatum;
	private LocalDate einstdatum;
	//private BigDecimal gehalt;
	
	private Geschlecht ges = Geschlecht.D;  //default
	
	
	//Konstruktoren
	public Mitarbeiter(String vorname, String nachname, LocalDate gebdatum, 
			           LocalDate einstdatum) {
		super();
		this.persnr = "PO"+zaehler;
		++zaehler;
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebdatum = gebdatum;
		this.einstdatum = einstdatum;
		//this.gehalt = gehalt;
		
	}
	
	public Mitarbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			Geschlecht ges) {
		this(vorname, nachname, gebdatum, einstdatum);
		this.ges = ges;
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
	
		
	public Geschlecht getGes() {
		return ges;
	}

	public void setGes(Geschlecht ges) {
		this.ges = ges;
	}
	
	
	//überschriebene Standardmethoden

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((einstdatum == null) ? 0 : einstdatum.hashCode());
		result = prime * result + ((gebdatum == null) ? 0 : gebdatum.hashCode());
		result = prime * result + ((ges == null) ? 0 : ges.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((persnr == null) ? 0 : persnr.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Mitarbeiter other = (Mitarbeiter) obj;
		if (einstdatum == null) {
			if (other.einstdatum != null)
				return false;
		} else if (!einstdatum.equals(other.einstdatum))
			return false;
		if (gebdatum == null) {
			if (other.gebdatum != null)
				return false;
		} else if (!gebdatum.equals(other.gebdatum))
			return false;
		if (ges != other.ges)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (persnr == null) {
			if (other.persnr != null)
				return false;
		} else if (!persnr.equals(other.persnr))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [persnr=" + persnr + ", vorname=" + vorname + ", nachname=" + nachname + ", gebdatum="
				+ gebdatum + ", einstdatum=" + einstdatum + ", ges=" + ges + "]";
	}	

}
