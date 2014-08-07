package br.com.irsa.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class homeController {

		@RequestMapping("/home")
		public String home(){
			return "home";
		}
		
		@RequestMapping(method=RequestMethod.GET)
		public String index(){
			return home();
		}
}
