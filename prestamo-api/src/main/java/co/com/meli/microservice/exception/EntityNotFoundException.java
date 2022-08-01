/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * @author juan.mosquera
 *
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -7704022231180830052L;

    /**
     * 
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     * @param message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
