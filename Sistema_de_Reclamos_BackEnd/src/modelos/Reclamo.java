package modelos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

/**
 * @author Nahuel
 *
 */
public class Reclamo implements Activatable  {
	protected String id;
	protected String descripcion;
	protected Direccion ubicacion;
	protected Timestamp fecha;
	protected List<EstadoReclamo> estados;
	protected Categoria categoria;
	protected Ciudadano ciudadano;
	protected String idTwitter;
	private transient Activator _activator;

	/**
	 * 
	 */
	public Reclamo() {
		this.estados = new ArrayList<EstadoReclamo>();
	}

	/**
	 * @param descripcion
	 * @param fecha
	 * @param ubicacion
	 * @param estados
	 * @param categoria
	 * @param ciudadano
	 * @param idTwitter
	 */
	public Reclamo(String descripcion, Timestamp fecha, Direccion ubicacion,
			List<EstadoReclamo> estados, Categoria categoria,
			Ciudadano ciudadano, String idTwitter) {
		super();
		this.id = UUID.randomUUID().toString();
		this.estados = new ArrayList<EstadoReclamo>();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
		this.estados = estados;
		this.categoria = categoria;
		this.ciudadano = ciudadano;
		this.idTwitter = idTwitter;
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param fecha
	 * @param ubicacion
	 * @param estados
	 * @param categoria
	 * @param ciudadano
	 * @param idTwitter
	 */
	public Reclamo(String id, String descripcion, Timestamp fecha,
			Direccion ubicacion, List<EstadoReclamo> estados,
			Categoria categoria, Ciudadano ciudadano, String idTwitter) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
		this.estados = estados;
		this.categoria = categoria;
		this.ciudadano = ciudadano;
		this.idTwitter = idTwitter;
	}

	/**
	 * @return id del reclamos
	 */
	public String getId() {
		activate(ActivationPurpose.READ);
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		activate(ActivationPurpose.WRITE);
		this.id = id;
	}

	/**
	 * @return desripcion del reclamos
	 */
	public String getDescripcion() {
		activate(ActivationPurpose.READ);
		return descripcion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		activate(ActivationPurpose.WRITE);
		this.descripcion = descripcion;
	}

	/**
	 * @return Ubicacion del reclamo
	 */
	public Direccion getUbicacion() {
		activate(ActivationPurpose.READ);
		return ubicacion;
	}

	/**
	 * @param ubicacion 
	 */
	public void setUbicacion(Direccion ubicacion) {
		activate(ActivationPurpose.WRITE);
		this.ubicacion = ubicacion;
	}

	/**
	 * @return Lista de Estados del reclamo
	 */
	public List<EstadoReclamo> getEstados() {
		activate(ActivationPurpose.READ);
		return estados;
	}
	
	/**
	 * @param EstadoReclamoDto 
	 * Agrega Estados al Reclamo
	 */
	public void agregarEstado(EstadoReclamo estadoReclamo){
		estados.add(estadoReclamo);
	}

	/**
	 * @param estados
	 */
	public void setEstados(List<EstadoReclamo> estados) {
		activate(ActivationPurpose.WRITE);
		this.estados = estados;
	}

	/**
	 * @return categoriadel reclamos
	 */
	public Categoria getCategoria() {
		activate(ActivationPurpose.READ);
		return categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		activate(ActivationPurpose.WRITE);
		this.categoria = categoria;
	}

	/**
	 * @return ciudadadno del reclamos
	 */
	public Ciudadano getCiudadano() {
		activate(ActivationPurpose.READ);
		return ciudadano;
	}

	/**
	 * @param ciudadano
	 */
	public void setCiudadano(Ciudadano ciudadano) {
		activate(ActivationPurpose.WRITE);
		this.ciudadano = ciudadano;
	}

	/**
	 * @return fecha del reclamos
	 */
	public Timestamp getFecha() {
		activate(ActivationPurpose.READ);
		return fecha;
	}

	/**
	 * @param fecha
	 */
	public void setFecha(Timestamp fecha) {
		activate(ActivationPurpose.WRITE);
		this.fecha = fecha;
	}

	/**
	 * @return idTwitter del reclamos
	 */
	public String getIdTwitter() {
		activate(ActivationPurpose.READ);
		return idTwitter;
	}

	/**
	 * @param idTwitter
	 */
	public void setIdTwitter(String idTwitter) {
		activate(ActivationPurpose.WRITE);
		this.idTwitter = idTwitter;
	}

	public void activate(ActivationPurpose purpose) {
		if (_activator != null) {
			_activator.activate(purpose);
		}
	}

	public void bind(Activator activator) {
		if (_activator == activator) {
			return;
		}
		if (activator != null && _activator != null) {
			throw new IllegalStateException();
		}
		_activator = activator;
	}

}
