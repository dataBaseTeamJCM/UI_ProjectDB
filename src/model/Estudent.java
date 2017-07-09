package model;

public class Estudent extends Person{
	private String 	carrer;		// carrera del estudiante
	private int 	year;		// año del estudiante
	
	
	public Estudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Estudent(String ci, String name, String lastName, String email, String phone, String adress) {
		super(ci, name, lastName, email, phone, adress);
		// TODO Auto-generated constructor stub
	}
	
	public Estudent(String carrer, int year) {
		super();
		this.carrer = carrer;
		this.year = year;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Estudent [carrer=" + carrer + ", year=" + year + "]";
	}

	
	
}
