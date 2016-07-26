package daos;

import interfaces.DireccionInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.db4o.query.Predicate;

import modelos.Direccion;
import modelos.Reclamo;
import modelos.Ventaja;
import config.ManejadorDB4O;

public class DireccionDao implements DireccionInterface {

	public DireccionDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Direccion getById(String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Direccion> result = db.conditionQuery(new Predicate<Direccion>() {
			public boolean match(Direccion direccion) {
				return direccion.getId() == id;
			}
		});
		return result.get(0);
	}


	public List<Direccion> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Direccion> result = db.query(new Direccion());
		return result;
	}


	public String save(Direccion direccion) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		direccion.setId(UUID.randomUUID().toString());
		db.guardar(direccion);
		return direccion.getId(); 
	}

	public void update(Direccion direccion) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(direccion);	
	}


	public void delete(Direccion direccion) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.eliminar(direccion);	
	}


	public List<Direccion> getByCondicion(int dni) throws SQLException {
		return null;
	}

}
