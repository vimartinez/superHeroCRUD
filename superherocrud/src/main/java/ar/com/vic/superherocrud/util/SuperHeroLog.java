package ar.com.vic.superherocrud.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ar.com.vic.superherocrud.enums.LogType;

public class SuperHeroLog {
	private static Logger log = Logger.getLogger(SuperHeroLog.class);

	@SuppressWarnings("rawtypes")
	public static void registrarInfo(Class clase, LogType tipo, String mensaje)
	{
	 log = LogManager.getLogger(clase);
	 
	 switch (tipo) 
	 {
	  case DEBUG:
	   log.debug(mensaje);
	   break;
	  case ERROR:
	   log.error(mensaje);
	   break;
	  case FATAL:
	   log.fatal(mensaje);
	   break;
	  case INFO:
	   log.info(mensaje);
	   break;
	  case WARNING:
	   log.warn(mensaje);
	 }
	}

}
