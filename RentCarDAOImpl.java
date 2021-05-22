package rent_car_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentCarDAOImpl implements RentCarDAO{

	PreparedStatement pstmt;
	ResultSet rs;
		
	@Override
	public int userUpdate(RentCarDTO rcdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_car set ");
		sb.append("rental = ? ");
		sb.append("where cnum = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, rcdto.getRental());
			pstmt.setInt(2, rcdto.getCnum());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int adminInsert(RentCarDTO rcdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into rent_car (cnum, model, sort, fee, rental) ");
		sb.append("values (?, ?, ?, ?, '0')");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rcdto.getCnum());
			pstmt.setString(2, rcdto.getModel());
			pstmt.setString(3, rcdto.getSort());
			pstmt.setInt(4, rcdto.getFee());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int adminUpdate(RentCarDTO rcdto) {
		int cnt = 0;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("update rent_car set ");
		sb.append("model = ?,");
		sb.append("sort = ?,");
		sb.append("fee = ?,");
		sb.append("rental = ? ");
		sb.append("where cnum = ?");
		try {
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(5, rcdto.getCnum());
			pstmt.setString(1, rcdto.getModel());
			pstmt.setString(2, rcdto.getSort());
			pstmt.setInt(3, rcdto.getFee());
			pstmt.setString(4, rcdto.getRental());
			pstmt.setInt(5, rcdto.getCnum());
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
		sb.append("delete from rent_car where cnum = ?");
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
	public RentCarDTO selectOne(int seq) {
		RentCarDTO  rcdto = null;
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_car where cnum = ?");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rcdto = new RentCarDTO();
				rcdto.setCnum(rs.getInt("cnum"));
				rcdto.setModel(rs.getString("model"));
				rcdto.setSort(rs.getString("sort"));
				rcdto.setFee(rs.getInt("fee"));
				rcdto.setRental(rs.getString("rental"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rcdto;
	}

	@Override
	public List<RentCarDTO> selectList() {
		RentCarDTO  rcdto = null;
		List<RentCarDTO> rclist =  new ArrayList<>();
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from rent_car");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rcdto = new RentCarDTO();
				rcdto.setCnum(rs.getInt("cnum"));
				rcdto.setModel(rs.getString("model"));
				rcdto.setSort(rs.getString("sort"));
				rcdto.setFee(rs.getInt("fee"));
				rcdto.setRental(rs.getString("rental"));
				rclist.add(rcdto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rclist;
	}

}
