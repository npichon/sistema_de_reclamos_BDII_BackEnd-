/**
 * 
 */
package interfaces;

import java.util.List;

import modelos.Ventaja;

/**
 * @author Nahuel
 *
 */
public interface VentajaInterface extends GenericInterface<Ventaja>{

	List<Ventaja> getByPuntajeCiudadano(int puntaje);

}
