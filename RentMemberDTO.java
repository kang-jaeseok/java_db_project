package rent_car_project;

import java.util.Date;

public class RentMemberDTO {
	private String userid;
	private String passwd;
	private String phone;
	private int year;
	private String rate;
	private Date regdate;
	public RentMemberDTO() {
		
	}
	public RentMemberDTO(String userid, String passwd, String phone, int year, String rate) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.phone = phone;
		this.year = year;
		this.rate = rate;

	}

	public RentMemberDTO(String userid, String passwd, String phone, int year) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.phone = phone;
		this.year = year;

	}

	public final String getUserid() {
		return userid;
	}

	public final void setUserid(String userid) {
		this.userid = userid;
	}

	public final String getPasswd() {
		return passwd;
	}

	public final void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(String phone) {
		this.phone = phone;
	}

	public final int getYear() {
		return year;
	}

	public final void setYear(int year) {
		this.year = year;
	}

	public final String getRate() {
		return rate;
	}

	public final void setRate(String rate) {
		this.rate = rate;
	}

	public final Date getRegdate() {
		return regdate;
	}

	public final void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "RentMemberDTO [userid=" + userid + ", passwd=" + passwd + ", phone=" + phone + ", year=" + year
				+ ", rate=" + rate + ", regdate=" + regdate + "]";
	}

}
