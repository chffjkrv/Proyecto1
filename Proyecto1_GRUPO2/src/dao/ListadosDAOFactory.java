package dao;
import servicios.I_Listados;

public class ListadosDAOFactory {
	public I_Listados ListadosDAO() {
		return new ListarDAOJDBCImpl();
	}
}
