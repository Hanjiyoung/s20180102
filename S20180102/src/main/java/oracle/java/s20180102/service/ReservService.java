package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.stereotype.Service;

import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;
@Service
public interface ReservService {

	//int upReserv(String cancle);                 // 예약 취소
	//List<ReservDto> selReservList(String Id);    // 회원별 예약 리스트 조회
	//int inReserv(ReservDto reservDto);           // 예약 등록
	//int upReserv(ReservDto reservDto);           // 예약 수정
	//int delReserv(String payCode);               // 예약 삭제

	List<ReservDto> selReservList(PagingDto pdto); // 회원별 예약 리스트 조회
	int totalResv(String iD);                      // 회원별 예약리스트 총 개수 구하기
	ReservDto oneResv(String payCode);             // 하나의 예약 조회
	int total_Complete(String iD);                 // 투어완료된 개수 구하기
	List<ReservDto> completeList(PagingDto pdto);  // 투어완료된 리스트 구하기
	void resvCancel(String payCode);               // 예약 취소
	
}