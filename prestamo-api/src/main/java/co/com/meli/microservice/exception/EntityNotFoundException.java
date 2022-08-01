/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * Exceptions that capture the errors produced on the persistence layer when the
 * entities are not returned correctly.
 * 
 * @see 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7704022231180830052L;

    /**
     * Class constructor.
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     * Class constructor specifying error message to return.
     * 
     * @param message
     *            with error.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
