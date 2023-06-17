package estacionamiento;

public class Empleado {
	private String nombre;
	private String contrasenia;
	private String cargo;
	private String habilitado;
	
	public Empleado(String nombre,String contrasenia,String cargo,String habilitado) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.cargo = cargo;
		this.habilitado = habilitado;
	}
	
	//getter / setter Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//getter / setter Contraseña
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	//getter / setter Cargo
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	//getter / setter habilitado
	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
	
}
