package in.co.rays.bean;

public class Employee {

	private int id;
	private String fname;
	private String lname;
	private Address empAdd;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Address getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(Address empAdd) {
		this.empAdd = empAdd;
	}
	
	
	
}
