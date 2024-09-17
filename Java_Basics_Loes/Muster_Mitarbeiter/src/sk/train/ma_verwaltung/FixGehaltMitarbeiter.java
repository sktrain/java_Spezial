package sk.train.ma_verwaltung;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FixGehaltMitarbeiter extends Mitarbeiter{
    
	//Datenattribute
	private BigDecimal gehalt;
	
	//Konstruktoren
	public FixGehaltMitarbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			BigDecimal gehalt) {
		super(vorname, nachname, gebdatum, einstdatum);
		this.gehalt = gehalt;
	}
	
	
	
	public FixGehaltMitarbeiter(String vorname, String nachname, LocalDate gebdatum, LocalDate einstdatum,
			Geschlecht geschlecht, BigDecimal gehalt) {
		super(vorname, nachname, gebdatum, einstdatum, geschlecht);
		this.gehalt = gehalt;
	}



	//Getter/Setter
	public BigDecimal getGehalt() {
		return gehalt;
	}

	public void setGehalt(BigDecimal gehalt) {
		this.gehalt = gehalt;
	}


	//Standardmethoden
	@Override
	public String toString() {
		return "FixGehaltMitarbeiter [gehalt=" + gehalt + ", Mitarbeiter="+ super.toString() + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gehalt == null) ? 0 : gehalt.hashCode());
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
		FixGehaltMitarbeiter other = (FixGehaltMitarbeiter) obj;
		if (gehalt == null) {
			if (other.gehalt != null)
				return false;
		} else if (!gehalt.equals(other.gehalt))
			return false;
		return true;
	}
	
	
}
