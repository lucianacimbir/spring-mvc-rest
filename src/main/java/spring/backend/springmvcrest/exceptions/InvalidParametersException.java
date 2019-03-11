package spring.backend.springmvcrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.criteria.CriteriaBuilder;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParametersException extends RuntimeException{
    public InvalidParametersException(){
        super();
    }

    public InvalidParametersException(String message){
        super(message);
    }

    public InvalidParametersException(String message, Throwable cause){
        super(message, cause);
    }
}
