package in.co.rays.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.Address;
import in.co.rays.bean.Employee;

public class TestOneToOne {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setFname("Kapil");
		emp.setLname("Malviya");

		Address add = new Address();
		add.setCity("Indore");
		add.setStreet("Sindhi Colony");
		add.setState("MadhyaPradesh");

		emp.setEmpAdd(add);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.save(emp);
		tx.commit();
		s.close();
		// sf.close();

		System.out.println("inserted");

	}

}
