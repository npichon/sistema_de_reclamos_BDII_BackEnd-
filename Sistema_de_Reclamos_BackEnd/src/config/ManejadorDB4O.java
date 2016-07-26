package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import modelos.Categoria;
import modelos.Ciudadano;
import modelos.Direccion;
import modelos.Estado;
import modelos.EstadoReclamo;
import modelos.Reclamo;
import modelos.Twitt;
import modelos.Ventaja;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.Db4oException;
import com.db4o.query.Predicate;
import com.db4o.ta.TransparentPersistenceSupport;


public class ManejadorDB4O {

	static ManejadorDB4O instancia = null;
	static ObjectContainer db = null;
	static ObjectContainer session = null;

	private ManejadorDB4O() {
		abrir();
	}

	public static synchronized ManejadorDB4O getInstancia() {
		if (instancia == null){
			instancia = new ManejadorDB4O();
		}else{
			//instancia.abrir();
			session = db.ext().openSession();
		}
		return instancia;
	}

	private void abrir() {
		// Creamos un Objeto de tipo Properties
		// Cargamos el archivo desde la ruta especificada
		Properties propiedades = new Properties();		
		try {
			propiedades.load(getClass().getResourceAsStream("configuracion.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String nombreDB = propiedades.getProperty("ruta") + "sistema_de_reclamos.db4o";
		
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentPersistenceSupport());
		config.common().objectClass(Ciudadano.class).cascadeOnUpdate(true);
		config.common().objectClass(Ventaja.class).cascadeOnUpdate(true);
		config.common().objectClass(Reclamo.class).cascadeOnUpdate(true);
		config.common().objectClass(Direccion.class).cascadeOnUpdate(true);
		config.common().objectClass(EstadoReclamo.class).cascadeOnUpdate(true);
		config.common().objectClass(Estado.class).cascadeOnUpdate(true);
		
		try {
			db = Db4oEmbedded.openFile(config, nombreDB);
			session = db.ext().openSession();
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo de base de datos");
		}

	}

	public void guardar(Object obj) {
		db.store(obj);
		db.commit();
		session.close();
	}

	public <T> List<T> query(T obj) throws Db4oException {
		List<T> resultado = new ArrayList<T>();
		ObjectSet<T> objs = db.queryByExample(obj);

		while (objs.hasNext()) {
			resultado.add(objs.next());
		}
		session.close();
		return resultado;
	}

	public <T> List<T> conditionQuery(Predicate pred) {
		/*List<T> resultado = new ArrayList<T>();
		ObjectSet<T> objs = db.query(pred);

		while (objs.hasNext()) {
			resultado.add(objs.next());
		}*/
		List<T> resultado = db.query(pred);
		session.close();
		return resultado;
	}

	public void eliminar(Object obj) {
		db.delete(obj);
		db.commit();
		session.close();
	}

}
