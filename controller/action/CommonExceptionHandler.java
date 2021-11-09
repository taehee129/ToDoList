package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("controller.action")
public class CommonExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerExcetion(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("excetion",e);
		mav.setViewName("excep/error.jsp");
		return mav;
	}

}
