/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * @author juan.mosquera
 *
 */
public class DateException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 9034538944013040141L;

    /**
     * 
     */
    public DateException() {
        super();
    }

    /**
     * @param message
     */
    public DateException(String message) {
        super(message);
    }

}
