/**
 * 
 */
package co.com.meli.microservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.meli.microservice.dto.ErrorResponseModel;

/**
 * Allows to handle exceptions across the whole application in one global
 * handling component.
 * 
 * @see 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    /**
     * Interceptor of exceptions thrown by methods that contains
     * EntityNotFoundException.
     * 
     * @param ex
     *            exception.
     * @param request
     *            web request.
     * @return an entity that contains information about exception.
     * @see EntityNotFoundException
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex, WebRequest request) {

        this.logger.error(ex.getMessage());

        ErrorResponseModel response = new ErrorResponseModel();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setError(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Interceptor of exceptions thrown by methods that contains
     * NoDataFoundException.
     * 
     * @param ex
     *            exception.
     * @param request
     *            web request.
     * @return an entity that contains information about exception.
     * @see NoDataFoundException
     */
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(
            NoDataFoundException ex, WebRequest request) {

        this.logger.error(ex.getMessage());
        
        ErrorResponseModel response = new ErrorResponseModel();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setError(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Interceptor of exceptions thrown by methods that contains
     * BusinessException.
     * 
     * @param ex
     *            exception.
     * @param request
     *            web request.
     * @return an entity that contains information about exception.
     * @see BusinessException
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(
            BusinessException ex, WebRequest request) {

        this.logger.error(ex.getMessage());

        ErrorResponseModel response = new ErrorResponseModel();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setError(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    /**
     * Interceptor of exceptions thrown by methods that contains DateException.
     * 
     * @param ex
     *            exception.
     * @param request
     *            web request.
     * @return an entity that contains information about exception.
     * @see DateException
     */
    @ExceptionHandler(DateException.class)
    public ResponseEntity<Object> handleDateException(DateException ex,
            WebRequest request) {

        this.logger.error(ex.getMessage());

        ErrorResponseModel response = new ErrorResponseModel();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setError(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
