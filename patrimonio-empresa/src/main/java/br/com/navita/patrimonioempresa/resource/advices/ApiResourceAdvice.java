package br.com.navita.patrimonioempresa.resource.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.navita.patrimonioempresa.exceptions.MarcaAlreadyExistsException;
import br.com.navita.patrimonioempresa.exceptions.MarcaNotFoundException;
import br.com.navita.patrimonioempresa.exceptions.PatrimonioNotFoundException;
import br.com.navita.patrimonioempresa.exceptions.UserAlreadyExistException;
import br.com.navita.patrimonioempresa.resource.MarcaResource;
import br.com.navita.patrimonioempresa.resource.PatrimonioResource;
import br.com.navita.patrimonioempresa.resource.UserResource;

@ControllerAdvice(
		assignableTypes = {UserResource.class, 
			MarcaResource.class, 
			PatrimonioResource.class})
public class ApiResourceAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		return ex.getBindingResult().getFieldError().getField() + " - "
				+ ex.getBindingResult().getFieldError().getDefaultMessage();
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Error>  handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

		return new ResponseEntity<Error>(new Error(ex.getClass().getSimpleName(), ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<Error>  handleException(Exception ex) {
		return new ResponseEntity<Error>(new Error(ex.getClass().getSimpleName(), ex.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Error> handleIllegalArgumentException(RuntimeException ex) {
		return new ResponseEntity<Error>(new Error(ex.getClass().getSimpleName(), ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({MarcaAlreadyExistsException.class, UserAlreadyExistException.class})
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public ResponseEntity<Error> handleResourceConflitException(RuntimeException ex) {
		return new ResponseEntity<Error>(new Error(ex.getClass().getSimpleName(), ex.getLocalizedMessage()), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler({MarcaNotFoundException.class, PatrimonioNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Error> handleResourceNotFoundException(RuntimeException ex) {
		return new ResponseEntity<Error>(new Error(ex.getClass().getSimpleName(), ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
	}

	

}
