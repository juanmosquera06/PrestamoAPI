/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * @author juan.mosquera
 *
 */
public class NoDataFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 7321304689695952264L;

    /**
     * 
     */
    public NoDataFoundException() {
        super();
    }

    /**
     * @param message
     */
    public NoDataFoundException(String message) {
        super(message);
    }

}
