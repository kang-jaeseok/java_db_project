package rent_car_project;

public class RentCarDTO {
	private int cnum;
	private String model;
	private String sort;
	private int fee;
	private String rental;
	public RentCarDTO() {}
	public RentCarDTO(int cnum, String model, String sort, int fee) {
		super();
		this.cnum = cnum;
		this.model = model;
		this.sort = sort;
		this.fee = fee;
	}
	public final int getCnum() {
		return cnum;
	}
	public final void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public final String getModel() {
		return model;
	}
	public final void setModel(String model) {
		this.model = model;
	}
	public final String getSort() {
		return sort;
	}
	public final void setSort(String sort) {
		this.sort = sort;
	}
	public final int getFee() {
		return fee;
	}
	public final void setFee(int fee) {
		this.fee = fee;
	} 
	public final String getRental() {
		return rental;
	}
	public final void setRental(String rental) {
		this.rental = rental;
	}
	 
	
	@Override
	public String toString() {
		return "RentCarDTO [cnum=" + cnum + ", model=" + model + ", sort=" + sort + ", fee=" + fee + ", rental="
				+ rental + "]";
	}
	 
	  
	
}
