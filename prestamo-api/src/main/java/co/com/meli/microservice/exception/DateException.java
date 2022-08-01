/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * Exceptions that catch errors in date format validations.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public class DateException extends RuntimeException {

    private static final long serialVersionUID = 9034538944013040141L;

    /**
     * Class constructor.
     */
    public DateException() {
        super();
    }

    /**
     * Class constructor specifying error message to return.
     * 
     * @param message
     *            with error.
     */
    public DateException(String message) {
        super(message);
    }

}
