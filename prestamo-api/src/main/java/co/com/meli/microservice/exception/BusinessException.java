/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * Exceptions that catch errors in business logic validations.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -9116300512025547202L;

    /**
     * Class constructor.
     */
    public BusinessException() {
        super();
    }

    /**
     * Class constructor specifying error message to return.
     * 
     * @param message
     *            with error.
     */
    public BusinessException(String message) {
        super(message);
    }

}
