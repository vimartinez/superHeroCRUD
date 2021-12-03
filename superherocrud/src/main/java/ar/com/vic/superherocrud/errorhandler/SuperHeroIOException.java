package ar.com.vic.superherocrud.errorhandler;

public class SuperHeroIOException extends RuntimeException {

	private static final long serialVersionUID = 5322849432091874237L;
	
	public SuperHeroIOException (String message) {
		super ("No se pudo guardar el objeto: "+ message);
	}

}
