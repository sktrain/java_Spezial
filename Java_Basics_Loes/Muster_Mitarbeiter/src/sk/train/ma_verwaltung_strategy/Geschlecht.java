package sk.train.ma_verwaltung_strategy;

public enum Geschlecht { 
	W, M, D;

	@Override
	public String toString() {
		
		switch ( this ) {

	      case W : return "weiblich";

	      case M : return "männlich";

	      default: return "divers";

	    }
	}
	
}
