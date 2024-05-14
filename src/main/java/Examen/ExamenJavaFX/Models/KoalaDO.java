package Examen.ExamenJavaFX.Models;

public class KoalaDO {
	private int idKoala;
	private String nombre;
	private String nickguerra;
	private int edad;
	private String color;
	private int fuerza;
	private int inteligencia;
	private int horasSueno;
	private int tiempoBerserk;
	private int CarritoGolf_idCarritoGolf;
	private int Avestruz_idAvestruz;

	public int getIdKoala() {
		return idKoala;
	}

	public void setIdKoala(int idKoala) {
		this.idKoala = idKoala;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getHorasSueno() {
		return horasSueno;
	}

	public void setHorasSueno(int horasSueno) {
		this.horasSueno = horasSueno;
	}

	public int getTiempoBerserk() {
		return tiempoBerserk;
	}

	public void setTiempoBerserk(int tiempoBerserk) {
		this.tiempoBerserk = tiempoBerserk;
	}

	public int getCarritoGolf_idCarritoGolf() {
		return CarritoGolf_idCarritoGolf;
	}

	public void setCarritoGolf_idCarritoGolf(int carritoGolf_idCarritoGolf) {
		CarritoGolf_idCarritoGolf = carritoGolf_idCarritoGolf;
	}

	public int getAvestruz_idAvestruz() {
		return Avestruz_idAvestruz;
	}

	public void setAvestruz_idAvestruz(int avestruz_idAvestruz) {
		Avestruz_idAvestruz = avestruz_idAvestruz;
	}

	public KoalaDO(int idKoala, String nombre, String nickguerra, int edad, String color, int fuerza, int inteligencia,
			int horasSueno, int tiempoBerserk, int carritoGolf_idCarritoGolf, int avestruz_idAvestruz) {
		super();
		this.idKoala = idKoala;
		this.nombre = nombre;
		this.nickguerra = nickguerra;
		this.edad = edad;
		this.color = color;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.horasSueno = horasSueno;
		this.tiempoBerserk = tiempoBerserk;
		CarritoGolf_idCarritoGolf = carritoGolf_idCarritoGolf;
		Avestruz_idAvestruz = avestruz_idAvestruz;
	}

	public KoalaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "koalaDO [idKoala=" + idKoala + ", nombre=" + nombre + ", nickguerra=" + nickguerra + ", edad=" + edad
				+ ", color=" + color + ", fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", horasSueno="
				+ horasSueno + ", tiempoBerserk=" + tiempoBerserk + ", CarritoGolf_idCarritoGolf="
				+ CarritoGolf_idCarritoGolf + ", Avestruz_idAvestruz=" + Avestruz_idAvestruz + "]";
	}
}
