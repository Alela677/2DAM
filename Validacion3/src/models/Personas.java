package models;

public class Personas {

	private String titulo;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String cp;
	private String email;
	private String url;
	private String username;
	private String password;
	private String fecha;
	
	public Personas(String titulo, String nombre, String apellidos, String telefono, String cp, String email,
			String url, String username, String password, String fecha) {
		super();
		this.titulo = titulo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.cp = cp;
		this.email = email;
		this.url = url;
		this.username = username;
		this.password = password;
		this.fecha = fecha;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Personas [titulo=" + titulo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", cp=" + cp + ", email=" + email + ", url=" + url + ", username=" + username
				+ ", password=" + password + ", fecha=" + fecha + "]";
	}
	
	
	
}
