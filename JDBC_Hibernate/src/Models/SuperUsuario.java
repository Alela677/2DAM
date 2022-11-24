package Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// Creamos la tabla en la abse de datos si no existe
@Entity
@Table(name = "superusuarios")
public class SuperUsuario {
	
	// Atributos mapeados de la clase superusuarios
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellidos;
		
	@Column(name = "user")
	private String user;

	
	// Contructor vacio que necesita hibernate para trabajar
	public SuperUsuario() {
		super();
	}
	
	// Contructor para crear superusuarios
	public SuperUsuario(String nombre,String apellido, String user) {
		super();
		this.nombre = nombre;
		this.apellidos = apellido;
		this.user = user;
		
	}
	
	// Getter y Setter
	
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	

}
