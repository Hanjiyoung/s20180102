package oracle.java.s20180102.controller;


import oracle.java.s20180102.model.MemberDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.PayDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.model.ReviewDto;
import oracle.java.s20180102.model.TourCardDto;
import oracle.java.s20180102.model.WishDto;
import oracle.java.s20180102.service.GServService;
import oracle.java.s20180102.service.MemberService;
import oracle.java.s20180102.service.Paging;
import oracle.java.s20180102.service.PayService;
import oracle.java.s20180102.service.ReservService;
import oracle.java.s20180102.service.ReviewService;
import oracle.java.s20180102.service.WishService;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.rosuda.JRI.REXP;
//import org.rosuda.JRI.Rengine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class MemberController {
/*-----------------------------------------------------------------------------------------
	지영made
------------------------------------------------------------------------------------------*/
	@Autowired
	private WishService ws;
	@Autowired
	private ReservService ress;
	@Autowired
	private MemberService mbs;
	@Autowired
	private PayService ps;
	@Autowired
	private ReviewService revs;
	
	@RequestMapping(value="wishList")
	public String wishList(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
		String ID =  "abcd@naver.com";
		int total = ws.totalWish(ID);
		Paging pg = new Paging(total, currentPage, 8);
		
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<TourCardDto> wishList = ws.selWishList(pdto);
		
		model.addAttribute("id", ID);
		model.addAttribute("wishList", wishList);
		return "wishList";
	}
	
	@RequestMapping(value="delWishList")
	public String delWishList(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String ID =  "abcd@naver.com";
		int gServNo = Integer.parseInt(request.getParameter("gServNo"));	
		WishDto wdto = new WishDto();
		wdto.setMemberId(ID);
		wdto.setgServNo(gServNo);
		ws.delWishList(wdto);
		
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
	
		int total = ws.totalWish(ID);
		Paging pg = new Paging(total, currentPage, 8);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<TourCardDto> wishList = ws.selWishList(pdto);
		model.addAttribute("id", ID);
		model.addAttribute("wishList", wishList);
		
		return "wishList";
	}
	
	@RequestMapping(value="reservation_member")
	public String reservation_member(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
		String ID =  "abcd@naver.com";
		int total = ress.totalResv(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> reservList = ress.selReservList(pdto);

		model.addAttribute("list",reservList);
		model.addAttribute("pg",pg);
		model.addAttribute("total", total);

		return "reservation_member";
	}
	
	@RequestMapping(value="delResvPro")
	public String resvCancle(HttpServletRequest request, Model model) {
		String payCode = request.getParameter("payCode");		
		ress.resvCancel(payCode);
	
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
		String ID =  "abcd@naver.com";
		int total = ress.totalResv(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> reservList = ress.selReservList(pdto);

		model.addAttribute("list",reservList);
		model.addAttribute("pg",pg);
		model.addAttribute("total", total);
		
		return "reservation_member";
		
	}
	
	
	@RequestMapping(value="selPayForm")
	public String payPage(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String payCode = request.getParameter("payCode");
		String ID =  "abcd@naver.com";
		ReservDto rsvDto = ress.oneResv(payCode);
		MemberDto mbDto = mbs.selMember(ID);
		model.addAttribute("rsvDto", rsvDto);
		model.addAttribute("mbDto", mbDto);
		return "selPayForm";
	}
	
	@RequestMapping(value="pay_member")
	public String pay_member(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		String ID =  "abcd@naver.com";
		PagingDto pdto = new PagingDto();
		int total = ps.total(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<PayDto> payList = ps.selPayList(pdto);
		model.addAttribute("payList", payList);
		model.addAttribute("pg", pg);
		model.addAttribute("total",total);
		return "pay_member";
	}
	
	@RequestMapping(value="review_member")
	public String review_member(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		String ID =  "abcd@naver.com";
		PagingDto pdto = new PagingDto();
		int total = ress.total_Complete(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> complete = ress.completeList(pdto);
		
		model.addAttribute("list", complete);
		model.addAttribute("pg", pg);
		model.addAttribute("total",total);
		return "review_member";
	}
	
	@RequestMapping(value="writeReviewForm")
	public String writeReview(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String ID =  "abcd@naver.com";
		String payCode = request.getParameter("payCode");
		MemberDto mbDto = mbs.selMember(ID);
		ReservDto rsvDto = ress.oneResv(payCode);
		
		model.addAttribute("rsvDto", rsvDto);
		model.addAttribute("nickName", mbDto.getNickName());
		model.addAttribute("memberId", ID);
		return "writeReviewForm";
	}
	
	@RequestMapping(value="writeReviewPro")
	public String writeReviewPro(ReviewDto revDto, HttpServletRequest request, Model model) {
		/*int maxSize = 5 * 1024 * 1024;
		String realPath = "C:/JSP/jspSrc/och20/WebContent/imgSave"; // 실제로 fileSave에 저장되는 것이 아니라 metadata에 저장됨!
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		Enumeration<E> en = multi.getFileNames(); // 폼의 이름 반환
		while(en.hasMoreElements()){
				//input 태그의 속성이 file인 태그의 name 속성값 : 파라미터 이름
				String name = (String)en.nextElement();
			    //서버에 저장된 파일 이름
			    String filename = multi.getFilesystemName(name);
			    //전송 전 원래의 파일 이름
			    String original = multi.getOriginalFileName(name);
			    //전송된 파일의 내용 타입
			    String type = multi.getContentType(name);
			    //전송된 파일속성이 file인 태그의 name 속성 값을 이용해 파일 객체 생성
			    File file = multi.getFile(name);
			    bookImg ="imgSave/" + filename;
			   
			    
		}*/
		revs.inReview(revDto);
		
		//String ID =  (String) request.getSession().getAttribute("ID");
				String currentPage = request.getParameter("currentPage");
				String ID =  "abcd@naver.com";
				PagingDto pdto = new PagingDto();
				int total = ress.total_Complete(ID);
				Paging pg = new Paging(total, currentPage);
				pdto.setMemberId(ID);
				pdto.setStart(pg.getStart());
				pdto.setEnd(pg.getEnd());
				List<ReservDto> complete = ress.completeList(pdto);
				
				model.addAttribute("list", complete);
				model.addAttribute("pg", pg);
				model.addAttribute("total",total);
				
		return "review_member";
	}
	
	@RequestMapping(value="updateReviewForm")
	public String updateReviewForm(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String ID = "abcd@naver.com";
		int gServNo = Integer.parseInt(request.getParameter("gServNo"));

		ReviewDto revDto = new ReviewDto();
		revDto.setMemberId(ID);
		revDto.setgServNo(gServNo);
		revDto = revs.oneReview(revDto);
		model.addAttribute("revDto", revDto);
		
		return "updateReviewForm";
	}
	
	@RequestMapping(value="updateReviewPro")
	public String updateReviewPro(ReviewDto revDto, HttpServletRequest request, Model model) {
		
		
		revs.upReview(revDto);
		
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		String ID =  "abcd@naver.com";
		PagingDto pdto = new PagingDto();
		int total = ress.total_Complete(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> complete = ress.completeList(pdto);
		
		model.addAttribute("list", complete);
		model.addAttribute("pg", pg);
		model.addAttribute("total",total);
		
		return "review_member";
	}
	
/*-----------------------------------------------------------------------------------------
	지영made
------------------------------------------------------------------------------------------*/	

}