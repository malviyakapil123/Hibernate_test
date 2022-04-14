package in.co.rays.Model;

import java.util.Iterator;
import java.util.List;

import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.bean.UserBean;
import in.co.rays.bean.UserLogin;

public class LoginTest {

	public static void main(String[] args) {

		//testAdd();
		testAuthenticate();
		//testCriteria();
	}

	public static void testCriteria() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("from UserLogin");

		Criteria crit = s.createCriteria(UserLogin.class);
		crit.add(Restrictions.eq("fname", "Yash"));

		List<UserLogin> l = crit.list();

		Iterator<UserLogin> it = l.iterator();

		while (it.hasNext()) {
			UserLogin pojo = (UserLogin) it.next();
			System.out.print(pojo.getId());
			System.out.print("\t" + pojo.getFname());
			System.out.println("\t" + pojo.getLname());

		}
		
	}

	private static void testAuthenticate() {

		
	}

	public static void testAdd() {

		UserLogin log = new UserLogin();

		log.setFname("Yashu");
		log.setLname("Gupta");
		log.setLogin("guptay@gmail.com");
		log.setPassword("yashu@123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.save(log);
		tx.commit();
		s.close();
		sf.close();

	}

}
