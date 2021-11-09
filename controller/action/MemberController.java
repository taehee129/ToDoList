package controller.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.board.MemberService;
import model.board.MemberService;
import model.board.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login.do" , method=RequestMethod.GET)
	public String goLogin(@ModelAttribute("guest")MemberVO vo) {
		vo.setId("test");
		vo.setPassword("1234");
		return "login.jsp";
		
	}
	

	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(MemberVO vo ,HttpSession session) {
		 System.out.println(vo);
		 if(vo.getId()=="" || vo.getId()==null) {
			 throw new IllegalArgumentException("아이디 값 공백에러");
		 }
		 
		if(memberService.selectMember(vo) !=null) {
			System.out.println("로그인 성공");
			session.setAttribute("user", memberService.selectMember(vo));
			
			return "redirect:main.do";
		}else {
			
			return "redirect:index.jsp?loginFail=true";
		}
		
	}
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="join.do")
	public String join(MemberVO vo) {
		System.out.println("join 메서드 실행 중!");
		memberService.insertMember(vo);
		return "redirect:index.jsp";
		
	}
	@RequestMapping(value="updateMember.do")
	public String update(MemberVO vo, HttpSession session) {
		memberService.updateMember(vo);
		session.setAttribute("user", vo);
		return "join.jsp?profilePage=true";
	}
	@RequestMapping(value="deleteMember.do")
	public String delete(MemberVO vo,HttpSession session) {
	
		memberService.deleteMember(vo);
		session.invalidate();
		return "redirect:index.jsp";
	}
}
