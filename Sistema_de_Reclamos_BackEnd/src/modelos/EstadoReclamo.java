package modelos;

import java.sql.Timestamp;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class EstadoReclamo implements Activatable {
	protected String id;
	protected String detalle;
	protected Timestamp fecha;
	protected Estado estado;
	private transient Activator _activator;

	public EstadoReclamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoReclamo(String detalle, Timestamp fecha, Estado estado) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estado = estado;
	}

	public EstadoReclamo(String id, String detalle, Timestamp fecha, Estado estado) {
		super();
		this.id = id;
		this.detalle = detalle;
		this.fecha = fecha;
		this.estado = estado;
	}

	public String getId() {
		activate(ActivationPurpose.READ);
		return id;
	}

	public void setId(String id) {
		activate(ActivationPurpose.WRITE);
		this.id = id;
	}

	public String getDetalle() {
		activate(ActivationPurpose.READ);
		return detalle;
	}

	public void setDetalle(String detalle) {
		activate(ActivationPurpose.WRITE);
		this.detalle = detalle;
	}

	public Timestamp getFecha() {
		activate(ActivationPurpose.READ);
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		activate(ActivationPurpose.WRITE);
		this.fecha = fecha;
	}

	public Estado getEstado() {
		activate(ActivationPurpose.READ);
		return estado;
	}

	public void setEstado(Estado estado) {
		activate(ActivationPurpose.WRITE);
		this.estado = estado;
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
