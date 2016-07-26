package modelos;

import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Ventaja implements Activatable {
	protected String id;
	protected String nombre;
	protected String descripcion;
	protected int puntosNecesarios;
	private transient Activator _activator;
	
	public Ventaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ventaja(String nombre, String descripcion, int puntosNecesarios) {
		super();
		this.id = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntosNecesarios = puntosNecesarios;
	}

	public Ventaja(String id, String nombre, String descripcion,
			int puntosNecesarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntosNecesarios = puntosNecesarios;
	}

	public String getId() {
		activate(ActivationPurpose.READ);
		return id;
	}

	public void setId(String id) {
		activate(ActivationPurpose.WRITE);
		this.id = id;
	}

	public String getNombre() {
		activate(ActivationPurpose.READ);
		return nombre;
	}

	public void setNombre(String nombre) {
		activate(ActivationPurpose.WRITE);
		this.nombre = nombre;
	}

	public String getDescripcion() {
		activate(ActivationPurpose.READ);
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		activate(ActivationPurpose.WRITE);
		this.descripcion = descripcion;
	}

	public int getPuntosNecesarios() {
		activate(ActivationPurpose.READ);
		return puntosNecesarios;
	}

	public void setPuntosNecesarios(int puntosNecesarios) {
		activate(ActivationPurpose.WRITE);
		this.puntosNecesarios = puntosNecesarios;
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
