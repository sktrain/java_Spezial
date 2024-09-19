package beans;



import ifaces.Instrument;

public class Klavier implements Instrument{
	
	public Klavier(){
		super();
	}
	
	public void play() {
		System.out.println("Klavierklänge von " + this);
	}
}

