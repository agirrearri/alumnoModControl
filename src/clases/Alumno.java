package clases;

public class Alumno {
	private int id;
	private String nombre;

	public Alumno(int id,String nombre) {
		this.nombre = nombre;
		this.id = id;
	}
	public Alumno(String nombre){
		this.nombre = nombre;
		this.id = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void mostrarInfo(){
		System.out.println("Soy el alumno: " + this.nombre);
	}

}
