package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import modelos.Ciudadano;
import modelos.Direccion;

import com.db4o.query.Predicate;

import config.ManejadorDB4O;
import interfaces.CiudadanoInterface;

public class CiudadanoDao implements CiudadanoInterface{

	public Ciudadano setear(Ciudadano ciudadano) throws SQLException {
		ReclamoDao daoreclamos = new ReclamoDao();
		VentajaDao daoventaja = new VentajaDao();
		ciudadano.setReclamos(daoreclamos.getByDniCiudadano(ciudadano.getDni()));
		ciudadano.setVentajas(daoventaja.getByPuntajeCiudadano(ciudadano.getPuntos()));
		return ciudadano;
	}

	public Ciudadano getById(String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ciudadano> result = db.conditionQuery(new Predicate<Ciudadano>() {
			public boolean match(Ciudadano ciudadano) {
				return ciudadano.getId().equals(id);
			}
		});
		return result.get(0);
	}

	public List<Ciudadano> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ciudadano> result = db.query(new Ciudadano());
		return result;
	}

	public String save(Ciudadano ciudadano) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		ciudadano.setId(UUID.randomUUID().toString());
		db.guardar(ciudadano);
		return ciudadano.getId(); 
	}

	public void update(Ciudadano ciudadano) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(ciudadano);
	}

	public void delete(Ciudadano ciudadano) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.eliminar(ciudadano);	
	}

	public List<Ciudadano> getByDni(final int dni) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Ciudadano> result = db.conditionQuery(new Predicate<Ciudadano>() {
			public boolean match(Ciudadano ciudadano){
				return ciudadano.getDni() == dni;
			}
		});
		return result;
	}

	public Ciudadano getByCuentaTwitter(String cuentaTwitter)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
