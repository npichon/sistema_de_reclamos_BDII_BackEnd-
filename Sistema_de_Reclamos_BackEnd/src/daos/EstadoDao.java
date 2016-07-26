package daos;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.db4o.query.Predicate;

import modelos.Estado;
import config.ManejadorDB4O;
import interfaces.EstadoInterface;

public class EstadoDao implements EstadoInterface{


	public Estado getById(final String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Estado> result = db.conditionQuery(new Predicate<Estado>() {
			public boolean match(Estado estado) {
				return estado.getId().equals(id);
			}
		});
		return result.get(0);
	}

	public List<Estado> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Estado> result = db.query(new Estado());
		return result;
	}

	public String save(Estado estado) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		estado.setId(UUID.randomUUID().toString());
		db.guardar(estado);
		return estado.getId(); 
	}

	public void update(Estado estado) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(estado);	
	}

	public void delete(Estado estado) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.eliminar(estado);	
	}

	public Estado getByNombre(String condition){
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Estado> result = db.conditionQuery(new Predicate<Estado>() {
			public boolean match(Estado estado) {
				return estado.getNombre().equals(condition);
			}
		});
		return result.get(0);
	}

}
