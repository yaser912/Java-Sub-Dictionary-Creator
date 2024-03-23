package part2;

public class CellPhone {

	protected long SerialNum;
	protected String brand;
	protected int year;
	protected double price;
	
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.SerialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	public CellPhone(CellPhone other, long serial) {
		this.SerialNum = serial;
		this.brand = other.getBrand();
		this.year = other.getYear();
		this.price = other.getPrice();
	}
	
	public long getSerialNum() {
		return SerialNum;
	}
	public void setSerialNum(long serialNum) {
		SerialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass())
			return false;
		if (other == this)
			return true;
		
		CellPhone f = (CellPhone) other;
		
		if (f.getBrand()==getBrand() && f.getYear()==getYear() && f.getPrice()==getPrice())
			return true;
		else return false;
	}
	
	public String toString() {
		return(this.getSerialNum()+" "+this.getBrand()+"\t\t"+this.getPrice()+" "+this.getYear());
	}
}
