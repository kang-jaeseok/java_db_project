package rent_car_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentInfoDAOImpl implements RentInfoDAO{
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public int userInsert(RentInfoDTO ridto) {
		
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into rent_info (seq, userid, cnum, rentday, returnday, totalfee, isreturn)"); 
		sb.append("values (rentinfo_seq.nextval, ?, ?, ?, ?, ?, ?)");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1,ridto.getUserid());
			pstmt.setInt(2, ridto.getCnum());
			pstmt.setString(3, ridto.getRentday());
			pstmt.setString(4, ridto.getReturnday());
			pstmt.setInt(5, ridto.getTotalfee());
			pstmt.setString(6, ridto.getIsreturn());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int userUpdate(RentInfoDTO ridto) {
		
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_info set ");
		
		sb.append("isreturn =? ");
		sb.append("where seq = ?");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, ridto.getIsreturn());
			pstmt.setInt(2, ridto.getSeq());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int delete(int seq) {
		
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("delete from rent_info where seq = ?"); 
		
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, seq);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int adminInsert(RentInfoDTO ridto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into rent_info (seq, userid, cnum, rentday, returnday, totalfee, isreturn)"); 
		sb.append("values (rentinfo_seq.nextval, ?, ?, ?, ?, ?, ?)");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1,ridto.getUserid());
			pstmt.setInt(2, ridto.getCnum());
			pstmt.setString(3, ridto.getRentday());
			pstmt.setString(4, ridto.getReturnday());
			pstmt.setInt(5, ridto.getTotalfee());
			pstmt.setString(6, ridto.getIsreturn());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int adminUpdate(RentInfoDTO ridto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_info set ");
		sb.append("userid = ?,");
		sb.append("cnum = ?,");
		sb.append("rentday = ?,");
		sb.append("returnday = ?,");
		sb.append("totalfee = ?,");
		sb.append("isreturn =? ");
		sb.append("where seq = ?");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1,ridto.getUserid());
			pstmt.setInt(2, ridto.getCnum());
			pstmt.setString(3, ridto.getRentday());
			pstmt.setString(4, ridto.getReturnday());
			pstmt.setInt(5, ridto.getTotalfee());
			pstmt.setString(6, ridto.getIsreturn());
			pstmt.setInt(7, ridto.getSeq());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public RentInfoDTO selectOne(int seq) {
		RentInfoDTO ridto = null;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_info where seq =?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ridto = new RentInfoDTO();
				ridto.setSeq(rs.getInt("seq"));
				ridto.setUserid(rs.getString("userid"));
				ridto.setCnum(rs.getInt("cnum"));
				ridto.setRentday(rs.getString("rentday"));
				ridto.setReturnday(rs.getString("returnday"));
				ridto.setTotalfee(rs.getInt("totalfee"));
				ridto.setIsreturn(rs.getString("isreturn"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ridto;
	}

	@Override
	public List<RentInfoDTO> selectList() {
		RentInfoDTO ridto = null;
		List<RentInfoDTO> rilist = new ArrayList<>();
		
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_info");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ridto = new RentInfoDTO();
				ridto.setSeq(rs.getInt("seq"));
				ridto.setUserid(rs.getString("userid"));
				ridto.setCnum(rs.getInt("cnum"));
				ridto.setRentday(rs.getString("rentday"));
				ridto.setReturnday(rs.getString("returnday"));
				ridto.setTotalfee(rs.getInt("totalfee"));
				ridto.setIsreturn(rs.getString("isreturn"));
				rilist.add(ridto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rilist;
	}

	@Override
	public List<RentInfoDTO> selectListUserid(String userid) {
		
		RentInfoDTO ridto = null;
		List<RentInfoDTO> rilist = new ArrayList<>();
		
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_info where userid = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ridto = new RentInfoDTO();
				ridto.setSeq(rs.getInt("seq"));
				ridto.setUserid(rs.getString("userid"));
				ridto.setCnum(rs.getInt("cnum"));
				ridto.setRentday(rs.getString("rentday"));
				ridto.setReturnday(rs.getString("returnday"));
				ridto.setTotalfee(rs.getInt("totalfee"));
				ridto.setIsreturn(rs.getString("isreturn"));
				rilist.add(ridto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rilist;
		
	}

}
