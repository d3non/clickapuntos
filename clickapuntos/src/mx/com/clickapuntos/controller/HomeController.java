package mx.com.clickapuntos.controller;

import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import mx.com.clickapuntos.service.IHomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class HomeController{
		public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
		public IHomeService homeService;
		
		@Inject
		public void setHomeService(IHomeService homeService) {
			this.homeService = homeService;
		}		
		
		@RequestMapping({"/","/home.htm","index.htm"})
		public String showHomePage(Map<String,Object> model,				
				HttpServletRequest req){
			return "home";
		}
	}