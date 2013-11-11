package hibernate.model.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.test.User;

import hibernate.model.Adress;
import hibernate.model.UserDetails;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails usr = new UserDetails();
		usr.setName("Colton");
		usr.setPname("inthebushwithmonkeys");
		
		User user = new User();
		user.setName("Alan");
		user.setPword("all#monkeys#have#long#tails");
		
		Adress addr = new Adress();
		addr.setStreet("street_name");
		addr.setCity("city_name");
		addr.setState("state_name");
		addr.setZipcode("zipcode_name");
		
		//user.setAdress(addr);
				
		Adress addr2 = new Adress();
		addr2.setStreet("office_street_name");
		addr2.setCity("office_city_name");
		addr2.setState("office_state_name");
		addr2.setZipcode("office_zipcode_name");
		
		//user.setOfficeAdress(addr2);
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
		applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.
		buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction trn = session.beginTransaction();
		session.save(user);
		session.save(usr);
		trn.commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		usr = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println(usr.getOfficeAdress());
		
	}

}
