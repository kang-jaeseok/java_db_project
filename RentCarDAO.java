package rent_car_project;

import java.util.List;

public interface RentCarDAO {
	int userUpdate(RentCarDTO rcdto); //일반사용자 대여 반납
	
	int adminInsert(RentCarDTO rcdto);
	int adminUpdate(RentCarDTO rcdto);
	int delete(int cnum);
	
	RentCarDTO selectOne(int cnum);
	List<RentCarDTO> selectList();
	
}
