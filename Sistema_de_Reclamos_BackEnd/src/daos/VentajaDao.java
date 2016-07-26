package daos;

import interfaces.VentajaInterface;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import modelos.Ventaja;

import com.db4o.query.Predicate;

import config.ManejadorDB4O;

public class VentajaDao implements VentajaInterface {

	public VentajaDao() {
	}

	public Ventaja setear(Ventaja datos) throws SQLException {
		return datos;
	}

	public Ventaja getById(String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ventaja> result = db.conditionQuery(new Predicate<Ventaja>() {
			public boolean match(Ventaja ventaja) {
				return ventaja.getId() == id;
			}
		});
		return result.get(0);
	}

	public List<Ventaja> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ventaja> result = db.query(new Ventaja());
		return result;
	}

	public String save(Ventaja ventaja) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		ventaja.setId(UUID.randomUUID().toString());
		db.guardar(ventaja);
		return ventaja.getId();
	}

	public void update(Ventaja ventaja) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(ventaja);
	}

	public void delete(Ventaja ventaja) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.eliminar(ventaja);
	}

	public List<Ventaja> getByPuntajeCiudadano(int condition){
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ventaja> result = db.conditionQuery(new Predicate<Ventaja>() {
			public boolean match(Ventaja ventaja) {
				return ventaja.getPuntosNecesarios() == condition;
			}
		});
		return result;
	}
}
