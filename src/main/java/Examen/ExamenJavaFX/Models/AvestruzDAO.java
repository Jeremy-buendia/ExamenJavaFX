package Examen.ExamenJavaFX.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvestruzDAO {
	
	/**
	 * Función que carga de la base de datos una lista de Avestruces
	 * @param con
	 * @return ArrayList de avestruces o null
	 */
	public static ArrayList<AvestruzDO> getAvestruz(Connection con) {

		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM avestruz";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			ArrayList<AvestruzDO> arrayProductos = new ArrayList<>();

			while (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				AvestruzDO avestruz = new AvestruzDO();
				avestruz.setIdAvestruz(rs.getInt("idAvestruz"));
				avestruz.setNombre(rs.getString("nombre"));
				avestruz.setNickguerra(rs.getString("nickguerra"));
				avestruz.setEdad(rs.getInt("edad"));
				avestruz.setAltura(rs.getDouble("altura"));
				avestruz.setNivelMalaLeche(rs.getInt("nivelMalaLeche"));
				avestruz.setNumHuevos(rs.getInt("numHuevos"));
				arrayProductos.add(avestruz);
			}
			return arrayProductos;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Función que carga de la Base de Datos una lista con los koalas asociados a una avestruz
	 * @param idAvestruz
	 * @param con
	 * @return ArrayList de Koalas o null
	 */
	public static ArrayList<KoalaDO> cargarLacayos(int idAvestruz, Connection con) {
		try {
			// Creamos un ArrayList de Koalas
			ArrayList<KoalaDO> koalasAsociadosAvestruz = new ArrayList<>();
			// Query para cargar los koalas asociados a un Avestruz
			String query = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ?";

			// Preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idAvestruz);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Creamos un nuevo koala y le agregamos los datos
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
				// Lo agregamos al ArrayList
				koalasAsociadosAvestruz.add(koala);
			}

			// Devolvemos el arrayList
			return koalasAsociadosAvestruz;

		} catch (Exception e) {
			e.printStackTrace();
			// si hay error devolvemos null
			return null;
		}
	}
	
	/**
	 * Función que elimina un Avestruz de la base de datos
	 * 
	 * @param id
	 * @param con
	 * @return 0 si sale bien, -1 si sale mal
	 */
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM avestruz WHERE idAvestruz=?";

			// Creamos el preparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			// Asignamos el valor a la ?
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			// Si sale bien devolvemos 0
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
