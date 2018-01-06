package oracle.java.s20180102.controller;


import oracle.java.s20180102.model.GServDto;
import oracle.java.s20180102.model.MemberDto;
import oracle.java.s20180102.model.PagingDto;
import oracle.java.s20180102.model.PayDto;
import oracle.java.s20180102.model.ReservDto;
import oracle.java.s20180102.service.MemberService;
import oracle.java.s20180102.service.Paging;
import oracle.java.s20180102.service.PayService;
import oracle.java.s20180102.service.ReservService;
import oracle.java.s20180102.service.WishService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.rosuda.JRI.REXP;
//import org.rosuda.JRI.Rengine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
/*-----------------------------------------------------------------------------------------
	지영made
------------------------------------------------------------------------------------------*/
	@Autowired
	private WishService ws;
	@Autowired
	private ReservService rsvs;
	@Autowired
	private MemberService mb;
	@Autowired
	private PayService ps;
	
	@RequestMapping(value="wishList")
	public String wishList(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String ID =  "abcd@naver.com";
		List<GServDto> wishList = ws.selWishList(ID);
		model.addAttribute("id", ID);
		model.addAttribute("wishList", wishList);
		System.out.println(wishList.size());
		return "wishList";
	}
	
	@RequestMapping(value="reservation_member")
	public String reservation_member(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
		String ID =  "abcd@naver.com";
		int total = rsvs.totalResv(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> reservList = rsvs.selReservList(pdto);

		model.addAttribute("list",reservList);
		model.addAttribute("pg",pg);
		model.addAttribute("total", total);

		return "reservation_member";
	}
	
	@RequestMapping(value="resvCancle")
	public String resvCancle(HttpServletRequest request, Model model) {
		String payCode = request.getParameter("payCode");		
		rsvs.resvCancel(payCode);
	
		//String ID =  (String) request.getSession().getAttribute("ID");
		String currentPage = request.getParameter("currentPage");
		PagingDto pdto = new PagingDto();
		String ID =  "abcd@naver.com";
		int total = rsvs.totalResv(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> reservList = rsvs.selReservList(pdto);

		model.addAttribute("list",reservList);
		model.addAttribute("pg",pg);
		model.addAttribute("total", total);
		
		return "reservation_member";
		
	}
	
	
	@RequestMapping(value="payPage")
	public String payPage(HttpServletRequest request, Model model) {
		//String ID =  (String) request.getSession().getAttribute("ID");
		String payCode = request.getParameter("payCode");
		String ID =  "abcd@naver.com";
		ReservDto rsvDto = rsvs.oneResv(payCode);
		MemberDto mbDto = mb.selMember(ID);
		model.addAttribute("rsvDto", rsvDto);
		model.addAttribute("mbDto", mbDto);
		return "payPage";
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
		int total = rsvs.total_Complete(ID);
		Paging pg = new Paging(total, currentPage);
		pdto.setMemberId(ID);
		pdto.setStart(pg.getStart());
		pdto.setEnd(pg.getEnd());
		List<ReservDto> complete = rsvs.completeList(pdto);
		
		model.addAttribute("list", complete);
		model.addAttribute("pg", pg);
		model.addAttribute("total",total);
		return "review_member";
	}
	
	
/*-----------------------------------------------------------------------------------------
	지영made
------------------------------------------------------------------------------------------*/	

}