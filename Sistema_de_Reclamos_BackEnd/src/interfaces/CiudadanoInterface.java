/**
 * 
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;

import modelos.Ciudadano;

/**
 * @author Nahuel
 *
 */
public interface CiudadanoInterface extends GenericInterface<Ciudadano> {

	/**
	 * @param cuentaTwitter
	 *            - String con el nombre de usuario de twitter
	 * @return retornará un Ciudadano
	 * @throws SQLException 
	 */
	Ciudadano getByCuentaTwitter(String cuentaTwitter) throws SQLException;
	
	/**
	 * @param condition
	 *            - de tipo integer
	 * @return lista de objetos de tipo <T>
	 * @throws SQLException
	 */
	List<Ciudadano> getByDni(int condition) throws SQLException;


}
