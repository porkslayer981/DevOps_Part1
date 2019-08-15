package cox.ryan.exerciselog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfiguration 
	extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value=NoSuchEntityException.class)
    private ResponseEntity<Object> handleNoSuchEntityException(
    		NoSuchEntityException ex,
    		WebRequest request) {
		
		Map<String, Object> body = new HashMap<>();
		body.put("id", ex.getId());
		body.put("type", ex.getType());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
}
