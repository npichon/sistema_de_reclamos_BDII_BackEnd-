package daos;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import modelos.Reclamo;

import com.db4o.query.Predicate;

import config.ManejadorDB4O;
import interfaces.ReclamoInterface;

public class ReclamoDao implements ReclamoInterface{

	

	public Reclamo getById(String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Reclamo> result = db.conditionQuery(new Predicate<Reclamo>() {
			public boolean match(Reclamo reclamo) {
				return reclamo.getId() == id;
			}
		});
		return result.get(0);
	}

	public List<Reclamo> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Reclamo> result = db.query(new Reclamo());
		return result;
	}

	public String save(Reclamo reclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		reclamo.setId(UUID.randomUUID().toString());
		db.guardar(reclamo);
		return reclamo.getId(); 
	}

	public void update(Reclamo reclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(reclamo);	
	}

	public void delete(Reclamo reclamo) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(reclamo);	
	}

	public List<Reclamo> getByDniCiudadano(int condition) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		Predicate pred = new Predicate<Reclamo>() {
			public boolean match(Reclamo reclamo) {
				return reclamo.getCiudadano().getDni() == condition;
			}
		};
		List<Reclamo> result = db.conditionQuery(pred);
		return result;
	}

	public int saveByTwitter(Reclamo reclamo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
