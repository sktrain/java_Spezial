package beans;


import ifaces.Instrument;
import ifaces.Performer;

public class Musiker implements Performer{	
	
	private Instrument i;
	
	public Musiker(Instrument i) {
		this.i = i;
	}
	
	public void perform() {
		System.out.println("Performamce von " + this);
		i.play();
	}
}
