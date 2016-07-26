/**
 * 
 */
package interfaces;

import java.sql.SQLException;

import modelos.Categoria;

/**
 * @author Nahuel Pichón
 *
 */
public interface CategoriaInterface extends GenericInterface<Categoria>{

	/**
	 * @param nombreCategoria
	 * @return una categoria segun su nombre, si hay varias retornara la primera
	 * @throws SQLException
	 */
	Categoria getByNombre(String nombreCategoria) throws SQLException;
	
}
