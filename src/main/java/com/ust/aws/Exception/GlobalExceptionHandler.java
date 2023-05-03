package com.ust.aws.Exception;


import com.ust.aws.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NoUserFoundException.class)
    public ResponseEntity<?> handleNoUserFoundException(NoUserFoundException ex
                                                                       ) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
    @ExceptionHandler(value=BlogAlreadyExist.class)
    public ResponseEntity<?> handleNoUserFoundException(BlogAlreadyExist ex)
                                                                        {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Niiiii");
    }
}
