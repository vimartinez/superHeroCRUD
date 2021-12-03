package ar.com.vic.superherocrud.errorhandler;

public class SuperHeroException extends RuntimeException {

	private static final long serialVersionUID = -3188364463653501302L;

	public SuperHeroException(String message) {
		super ("SuperHeroException: "+message);
	}
	
}
