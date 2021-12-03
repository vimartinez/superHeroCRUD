package ar.com.vic.superherocrud.errorhandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;

import javax.persistence.EntityNotFoundException;
import java.net.BindException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class SuperHeroControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({SuperHeroNotFoundException.class})
	public SuperHeroResponseObject handleSuperHeroNotFoundException(SuperHeroNotFoundException e){
		SuperHeroResponseObject response = new SuperHeroResponseObject();
		response.setStatus("ok");
		response.setStatusMessage("Consulta realizada");
		response.setData(e.getMessage());
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({Exception.class})
	public SuperHeroResponseObject handleSuperHeroBadRequestException(SuperHeroException e){
		SuperHeroResponseObject response = new SuperHeroResponseObject();
		response.setStatus("ok");
		response.setStatusMessage(BAD_REQUEST.name());
		response.setData(e.getMessage());
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler({SuperHeroIOException.class})
	public SuperHeroResponseObject handleSuperHeroIOException(SuperHeroIOException e){
		SuperHeroResponseObject response = new SuperHeroResponseObject();
		response.setStatus("ok");
		response.setStatusMessage(I_AM_A_TEAPOT.name());
		response.setData(e.getMessage());
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public  SuperHeroResponseObject handMethodArgumentNotValidException(final Exception e,final HttpServletRequest request) {

		SuperHeroResponseObject response = new SuperHeroResponseObject();
		response.setStatus("ok");
		response.setStatusMessage(METHOD_NOT_ALLOWED.name());
		response.setPath(request.getPathInfo());
		response.setData(e.getMessage());
		return response;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({BindException.class})
	public SuperHeroResponseObject handleSuperHeroException(SuperHeroException e){
		SuperHeroResponseObject response = new SuperHeroResponseObject();
		response.setStatus("error");
		response.setStatusMessage(INTERNAL_SERVER_ERROR.name());
		response.setData(e.getMessage());
		return response;
	}
	

/*
@ControllerAdvice
public class SuperHeroControllerAdvice extends ResponseEntityExceptionHandler {
	
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value ={ 
			BindException.class, 
	//		MethodArgumentNotValidException.class,
	//		MissingServletRequestParameterException.class,
	//		ConstraintViolationException.class, 
	//		MethodArgumentTypeMismatchException.class, 
	//		HttpMessageNotReadableException.class 
			})
    public SuperHeroException handleBadRequestException(Exception e) {
		SuperHeroException response = new SuperHeroException(BAD_REQUEST.value(),new Date(System.currentTimeMillis()),"Error en la Invocación" + e.getMessage());
		return response;
    }
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	public  SuperHeroException handMethodUniqueException(final Exception e,	final HttpServletRequest request) {
		
		SuperHeroException error = new SuperHeroException(CONFLICT.value(),new Date(System.currentTimeMillis()),"Conflicto!" + e.getMessage());

		//logger.error(HttpStatus.CONFLICT.getReasonPhrase(),e);
		
		return error;
	}
	/*
	@ResponseBody
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public  SuperHeroException handMethodArgumentNotValidException(final Exception e,final HttpServletRequest request) {

		SuperHeroException error = new SuperHeroException(METHOD_NOT_ALLOWED.value(),new Date(System.currentTimeMillis()),"mETHOD NOT ALLOWED!" + e.getMessage());
		//logger.error(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),e);

		return error;
	}
	

	*/

}
