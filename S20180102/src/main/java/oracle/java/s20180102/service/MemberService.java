package oracle.java.s20180102.service;

import java.util.List;

import org.springframework.stereotype.Service;

import oracle.java.s20180102.model.MemberDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.ReservDto;
@Service
public interface MemberService {

	MemberDto selMember(String id);             // 한 회원 선택
	//int upMember(MemberDto memberDto);        // 프로필 수정, 포인트 증가
	//int inMember(MemberDto memberDto);        // 회원가입
	//List<MemberDto> selMemberList();          // 회원조회
	//int delMember(String id);                 // 회원삭제

}