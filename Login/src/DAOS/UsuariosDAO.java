package DAOS;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Models.Usuarios;

public class UsuariosDAO {

	public static void main(String[] args) {

		ArrayList<Usuarios> user = new ArrayList<Usuarios>();
		user.add(new Usuarios(2, "Luis", "1234"));
		user.add(new Usuarios(3, "David", "1234"));
		user.add(new Usuarios(4, "Maria", "1234"));

		consultarUsuarios("Maria", "1234");

	}

	private static Session sesion() {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		Session sesion = sf.openSession();
		return sesion;

	}

	public static void introducirUsuarios(ArrayList<Usuarios> user) {
		Session sesion = sesion();
		sesion.getTransaction().begin();

		for (Usuarios usuarios : user) {
			sesion.save(usuarios);
		}

		sesion.getTransaction().commit();
		sesion.close();

	}

	public static Usuarios consultarUsuarios(String nombre1, String password1) {

		Session sesino = sesion();

		Usuarios nuevo = null;
		Query query = sesino.createQuery("FROM Usuarios WHERE nombre = :nombre AND password= :password");

		query.setParameter("nombre", nombre1);
		query.setParameter("password", password1);
		nuevo = (Usuarios) query.uniqueResult();
		System.out.println(nuevo.toString());

		return nuevo;

	}
}
