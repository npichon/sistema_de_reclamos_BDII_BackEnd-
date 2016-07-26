/**
 * 
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;

import modelos.Ciudadano;
import modelos.Reclamo;

/**
 * @author Nahuel
 *
 */
public interface ReclamoInterface extends GenericInterface<Reclamo>{

	/**
	 * @param reclamo
	 * @return id del reclamo
	 * @throws SQLException 
	 */
	int saveByTwitter(Reclamo reclamo) throws SQLException;
	
	/**
	 * @param condition
	 *            - de tipo integer
	 * @return lista de objetos de tipo <T>
	 * @throws SQLException
	 */
	List<Reclamo> getByDniCiudadano(int condition) throws SQLException;

}
