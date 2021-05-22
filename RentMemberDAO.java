package rent_car_project;

import java.util.List;

public interface RentMemberDAO {
	int userInsert(RentMemberDTO rmdto); //일반회원가입
	int userUpdate(RentMemberDTO rmdto); //일반회원수정
	int delete(String userid); //회원탈퇴
	int adminInsert(RentMemberDTO rmdto); //사용자회원가입
	int adminUpdate(RentMemberDTO rmdto); //사용자회원수정
	
	RentMemberDTO selectOne(String userid);
	List<RentMemberDTO> selectList();
	
	
}
