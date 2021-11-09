package controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.board.MemoService;
import model.board.MemoVO;

@Controller
@SessionAttributes("memoVO")
public class MemoController {
	
	@Autowired
	MemoService memoService;
	
	@RequestMapping("insertMemo.do")
	@ResponseBody
	public int insertMemo(@ModelAttribute("memoVO")MemoVO vo) {
		System.out.println("insertMemo VO : "+vo);
		return memoService.insertMemo(vo);
		
	}
	
	@RequestMapping("memoList.do")
	public String getMemoList(MemoVO vo, Model model ){ // vo 에 parnetId 들어 있음 
		
		model.addAttribute("memoList", memoService.getDBList(vo));
		//model.addAttribute("parentId", vo.getParentId());
		model.addAttribute("memoVO", vo);
		return "memo.jsp";
		
		
	}
	@RequestMapping("updateMemo.do")
	@ResponseBody
	public void updateMemo(MemoVO vo) {
		System.out.println("updateMemo memo"+vo);
		memoService.updateMemo(vo);
		
	}
	
	@RequestMapping("deleteMemo.do")
	@ResponseBody
	public void deleteMemo(MemoVO vo) {
		memoService.deleteMemo(vo);
	}
	
}
