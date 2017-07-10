package model;

public class Person {

	private String ci;			// cedula de identidad
	private String name;		// nombre
	private	String lastName;	// apellido
	private String email;		// correo electronico
	private String phone;		// numero de telefono
	private String adress;		// direccion donde vive
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		this.ci 		= "none";
		this.name		= "none";
		this.lastName	= "none";
		this.email		= "none";
		this.phone		= "none";
		this.adress		= "none";
	}

	public Person(String ci, String name, String lastName, String email, String phone, String adress) {
		super();
		this.ci = ci;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Person [ci=" + ci + ", name=" + name + ", lastName=" + lastName 
				+ ", email=" + email + ", phone=" + phone 
				+ ", adress=" + adress + "]";
	}
}
