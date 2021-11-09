package controller.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.board.MemberVO;
import model.board.ToDoService;
import model.board.ToDoVO;
@Controller
public class ToDoController {
	@Autowired
	ToDoService toDoService;
	
	@RequestMapping(value="main.do")
	public String getDBList(Model model, HttpSession session, ToDoVO vo, MemberVO user) {
		
//		for(ToDoVO v : toDoService.getDBList()) {
//			System.out.println(v); 
//			
//		}
		user = (MemberVO) session.getAttribute("user");
		vo.setWriter(user.getId());
		
		model.addAttribute("toDoList", toDoService.getDBList(vo));
		
		return "main.jsp";
		
	}
	@RequestMapping(value="insertToDo.do")
	public String insertToDo(ToDoVO vo, HttpSession session, MemberVO user) {
		user = (MemberVO) session.getAttribute("user");
		vo.setWriter(user.getId());
		System.out.println("user.getID "+ user.getId() );
		toDoService.insertTodo(vo);
		return "main.do";
	}
	
	@RequestMapping(value="goUpdatePage.do")
	public String goUpdatePage(ToDoVO vo, Model model) {
		vo = toDoService.getDBDate(vo);
		System.out.println("goUpdatePage 메서드에서 toDo : "+ vo);
		model.addAttribute("toDo", vo);
		return "insertToDo.jsp";
		
	}
	
	
	@RequestMapping(value="deleteToDo.do")
	public String deleteToDo(ToDoVO vo) {
		toDoService.deleteTodo(vo);
		return "redirect:main.do";
	}
	@RequestMapping(value="updateToDo.do")
	public String updateToDo(ToDoVO vo) {
		System.out.println("updateToDo 메서드 작동 중 !!");
		System.out.println(vo);
		toDoService.updateTodo(vo);
		return "redirect:main.do";
	}
	
	

}
