/**
 * 
 */
package co.com.meli.microservice.exception;

/**
 * @author juan.mosquera
 *
 */
public class BusinessException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -9116300512025547202L;

    /**
     * 
     */
    public BusinessException() {
        super();
    }

    /**
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

}
