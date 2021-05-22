package rent_car_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinDAO {
	PreparedStatement pstmt;
	ResultSet rs;
	List<Map<String, Object>> map = new ArrayList<>();
	
	
	//회원별 대여정보
	List<Map<String, Object>> meberRentInfo(){
		List<Map<String, Object>> list =  new ArrayList<>();
		
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select m.userid, m.phone, c.model, c.sort, i.totalfee "); 
		sb.append("from rent_member m ");
		sb.append("join rent_info i on (m.userid = i.userid) ");
		sb.append("join rent_car c on (i.cnum = c.cnum)");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String userid = rs.getString("userid");
				String phone = rs.getString("phone");
				String model = rs.getString("model");
				String sort = rs.getString("sort");
				int totalfee = rs.getInt("totalfee");
				Map<String, Object> map = new HashMap<>();
				map.put("userid", userid);
				map.put("phone", phone);
				map.put("model", model);
				map.put("sort", sort);
				map.put("totalfee", totalfee);
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	List<Map<String, Object>> carRentPeriod(){
		List<Map<String, Object>> list =  new ArrayList<>();
		
		Connection conn = DBConn.getConn();
		StringBuffer sb = new StringBuffer();
		sb.append("select c.cnum, c.model, c.sort, i.rentday, i.returnday, i.totalfee  "); 
		sb.append("from rent_car c  ");
		sb.append("join rent_info i on (c.cnum = i.cnum) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cnum = rs.getInt("cnum");
				String model = rs.getString("model");
				String sort = rs.getString("sort");
				String rentday = rs.getString("rentday");
				String returnday = rs.getString("returnday");
				int totalfee = rs.getInt("totalfee");
				Map<String, Object> map = new HashMap<>();
				map.put("cnum", cnum);
				map.put("model", model);
				map.put("sort", sort);
				map.put("rentday", rentday);
				map.put("returnday", returnday);
				map.put("totalfee", totalfee);
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
