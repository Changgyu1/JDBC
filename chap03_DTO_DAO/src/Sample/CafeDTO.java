package Sample;

public class CafeDTO {
	private int cafe_id;
	private String mname;
	private double price;

	public int getCafe_id() {
		return cafe_id;
	}

	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CafeDTO() {}
	
	public CafeDTO(String mname, double price) {
		this.mname = mname;
		this.price = price;
	}
	
}
