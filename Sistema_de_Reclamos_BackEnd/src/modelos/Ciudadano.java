package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.db4o.activation.ActivationPurpose;
import com.db4o.activation.Activator;
import com.db4o.ta.Activatable;

public class Ciudadano implements Activatable {
	protected String id = null;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected String email;
	protected String cuentaTwitter;
	protected String telefono;
	protected int puntos;
	protected List<Ventaja> ventajas;
	protected List<Reclamo> reclamos;
	protected Direccion direccion;
	private transient Activator _activator;

	public Ciudadano() {
		super();
		this.ventajas = new ArrayList<Ventaja>();
		this.reclamos = new ArrayList<Reclamo>();
	}

	public Ciudadano(String nombre, String apellido, int dni, String email,
			String cuentaTwitter, String telefono, int puntos,Direccion direccion) {
		super();
		this.id = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.cuentaTwitter = cuentaTwitter;
		this.telefono = telefono;
		this.puntos = puntos;
		this.direccion = direccion;
	}

	public Ciudadano(String id, String nombre, String apellido, int dni,
			String email, String cuentaTwitter, String telefono, int puntos,
			List<Ventaja> ventajas, List<Reclamo> reclamos, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.cuentaTwitter = cuentaTwitter;
		this.telefono = telefono;
		this.puntos = puntos;
		this.ventajas = ventajas;
		this.reclamos = reclamos;
		this.direccion = direccion;
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

	public String getApellido() {
		activate(ActivationPurpose.READ);
		return apellido;
	}

	public void setApellido(String apellido) {
		activate(ActivationPurpose.WRITE);
		this.apellido = apellido;
	}

	public int getDni() {
		activate(ActivationPurpose.READ);
		return this.dni;
	}

	public void setDni(int dni) {
		activate(ActivationPurpose.WRITE);
		this.dni = dni;
	}

	public String getEmail() {
		activate(ActivationPurpose.READ);
		return email;
	}

	public void setEmail(String email) {
		activate(ActivationPurpose.WRITE);
		this.email = email;
	}

	public String getCuentaTwitter() {
		activate(ActivationPurpose.READ);
		return cuentaTwitter;
	}

	public void setCuentaTwitter(String cuentaTwitter) {
		activate(ActivationPurpose.WRITE);
		this.cuentaTwitter = cuentaTwitter;
	}

	public int getPuntos() {
		activate(ActivationPurpose.READ);
		return puntos;
	}

	public void setPuntos(int puntos) {
		activate(ActivationPurpose.WRITE);
		this.puntos = puntos;
	}

	public List<Ventaja> getVentajas() {
		activate(ActivationPurpose.READ);
		return ventajas;
	}

	public void setVentajas(List<Ventaja> ventajas) {
		activate(ActivationPurpose.WRITE);
		this.ventajas = ventajas;
	}

	public Direccion getDireccion() {
		activate(ActivationPurpose.READ);
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		activate(ActivationPurpose.WRITE);
		this.direccion = direccion;
	}

	public String getTelefono() {
		activate(ActivationPurpose.READ);
		return telefono;
	}

	public void setTelefono(String telefono) {
		activate(ActivationPurpose.WRITE);
		this.telefono = telefono;
	}

	public List<Reclamo> getReclamos() {
		activate(ActivationPurpose.READ);
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		activate(ActivationPurpose.WRITE);
		this.reclamos = reclamos;
	}

	public void agregarReclamo(Reclamo reclamo) {
		this.reclamos.add(reclamo);
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
