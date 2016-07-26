package servicio;

import interfaces.CategoriaInterface;
import interfaces.CiudadanoInterface;
import interfaces.DireccionInterface;
import interfaces.EstadoInterface;
import interfaces.EstadoReclamoInterface;
import interfaces.ReclamoInterface;
import interfaces.VentajaInterface;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import modelos.Categoria;
import modelos.Ciudadano;
import modelos.Direccion;
import modelos.Estado;
import modelos.EstadoReclamo;
import modelos.Reclamo;
import modelos.Ventaja;
import daos.CategoriaDao;
import daos.CiudadanoDao;
import daos.DireccionDao;
import daos.EstadoDao;
import daos.EstadoReclamoDao;
import daos.ReclamoDao;
import daos.VentajaDao;

public class ServiceSistemaDeReclamos {
	private CategoriaInterface daocategoria = new CategoriaDao();
	private CiudadanoInterface daociudadano = new CiudadanoDao();
	private DireccionInterface daodireccion = new DireccionDao();
	private EstadoInterface daoestado = new EstadoDao();
	private EstadoReclamoInterface daoestadoreclamo = new EstadoReclamoDao();
	private ReclamoInterface daoreclamo = new ReclamoDao();
	private VentajaInterface daoventaja = new VentajaDao();

	public ServiceSistemaDeReclamos() {
	}

	public String altaEstado(Estado estado) throws SQLException {
		return daoestado.save(estado);
	}

	public Estado getEstado(String idEstado) throws SQLException {
		return daoestado.getById(idEstado);
	}

	public List<Estado> getListEstados() throws SQLException {
		return daoestado.getList();
	}

	public Estado editarEstado(Estado estado) throws SQLException {
		daoestado.update(estado);
		return estado;
	}

	public void eliminarEstado(String idEstado) throws SQLException {
		Estado estado = daoestado.getById(idEstado);
		daoestado.delete(estado);
	}

	public Reclamo getReclamo(String idReclamo) throws SQLException {
		return daoreclamo.getById(idReclamo);
	}

	public String altaCategoria(Categoria categoria) throws SQLException {
		return daocategoria.save(categoria);
	}

	public List<Categoria> listCategorias() throws SQLException {
		return daocategoria.getList();
	}

	public Categoria getCategoria(String idCategoria) throws SQLException {
		return daocategoria.getById(idCategoria);
	}

	public Categoria getCategoriaByNombre(String nombreCategoria)
			throws SQLException {
		return daocategoria.getByNombre(nombreCategoria);
	}

	public Categoria editarCategoria(Categoria categoria) throws SQLException {
		daocategoria.update(categoria);
		return categoria;
	}

	public void eliminarCategoria(String idCategoria) throws SQLException {
		Categoria categoria = daocategoria.getById(idCategoria);
		daocategoria.delete(categoria);
	}

	public Ciudadano getCiudadano(String id) throws SQLException {
		return daociudadano.getById(id);
	}

	public Ciudadano getCiudadanobyTwitter(String cuentaTwitter)
			throws SQLException {
		return daociudadano.getByCuentaTwitter(cuentaTwitter);
	}

	public String altaCiudadadano(Ciudadano ciudadano) throws SQLException {

		/*
		 * int idDireccion = daodireccion.save(direccion, 0); if (idDireccion !=
		 * -1) { return daociudadano.save(ciudadano, idDireccion); } else {
		 * return -1; }
		 */
		return daociudadano.save(ciudadano);
	}

	public void eliminarCiudadano(Ciudadano ciudadano) throws SQLException {
		daociudadano.delete(ciudadano);
	}

	public Ciudadano editarCiudadadano(Ciudadano ciudadano, Direccion direccion)
			throws SQLException {

		daodireccion.update(direccion);
		daociudadano.update(ciudadano);
		ciudadano.setDireccion(direccion);
		return ciudadano;
	}

