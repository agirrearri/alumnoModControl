package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Alumno;

public class Alumno_model extends Conector {

	Alumno_model(String nombre_bbdd) {
		super(nombre_bbdd);

	}

	/**
	 * 
	 * @return alumno taulako tupla guztiak
	 * atributu guztiekin 
	 */
	public ResultSet select(){
		Statement st;
		try {
			st = super.getConexion().createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/**
	 * 
	 * @param String nombre existitzen den alumno baten izena
	 * @return jaso duen izeneko ikaslearen id-a datu basean
	 */
	
	public int selectId(String nombre){
		Statement st;
		try {
			st = super.getConexion().createStatement();
			ResultSet rs = st.executeQuery("select id from alumnos where nombre='"+nombre+"'");
			rs.next();
			return rs.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	/**
	 * 
	 * @param Alumno a datu basean sartu behar duen alumnoa
	 */
	public void insert(Alumno a) {
		Statement st;
		try {
			st = super.getConexion().createStatement();
			st.execute("INSERT INTO alumnos (nombre) " + "VALUES ('" + a.getNombre() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param Alumno a: a Alumno-aren nombre jarriko dio
	 * a Alumnoa-ren id-a duenari
	 * @return zenbat tupla aldatu diren itzuliko du (1)
	 * Txaro egin bada 0;
	 */
	public int update(Alumno a) {
		try {
			Statement st = super.getConexion().createStatement();
			int lineascambiadas = st
					.executeUpdate("UPDATE alumnos " + "SET nombre='" + a.getNombre() + "'" + " WHERE id=" + a.getId());
			return lineascambiadas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param Alumno a-ren izena duen alumnoa ezabatuko du.
	 */
	public void delete(Alumno a) {
		try{
		Statement st = super.getConexion().createStatement();
		st.execute("DELETE FROM alumnos " + "WHERE nombre= ('" + a.getNombre() + "')");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
