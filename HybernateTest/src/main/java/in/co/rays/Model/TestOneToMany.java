package in.co.rays.Model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.AuctionItem;
import in.co.rays.bean.Bid;

public class TestOneToMany {

	public static void main(String[] args) {
		
	
	AuctionItem item = new AuctionItem();
	item.setDescription("OnePlus");
	
	Bid bid1 = new Bid();
	bid1.setAmount(5000);
	
	Bid bid2 = new Bid();
	bid2.setAmount(2000);

	Bid bid3 = new Bid();
	bid3.setAmount(9000);
	
	Set<Bid> set = new HashSet<Bid>(); 
	set.add(bid1);
	set.add(bid2);
	set.add(bid3);
	
	item.setBids(set);
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session s = sf.openSession();
	Transaction tx = s.beginTransaction();

	s.save(item);
	tx.commit();
	s.close();
	//sf.close();

	System.out.println("inserted");
	
}
}