	public List<Ciudadano> ciudadanoByCondicion(int condition)
			throws SQLException {
		return daociudadano.getByDni(condition);
	}

	public List<Ciudadano> ciudadanoGetList() throws SQLException {
		return daociudadano.getList();
	}

	public List<Reclamo> reclamoByCondicion(int condition) throws SQLException {
		return daoreclamo.getByDniCiudadano(condition);
	}

	/*public int altaReclamo(Reclamo reclamo) throws SQLException {

		EstadoReclamo estadoNuevo = new EstadoReclamo("Reclamo realizado",
				reclamo.getFecha(), new Estado("Nuevo", "Reclamo Iniciado"));

		reclamo.agregarEstado(estadoNuevo);

		daoreclamo.save(reclamo);

		reclamo.getCiudadano().setPuntos(
				reclamo.getCiudadano().getPuntos()
						+ reclamo.getCategoria().getPuntaje());
		daociudadano.update(reclamo.getCiudadano());

		return 1;

	}*/
	
	public int altaReclamo(Reclamo reclamo) throws SQLException {

		EstadoReclamo estadoNuevo = new EstadoReclamo("Reclamo realizado",
				reclamo.getFecha(), daoestado.getByNombre("Nuevo"));

		reclamo.agregarEstado(estadoNuevo);
		
		Ciudadano ciudadano = reclamo.getCiudadano();
		ciudadano.agregarReclamo(reclamo);
		
		daociudadano.update(ciudadano);
		
		reclamo.getCiudadano().setPuntos(
				reclamo.getCiudadano().getPuntos()
						+ reclamo.getCategoria().getPuntaje());
		daociudadano.update(reclamo.getCiudadano());

		return 1;

	}

	public int altaReclamoByTwitter(Reclamo reclamo) throws SQLException {

		EstadoReclamo estadoNuevo = new EstadoReclamo("Reclamo relaizado",
				reclamo.getFecha(), new Estado("Nuevo", "Reclamo Iniciado"));

		reclamo.getEstados().add(estadoNuevo);

		reclamo.getCiudadano().setPuntos(
				reclamo.getCiudadano().getPuntos()
						+ reclamo.getCategoria().getPuntaje());
		daociudadano.update(reclamo.getCiudadano());

		return 1;
	}

	public void eliminarReclamo(Reclamo reclamo) throws SQLException {
		daoreclamo.delete(reclamo);
	}

	public List<EstadoReclamo> listEstadosByReclamo(String id)
			throws SQLException {
		Reclamo reclamo = daoreclamo.getById(id);
		return reclamo.getEstados();
	}

	public List<Reclamo> listReclamos() throws SQLException {
		return daoreclamo.getList();
	}

	public String altaEstadoReclamo(String detalle, String fecha, Estado estado,
			String idReclamo) throws SQLException {
		EstadoReclamo estadoReclamo = new EstadoReclamo(detalle,
				Timestamp.valueOf(fecha), estado);
		String idEstadoReclamo = daoestadoreclamo.save(estadoReclamo);
		estadoReclamo.setId(idEstadoReclamo);
		return idEstadoReclamo;
	}

	public String altaVentaja(Ventaja ventaja) throws SQLException {
		return daoventaja.save(ventaja);
	}

	public Ventaja getVentaja(String idVentaja) throws SQLException {
		return daoventaja.getById(idVentaja);
	}

	public List<Ventaja> listVentajasCiudadano(int puntaje) throws SQLException {
		return daoventaja.getByPuntajeCiudadano(puntaje);
	}

	public List<Ventaja> listVentajas() throws SQLException {
		return daoventaja.getList();
	}

	public Ventaja editarVentaja(Ventaja ventaja) throws SQLException {
		daoventaja.update(ventaja);
		return ventaja;
	}

	public void eliminarVentaja(String idVentaja) throws SQLException {
		Ventaja ventaja = daoventaja.getById(idVentaja);
		daoventaja.delete(ventaja);
	}

}
