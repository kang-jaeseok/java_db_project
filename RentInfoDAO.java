package rent_car_project;

import java.util.List;

public interface RentInfoDAO {
	int userInsert(RentInfoDTO ridto);
	int userUpdate(RentInfoDTO ridto); 
	int delete(int seq); 
	int adminInsert(RentInfoDTO ridto); 
	int adminUpdate(RentInfoDTO ridto); 
	
	RentInfoDTO selectOne(int seq);
	List<RentInfoDTO> selectList();
	List<RentInfoDTO> selectListUserid(String userid);
}
