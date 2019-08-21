package dao;
/**
 * 
 * @author Grupo2
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAOException extends Exception {
	
	

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger();

	public DAOException() {
        super();
    }

	/**
	 * Sirve para imprimir en logger los errores y warning con el mensaje
	 * @param message: recibe un string
	 */
    public DAOException(String message) {
        super(message);
        logger.warn(message);
        logger.error(message);
    }

    /**
     * Sirve para imprimir en logger los errores y warning con la causa
     * @param cause: recibe un theowable
     */
    public DAOException(Throwable cause) {
        super(cause);
        logger.warn(cause);
        logger.error(cause);
    }
    
    /**
     * Sirve para imprimir en logger los errores y warning con el mensaje y la causa
     * @param message: recibe un string
     * @param cause: recibe un throwable
     */

    public DAOException(String message, Throwable cause) {
        super(message, cause);
        logger.warn(message,cause);
        logger.error(message, cause);
    }
}