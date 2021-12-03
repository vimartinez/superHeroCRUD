package ar.com.vic.superherocrud.errorhandler;

public class SuperHeroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7341657094422027906L;
	
	public SuperHeroNotFoundException(String message) {
		super ("Objeto no enconrado: "+ message);
	}

}
