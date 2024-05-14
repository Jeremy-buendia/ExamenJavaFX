package Examen.ExamenJavaFX.Models;

public class AvestruzDO {
	private int idAvestruz;
	private String nombre;
	private String nickguerra;
	private int edad;
	private double altura;
	private int nivelMalaLeche;
	private int numHuevos;

	public int getIdAvestruz() {
		return idAvestruz;
	}

	public void setIdAvestruz(int idAvestruz) {
		this.idAvestruz = idAvestruz;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickguerra() {
		return nickguerra;
	}

	public void setNickguerra(String nickguerra) {
		this.nickguerra = nickguerra;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getNivelMalaLeche() {
		return nivelMalaLeche;
	}

	public void setNivelMalaLeche(int nivelMalaLeche) {
		this.nivelMalaLeche = nivelMalaLeche;
	}

	public int getNumHuevos() {
		return numHuevos;
	}

	public void setNumHuevos(int numHuevos) {
		this.numHuevos = numHuevos;
	}

	public AvestruzDO(int idAvestruz, String nombre, String nickguerra, int edad, double altura, int nivelMalaLeche,
			int numHuevos) {
		super();
		this.idAvestruz = idAvestruz;
		this.nombre = nombre;
		this.nickguerra = nickguerra;
		this.edad = edad;
		this.altura = altura;
		this.nivelMalaLeche = nivelMalaLeche;
		this.numHuevos = numHuevos;
	}

	public AvestruzDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AvestruzDO [idAvestruz=" + idAvestruz + ", nombre=" + nombre + ", nickguerra=" + nickguerra + ", edad="
				+ edad + ", altura=" + altura + ", nivelMalaLeche=" + nivelMalaLeche + ", numHuevos=" + numHuevos + "]";
	}
}
