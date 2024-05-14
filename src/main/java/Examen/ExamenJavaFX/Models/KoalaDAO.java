package Examen.ExamenJavaFX.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KoalaDAO {
	
	/**
	 * Función que carga de la Base de Datos una lista con todos los koalas
	 * @param con
	 * @return ArrayList de koalas o null
	 */
	public static ArrayList<KoalaDO> getKoala(Connection con) {

		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM koala";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			ArrayList<KoalaDO> arrayProductos = new ArrayList<>();

			while (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
				arrayProductos.add(koala);
			}
			return arrayProductos;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Función que carga un koala específico de la Base de datos
	 * @param con
	 * @param id
	 * @return KoalaDO o null
	 */
	public static KoalaDO cargarKoala(Connection con, int id) {
		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM koala WHERE idKoala=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));

				// Devolvemos el koala
				return koala;
			}

			// Si algo sale mal, devolvemos null
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
