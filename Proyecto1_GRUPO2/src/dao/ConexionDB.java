package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	Connection connection = null;
    String BD = "proyecto1g2bd2";
    String driverClassName = "com.mysql.jdbc.Driver";
    String driverUrl = "jdbc:mysql://10.90.36.105:3306/"+BD+"?autoReconnect=true&useSSL=false";
    String user = "root";
    String password = "root";

    public ConexionDB() throws DAOException {
        try {
          
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, user, password);
        } catch (ClassNotFoundException e) {
        	throw new DAOException("No se encuentra el driver",e);
        } catch (SQLException e) {
        	throw new DAOException("Excepcion SQL: " + e.getMessage(),e);
			/*
			 * System.out.println("Estado SQL: " + e.getSQLState());
			 * System.out.println("Codigo del Error: " + e.getErrorCode());
			 * System.out.println("ERROR. No se puede conectar con la Bases de Datos: " +
			 * e); System.exit(-1);
			 */
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws DAOException {
        try {
            connection.close();
        } catch (SQLException se) {
        	throw new DAOException("Exception closing Connection: ",se);
        }

}
}
