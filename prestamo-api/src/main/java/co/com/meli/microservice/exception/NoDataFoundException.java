/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * Exceptions that catch the errors produced on the persistence layer when no
 * information is returned when querying.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public class NoDataFoundException extends RuntimeException {

    private static final long serialVersionUID = 7321304689695952264L;

    /**
     * Class constructor.
     */
    public NoDataFoundException() {
        super();
    }

    /**
     * Class constructor specifying error message to return.
     * 
     * @param message
     *            with error.
     */
    public NoDataFoundException(String message) {
        super(message);
    }

}
