package beans;

import ifaces.Instrument;

public class Gitarre implements Instrument{
	
	public Gitarre(){
		super();
	}
	
	public void play() {
		System.out.println("Gitarrenklänge");
	}
}