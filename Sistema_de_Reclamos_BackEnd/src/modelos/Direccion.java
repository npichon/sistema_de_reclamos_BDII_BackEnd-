package modelos;

import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Direccion implements Activatable {
	protected String id;
	protected String calle;
	protected int numero;
	protected String piso;
	protected String departamento;
	protected String latitud;
	protected String longitud;
	private transient Activator _activator;

	public Direccion() {
	}
	
	public Direccion(String calle, int numero, String piso,
			String departamento, String latitud, String longitud) {
		super();
		this.id = UUID.randomUUID().toString();
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Direccion(String id, String calle, int numero, String piso,
			String departamento, String latitud, String longitud) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getId() {
		activate(ActivationPurpose.READ);
		return id;
	}

	public void setId(String id) {
		activate(ActivationPurpose.WRITE);
		this.id = id;
	}

	public String getCalle() {
		activate(ActivationPurpose.READ);
		return calle;
	}

	public void setCalle(String calle) {
		activate(ActivationPurpose.WRITE);
		this.calle = calle;
	}

	public int getNumero() {
		activate(ActivationPurpose.READ);
		return numero;
	}

	public void setNumero(int numero) {
		activate(ActivationPurpose.WRITE);
		this.numero = numero;
	}

	public String getPiso() {
		activate(ActivationPurpose.READ);
		return piso;
	}

	public void setPiso(String piso) {
		activate(ActivationPurpose.WRITE);
		this.piso = piso;
	}

	public String getDepartamento() {
		activate(ActivationPurpose.READ);
		return departamento;
	}

	public void setDepartamento(String departamento) {
		activate(ActivationPurpose.WRITE);
		this.departamento = departamento;
	}

	public String getLatitud() {
		activate(ActivationPurpose.READ);
		return latitud;
	}

	public void setLatitud(String latitud) {
		activate(ActivationPurpose.WRITE);
		this.latitud = latitud;
	}

	public String getLongitud() {
		activate(ActivationPurpose.READ);
		return longitud;
	}

	public void setLongitud(String longitud) {
		activate(ActivationPurpose.WRITE);
		this.longitud = longitud;
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
