package br.com.irsa.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

		@RequestMapping("/home")
		public String home(){
			return "home";
		}
		
		@RequestMapping("/")
		public String index(){
			return home();
		}
}
