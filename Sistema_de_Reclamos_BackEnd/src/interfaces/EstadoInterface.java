package interfaces;

import modelos.Estado;

/**
 * @author Nahuel
 *
 */
public interface EstadoInterface extends GenericInterface<Estado> {

	Estado getByNombre(String string);
	
}
