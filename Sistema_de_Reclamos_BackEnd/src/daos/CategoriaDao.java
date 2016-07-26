package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.db4o.query.Predicate;

import modelos.Categoria;
import modelos.Ciudadano;
import config.ManejadorDB4O;
import interfaces.CategoriaInterface;

public class CategoriaDao implements CategoriaInterface {


	public Categoria getById(final String id) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Categoria> result = db.conditionQuery(new Predicate<Categoria>() {
			public boolean match(Categoria categoria) {
				return categoria.getId().equals(id);
			}
		});
		return result.get(0);
	}

	public List<Categoria> getList() throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		List<Categoria> result = db.query(new Categoria());
		return result;
	}

	public String save(Categoria categoria) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		categoria.setId(UUID.randomUUID().toString());
		db.guardar(categoria);
		return categoria.getId(); 

	}

	public void update(Categoria categoria) throws SQLException {
		ManejadorDB4O db = ManejadorDB4O.getInstancia();
		db.guardar(categoria);	
	}

	public void delete(Categoria object) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	public Categoria getByNombre(String nombreCategoria) throws SQLException {
		return null;
	}

}
