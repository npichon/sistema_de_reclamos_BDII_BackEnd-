package modelos;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Categoria implements Activatable {

	protected String id;
	protected String nombre;
	protected String descripcion;
	protected int puntaje;
	private transient Activator _activator;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(String nombre, String descripcion, int puntaje) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntaje = puntaje;
	}

	public Categoria(String id, String nombre, String descripcion, int puntaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntaje = puntaje;
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

	public int getPuntaje() {
		activate(ActivationPurpose.READ);
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		activate(ActivationPurpose.WRITE);
		this.puntaje = puntaje;
	}
	
	@SuppressWarnings("unused")
	private void print() {
		System.out.println("Id: " + id + "/n"
				          +"Nombre: " + nombre + "/n"
				          +"Descripcion: " + descripcion + "/n"
				          +"Puntaje: " + puntaje + "/n");
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
