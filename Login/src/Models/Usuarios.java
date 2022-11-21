package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

	@Id
	@Column(name = "id")
	private int id ;
	
	@Column(name = "users")
	private String nombre;
	
	@Column(name = "password")
	private String password;
	
	public Usuarios() {
		super();
	}
	
	public Usuarios(int id , String nombre , String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", password=" + password + "]";
	}
	
	
}
