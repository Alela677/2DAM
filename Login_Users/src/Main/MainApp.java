package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Models.Usuarios;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();

		sesion.getTransaction().begin();
		
		Usuarios nuevo = new Usuarios();
		nuevo.setID(1);
		nuevo.setUsername("Nuevo");
		nuevo.setPassword("1234");
		

		sesion.save(nuevo);

		sesion.getTransaction().commit();

		// Cierro Session y SessionFactory
		sesion.close();
		sf.close();
	}

}
