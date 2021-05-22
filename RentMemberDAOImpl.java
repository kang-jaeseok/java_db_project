package rent_car_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentMemberDAOImpl implements RentMemberDAO{
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public int userInsert(RentMemberDTO rmdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into rent_member (userid, passwd, phone, birthyear, rate) ");
		sb.append("values(?, ?, ?, ?, 'N')");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, rmdto.getUserid());
			pstmt.setString(2, rmdto.getPasswd());
			pstmt.setString(3, rmdto.getPhone());
			pstmt.setInt(4, rmdto.getYear());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int userUpdate(RentMemberDTO rmdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_member set ");
		sb.append("passwd = ?,");
		sb.append("phone = ?,");
		sb.append("birthyear = ? ");
		sb.append("where userid = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, rmdto.getPasswd());
			pstmt.setString(2, rmdto.getPhone());
			pstmt.setInt(3, rmdto.getYear());
			pstmt.setString(4, rmdto.getUserid());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int delete(String userid) {
		
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("delete from rent_member where userid = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int adminInsert(RentMemberDTO rmdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into rent_member (userid, passwd, phone, birthyear, rate) ");
		sb.append("values(?, ?, ?, ?, ?)");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, rmdto.getUserid());
			pstmt.setString(2, rmdto.getPasswd());
			pstmt.setString(3, rmdto.getPhone());
			pstmt.setInt(4, rmdto.getYear());
			pstmt.setString(5, rmdto.getRate());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
		
	}

	@Override
	public int adminUpdate(RentMemberDTO rmdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_member set ");
		sb.append("passwd = ?,");
		sb.append("phone = ?,");
		sb.append("birthyear = ?,");
		sb.append("rate = ? ");
		sb.append("where userid = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, rmdto.getPasswd());
			pstmt.setString(2, rmdto.getPhone());
			pstmt.setInt(3, rmdto.getYear());
			pstmt.setString(4, rmdto.getRate());
			pstmt.setString(5, rmdto.getUserid());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public RentMemberDTO selectOne(String userid) {
		RentMemberDTO rmdto = null;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_member where userid = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rmdto = new RentMemberDTO(); 
				rmdto.setUserid(rs.getString("userid"));
				rmdto.setPasswd(rs.getString("passwd"));
				rmdto.setPhone(rs.getString("phone"));
				rmdto.setYear(rs.getInt("birthyear"));
				rmdto.setRate(rs.getString("rate"));
				rmdto.setRegdate(rs.getDate("regdate"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rmdto;
	}

	@Override
	public List<RentMemberDTO> selectList() {
		
		RentMemberDTO rmdto = null;
		Connection conn = DBConn.getConn();
		List<RentMemberDTO> rmlist = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_member");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rmdto = new RentMemberDTO(); 
				rmdto.setUserid(rs.getString("userid"));
				rmdto.setPasswd(rs.getString("passwd"));
				rmdto.setPhone(rs.getString("phone"));
				rmdto.setYear(rs.getInt("birthyear"));
				rmdto.setRate(rs.getString("rate"));
				rmdto.setRegdate(rs.getDate("regdate"));
				rmlist.add(rmdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rmlist;
	}

}
