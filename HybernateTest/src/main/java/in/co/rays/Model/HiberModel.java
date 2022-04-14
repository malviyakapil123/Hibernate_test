package in.co.rays.Model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.bean.UserBean;

public class HiberModel {
	public static void main(String[] args) {
		// testAdd();
		testGet();
		// testList();
		// testcritaria();
	}

	public static void testcritaria() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("from UserBean");

		Criteria crit = s.createCriteria(UserBean.class);
		crit.add(Restrictions.eq("fname", "ram"));

		List<UserBean> l = crit.list();

		Iterator<UserBean> it = l.iterator();

		while (it.hasNext()) {
			UserBean pojo = (UserBean) it.next();
			System.out.print(pojo.getId());
			System.out.print("\t" + pojo.getFname());
			System.out.println("\t" + pojo.getLname());

		}

	}

	public static void testList() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("from UserBean");

		List<UserBean> l = q.list();

		Iterator<UserBean> it = l.iterator();

		while (it.hasNext()) {
			UserBean pojo = (UserBean) it.next();
			System.out.print(pojo.getId());
			System.out.print("\t" + pojo.getFname());
			System.out.println("\t" + pojo.getLname());

		}

	}

	public static void testGet() {
		// UserBean bean = new UserBean();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		 UserBean pojo = (UserBean) s.get(UserBean.class, 3);
		//UserBean pojo = (UserBean) s.load(UserBean.class, 3);

		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());

		s.close();
		Session s1 = sf.openSession();
		UserBean pojo1 = (UserBean) s1.get(UserBean.class, 3);

		System.out.println(pojo1.getId());
		System.out.println(pojo1.getFname());
		System.out.println(pojo1.getLname());

	}

	public static void testAdd() {
		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFname("raman");
		bean.setLname("sharma");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.save(bean);
		tx.commit();
		s.close();
		sf.close();

		System.out.println("inserted");

	}

}
