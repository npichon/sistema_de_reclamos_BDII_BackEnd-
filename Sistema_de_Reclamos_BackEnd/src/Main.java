import java.sql.SQLException;
import java.util.List;

import modelos.Ciudadano;
import daos.CiudadanoDao;
import interfaces.CiudadanoInterface;


public class Main {
	public static void main(String[] args) {
		CiudadanoInterface daociudadano = new CiudadanoDao();
		List<Ciudadano> ciudadanos;
		try {
			ciudadanos = daociudadano.getByDni(35597959);
			System.out.println(ciudadanos.size());
			System.out.println(ciudadanos.get(0).getDni());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	/*	try {
			ciudadanos = daociudadano.getList();
			System.out.println(ciudadanos.size());
			System.out.println(ciudadanos.get(0).getDni());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
}
