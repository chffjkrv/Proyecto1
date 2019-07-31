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

    public DAOException(String message) {
        super(message);
        logger.warn(message);
        logger.error(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
        logger.warn(cause);
        logger.error(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
        logger.warn(message,cause);
        logger.error(message, cause);
    }
}