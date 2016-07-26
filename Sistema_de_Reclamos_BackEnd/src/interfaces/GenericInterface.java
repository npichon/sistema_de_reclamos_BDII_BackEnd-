package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface GenericInterface<T> {

	/**
	 * @param datos
	 * @return
	 * @throws SQLException
	 */
	//T setear(T datos) throws SQLException;

	/**
	 * @param id
	 *            - del objeto a retornar
	 * @return retornará un elemento de tipo <T>
	 * @throws SQLException
	 */
	T getById(String id) throws SQLException;

	/**
	 * @return Lista de objetosde tipo <T>
	 * @throws SQLException
	 */
	List<T> getList() throws SQLException;

	/**
	 * @param object
	 *            - Objeto de tipo <T>
	 * @param foreignKey
	 *            - Parametro necesário para entidades con relaciones One to One
	 * @return Id de la entidad guardada recientemente
	 * @throws SQLException
	 */
	String save(T object) throws SQLException;

	/**
	 * @param object
	 *            - Objeto de tipo <T>
	 * @param foreignKey
	 *            - Parametro necesário para entidades con relaciones One to One
	 * @throws SQLException
	 */
	void update(T object) throws SQLException;

	/**
	 * @param object
	 *            - Objeto de tipo <T>
	 * @throws SQLException
	 */
	void delete(T object) throws SQLException;


}
