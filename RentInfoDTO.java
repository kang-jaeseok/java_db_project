package rent_car_project;

public class RentInfoDTO {
	private int seq;
	private String userid;
	private int cnum;
	private String rentday;
	private String returnday;
	private int totalfee;
	private String isreturn;
	

	public RentInfoDTO() {
		
	}
			
	public RentInfoDTO(int seq, String userid, int cnum, String rentday, String returnday, int totalfee, String isreturn) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.cnum = cnum;
		this.rentday = rentday;
		this.returnday = returnday;
		this.totalfee = totalfee;
		this.isreturn = isreturn;
 	}
	public final int getSeq() {
		return seq;
	}
	public final void setSeq(int seq) {
		this.seq = seq;
	}
	public final String getUserid() {
		return userid;
	}
	public final void setUserid(String userid) {
		this.userid = userid;
	}
	public final int getCnum() {
		return cnum;
	}
	public final void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public final String getRentday() {
		return rentday;
	}
	public final void setRentday(String rentday) {
		this.rentday = rentday;
	}
	public final String getReturnday() {
		return returnday;
	}
	public final void setReturnday(String returnday) {
		this.returnday = returnday;
	}
	public final int getTotalfee() {
		return totalfee;
	}
	public final void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}
	
	public final String getIsreturn() {
		return isreturn;
	}

	public final void setIsreturn(String isreturn) {
		this.isreturn = isreturn;
	}

	@Override
	public String toString() {
		return "RentInfoDTO [seq=" + seq + ", userid=" + userid + ", cnum=" + cnum + ", rentday=" + rentday
				+ ", returnday=" + returnday + ", totalfee=" + totalfee + ", isreturn=" + isreturn + "]";
	}

	
}
