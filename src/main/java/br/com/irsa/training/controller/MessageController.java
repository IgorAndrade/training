package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageSource msg;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMessage(@RequestParam("cod") String cod, @RequestParam(value="param", required=false) String param) {
		if(param == null || param.equals(""))
			return msg.getMessage(cod,null, null);
		else{
			String[] params = param.split(";");
			return msg.getMessage(cod,params, null);
		}
	}
}
