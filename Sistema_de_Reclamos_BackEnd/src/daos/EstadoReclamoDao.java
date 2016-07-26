package daos;

import interfaces.EstadoReclamoInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.db4o.query.Predicate;

import modelos.EstadoReclamo;
import config.ManejadorDB4O;

public class EstadoReclamoDao implements EstadoReclamoInterface {

	public EstadoReclamoDao() {
	}

	public EstadoReclamo setear(EstadoReclamo datos) throws SQLException {
		return null;
	}

	public EstadoReclamo getById(String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<EstadoReclamo> result = db.conditionQuery(new Predicate<EstadoReclamo>() {
			public boolean match(EstadoReclamo estadoReclamo) {
				return estadoReclamo.getId() == id;
			}
		});
		return result.get(0);
	}

	public List<EstadoReclamo> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<EstadoReclamo> result = db.query(new EstadoReclamo());
		return result;
	}

	public String save(EstadoReclamo estadoReclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		estadoReclamo.setId(UUID.randomUUID().toString());
		db.guardar(estadoReclamo);
		return estadoReclamo.getId();
	}

	public void update(EstadoReclamo estadoReclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(estadoReclamo);
	}

	public void delete(EstadoReclamo estadoReclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.eliminar(estadoReclamo);
	}

	public List<EstadoReclamo> getByCondicion(int idReclamo)
			throws SQLException {
		return null;
	}
}
