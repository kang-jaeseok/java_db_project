package rent_car_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int no;
		RentMemberDAOImpl rmdao = new RentMemberDAOImpl();
		RentCarDAOImpl rcdao = new RentCarDAOImpl();
		RentInfoDAOImpl ridao = new RentInfoDAOImpl();
		JoinDAO jdao = new JoinDAO();
		while (true) {
			System.out.println("-차량 대여 서비스-------");
			System.out.println("------------------");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 프로그램 종료");
			System.out.println("------------------");
			System.out.print("입력: ");
			no = sc.nextInt();

			if (no == 1) {
				String userid;
				String passwd;
				RentMemberDTO rmdto = new RentMemberDTO();
				RentCarDTO rcdto = new RentCarDTO();
				System.out.print("id: ");
				userid = sc.next();

				rmdto = rmdao.selectOne(userid);
				if (rmdto != null) {
					System.out.print("password: ");
					passwd = sc.next();
					if (rmdto.getPasswd().equals(passwd)) {
						// 일반 사용자, 관리자 모드
						if (rmdto.getRate().equals("A")) {
							while (true) {
								System.out.println("[관리자]------------");
								System.out.println("1. 회원관리");
								System.out.println("2. 차량관리");
								System.out.println("3. 렌트정보삭제");
								System.out.println("4. 회원별 대여정보");
								System.out.println("5. 차량별 대여기간");
								System.out.println("0. 프로그램 종료");
								System.out.println("------------------");
								System.out.print("입력: ");
								no = sc.nextInt();

								if (no == 1) {

									while (true) {
										System.out.println("[관리자]------------");
										System.out.println("1. 회원등록");
										System.out.println("2. 회원정보수정");
										System.out.println("3. 회원탈퇴");
										System.out.println("9. 이전화면");
										System.out.println("0. 프로그램 종료");
										System.out.println("------------------");
										List<RentMemberDTO> rmlist = new ArrayList<>();
										rmlist = rmdao.selectList();
										for (RentMemberDTO dto : rmlist) {
											System.out.printf("%5s %s %s %d %s %s\n", dto.getUserid(), dto.getPasswd(),
													dto.getPhone(), dto.getYear(), dto.getRate(), dto.getRegdate());
										}
										System.out.println("------------------");
										System.out.print("입력: ");
										no = sc.nextInt();
										if (no == 1) {
											System.out.println("------------------");
											System.out.println("[회원 등록]");
											System.out.println("------------------");

											System.out.print("id: ");
											rmdto.setUserid(sc.next());
											System.out.print("password: ");
											rmdto.setPasswd(sc.next());
											System.out.print("phone: ");
											rmdto.setPhone(sc.next());
											System.out.print("year: ");
											rmdto.setYear(sc.nextInt());
											System.out.print("rate: "); // A: 관리자, N: 일반사용자
											rmdto.setRate(sc.next());

											int cnt = rmdao.adminInsert(rmdto);
											if (cnt > 0) {
												System.out.println("회원가입 성공");
											} else {
												System.out.println("회원가입 실패");
											}
										} else if (no == 2) {
											System.out.println("------------------");
											System.out.println("[회원정보수정]");
											System.out.println("------------------");

											System.out.print("id: ");
											rmdto.setUserid(sc.next());
											System.out.print("password: ");
											rmdto.setPasswd(sc.next());
											System.out.print("phone: ");
											rmdto.setPhone(sc.next());
											System.out.print("year: ");
											rmdto.setYear(sc.nextInt());
											System.out.print("rate: "); // A: 관리자, N: 일반사용자
											rmdto.setRate(sc.next());

											int cnt = rmdao.adminUpdate(rmdto);
											if (cnt > 0) {
												System.out.println("회원가입 성공");
											} else {
												System.out.println("회원가입 실패");
											}
										} else if (no == 3) {
											System.out.println("------------------");
											System.out.println("[회원탈퇴]");
											System.out.println("------------------");
											System.out.println("id: ");
											rmdto.setUserid(sc.next());

											int cnt = rmdao.delete(rmdto.getUserid());
											if (cnt > 0) {
												System.out.println("회원탈퇴 성공");
											} else {
												System.out.println("회원탈퇴 실패");
											}
										} else if (no == 9) {
											break;
										} else if (no == 0) {
											closeProgram();
										}
									}

								} else if (no == 2) {
									while (true) {
										System.out.println("[관리자]------------");
										System.out.println("1. 차량등록");
										System.out.println("2. 차량정보수정");
										System.out.println("3. 차량삭제");
										System.out.println("9. 이전화면");
										System.out.println("0. 프로그램 종료");
										System.out.println("------------------");
										List<RentCarDTO> rclist = new ArrayList<>();
										rclist = rcdao.selectList();
										for (RentCarDTO dto : rclist) {
											System.out.printf("%d %s %s %d %s \n", dto.getCnum(), dto.getModel(),
													dto.getSort(), dto.getFee(), dto.getRental());
										}
										System.out.println("------------------");
										System.out.print("입력: ");
										no = sc.nextInt();
										if (no == 1) {
											System.out.println("------------------");
											System.out.println("[차량 등록]");
											System.out.println("------------------");

											System.out.print("cnum: ");
											rcdto.setCnum(sc.nextInt());
											System.out.print("model: ");
											rcdto.setModel(sc.next());
											System.out.print("sort: ");
											rcdto.setSort(sc.next());
											System.out.print("fee: ");
											rcdto.setFee(sc.nextInt());
											

											int cnt = rcdao.adminInsert(rcdto);
											if (cnt > 0) {
												System.out.println("차량등록 성공");
											} else {
												System.out.println("차량등록 실패");
											}
										} else if (no == 2) {

											System.out.println("------------------");
											System.out.println("[차량정보 수정]");
											System.out.println("------------------");

											System.out.print("cnum: ");
											rcdto.setCnum(sc.nextInt());
											System.out.print("model: ");
											rcdto.setModel(sc.next());
											System.out.print("sort: ");
											rcdto.setSort(sc.next());
											System.out.print("fee: ");
											rcdto.setFee(sc.nextInt());
											System.out.print("rental: ");
											rcdto.setRental(sc.next());
											
											int cnt = rcdao.adminUpdate(rcdto);
											
											if (cnt > 0) {
												System.out.println("정보수정 성공");
											} else {
												System.out.println("정보수정 실패");
											}
										} else if (no == 3) {
											
											
											System.out.println("------------------");
											System.out.println("[차량삭제]");
											System.out.println("------------------");
											System.out.println("cnum: ");
											rcdto.setCnum(sc.nextInt());

											int cnt = rcdao.delete(rcdto.getCnum());
											if (cnt > 0) {
												System.out.println("차량삭제 성공");
											} else {
												System.out.println("차량삭제 실패");
											}
										} else if (no == 9) {
											break;
										} else if (no == 0) {
											closeProgram();
										}
									}
								} else if (no == 3) {
									
									
									System.out.println("[관리자]------------");
									System.out.println("[렌트정보 삭제]");
									System.out.println("------------------");
									List<RentInfoDTO> rilist = new ArrayList<>();
									rilist = ridao.selectList();
															
									for (RentInfoDTO dto : rilist) {
										System.out.printf("%d. %s %d %s %s %d \n", dto.getSeq(),
											dto.getUserid(), dto.getCnum(), dto.getRentday(),
											dto.getReturnday(), dto.getTotalfee());
									}
									System.out.print("번호 입력: ");
									int cnt = ridao.delete(sc.nextInt());
									if (cnt > 0) {
										System.out.println("렌트정보삭제 성공");
									} else {
										System.out.println("렌트정보삭제 실패");
									}
									
									
								} else if (no == 4) {
									List<Map<String, Object>> list = new ArrayList<>();
									list = jdao.meberRentInfo();
									for(Map<String, Object> map : list) {
										System.out.print(map.get("userid") + " ");
										System.out.print(map.get("phone") + " ");
										System.out.print(map.get("model") + " ");
										System.out.print(map.get("sort") + " ");
										System.out.print(map.get("totalfee") + " ");
										System.out.println();
									}
								} else if (no == 5) {
									List<Map<String, Object>> list = new ArrayList<>();
									list = jdao.carRentPeriod();
									for(Map<String, Object> map : list) {
										System.out.print(map.get("cnum") + " ");
										System.out.print(map.get("model") + " ");
										System.out.print(map.get("sort") + " ");
										System.out.print(map.get("rentday") + " ");
										System.out.print(map.get("returnday") + " ");
										System.out.print(map.get("totalfee") + " ");
										System.out.println();
									}	
								} else if (no == 0) {
									closeProgram();
								}
							}
						} else {
							while (true) {
								System.out.println("[" + rmdto.getUserid() + "]------------");
								System.out.println("1. 렌트");
								System.out.println("2. 회원정보수정");
								System.out.println("3. 회원탈퇴");
								System.out.println("0. 프로그램 종료");
								System.out.println("------------------");
								System.out.print("입력: ");
								no = sc.nextInt();

								if (no == 1) {
									// 자동차 렌트 페이지
									List<RentCarDTO> rclist = new ArrayList<>();

									RentInfoDTO ridto = new RentInfoDTO();
									System.out.println("[" + rmdto.getUserid() + "]------------");
									System.out.println("1. 대여");
									System.out.println("2. 반납");
									System.out.println("------------------");

									// 여기서 렌트가능한 자동차 목록 출력

									System.out.print("입력: ");
									no = sc.nextInt();

									if (no == 1) {
										System.out.println("------------------");
										rclist = rcdao.selectList();
										for (RentCarDTO dto : rclist) {
											// 대여가능한 차
											if (dto.getRental().equals("0")) {
												System.out.printf("%s %-10s %-6s %d \n", dto.getCnum(), dto.getModel(),
														dto.getSort(), dto.getFee());
											}

										}
										System.out.println("------------------");
										System.out.print("차량번호 입력: ");

										// 입력후 변환 20210511 -> 2021-05-11
										rcdto = rcdao.selectOne(sc.nextInt());
										System.out.print("빌릴 날짜 입력: ");
										String rentDate = sc.next();
										rentDate = rentDate.substring(0, 4) + "-" + rentDate.substring(4, 6) + "-"
												+ rentDate.substring(6, 8);
										System.out.print("반납 날짜 입력: ");
										String returnDate = sc.next();
										returnDate = returnDate.substring(0, 4) + "-" + returnDate.substring(4, 6) + "-"
												+ returnDate.substring(6, 8);
										ridto.setRentday(rentDate);
										ridto.setReturnday(returnDate);

										// 두날짜사이의 차이
										long diffDays = 0;
										try {
											Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(rentDate);
											Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);

											diffDays = (endDate.getTime() - beginDate.getTime())
													/ (24 * 60 * 60 * 1000);
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

										rcdto.setRental("1");
										rcdao.userUpdate(rcdto);

										// 회원 등급 확인
										double discount = 0;
										discount = rmdto.getRate().equals("N") ? 0
												: rmdto.getRate().equals("P") ? 0.1 : 0.2;

										// rentinfo

										ridto.setTotalfee((int) (diffDays * (1 - discount) * rcdto.getFee()));

										ridto.setUserid(rmdto.getUserid());
										ridto.setCnum(rcdto.getCnum());
										ridto.setIsreturn("1");
										System.out.println("------------------");
										System.out.printf("%s %d %s %s %d \n", ridto.getUserid(), ridto.getCnum(),
												ridto.getRentday(), ridto.getReturnday(), ridto.getTotalfee());
										System.out.println("------------------");
										ridao.userInsert(ridto);

									} else {
										// 개인이 빌리고 있는차 출력
										List<RentInfoDTO> rilist = new ArrayList<>();
										rilist = ridao.selectListUserid(rmdto.getUserid());
										int cnt = 0;
										boolean isFlag = false;
										for (RentInfoDTO dto : rilist) {
											if (dto.getIsreturn().equals("1")) {
												System.out.printf("%d. %s %d %s %s %d \n", dto.getSeq(),
														dto.getUserid(), dto.getCnum(), dto.getRentday(),
														dto.getReturnday(), dto.getTotalfee());
												isFlag = true;
											}
										}
										System.out.println(rilist.size());
										// 빌린 횟수에 따라서 등급 상향
										if (rilist.size() > 2) {
											rmdto.setRate("P"); // 프리미엄
										} else if (rilist.size() > 5) {
											rmdto.setRate("V"); // vip
										}
										rmdao.adminUpdate(rmdto);
										if (isFlag == false) {
											System.out.println("반납할 차가 없습니다.");
											continue;
										}
										System.out.print("번호 입력: ");
										cnt = sc.nextInt();
										ridto = ridao.selectOne(cnt);

										ridto.setIsreturn("0");
										rcdto.setCnum(ridto.getCnum());
										rcdto.setRental("0");
										rcdao.userUpdate(rcdto);
										ridao.userUpdate(ridto);

									}
								} else if (no == 2) {
									System.out.println("------------------");
									System.out.println("[회원 정보수정]");
									System.out.println("------------------");

									System.out.print("password: ");
									rmdto.setPasswd(sc.next());
									System.out.print("phone: ");
									rmdto.setPhone(sc.next());
									System.out.print("year: ");
									rmdto.setYear(sc.nextInt());

									int cnt = rmdao.userUpdate(rmdto);
									if (cnt > 0) {
										System.out.println("회원정보수정 성공");
									} else {
										System.out.println("회원정보수정 실패");
									}
								} else if (no == 3) {
									int cnt = rmdao.delete(rmdto.getUserid());
									if (cnt > 0) {
										System.out.println("회원탈퇴 성공");
										break;
									} else {
										System.out.println("회원탈퇴 실패");
									}
								} else if (no == 0) {
									closeProgram();
								}
							}
						}

					} else {
						System.out.println("잘못된 비밀번호 입니다.");
						continue;
					}
				} else {
					System.out.println("등록되지 않은 사용자 입니다.");
					continue;
				}

			} else if (no == 2) {

				RentMemberDTO rmdto = new RentMemberDTO();
				System.out.println("------------------");
				System.out.println("[회원 가입]");
				System.out.println("------------------");

				System.out.print("id: ");
				rmdto.setUserid(sc.next());
				System.out.print("password: ");
				rmdto.setPasswd(sc.next());
				System.out.print("phone: ");
				rmdto.setPhone(sc.next());
				System.out.print("year: ");
				rmdto.setYear(sc.nextInt());

				int cnt = rmdao.userInsert(rmdto);
				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
			} else if (no == 0) {
				closeProgram();
			}

		}

	}

	public static void closeProgram() {
		DBConn.dbClose();
		System.out.println("[프로그램 종료]");
		System.exit(0);
	}

}
