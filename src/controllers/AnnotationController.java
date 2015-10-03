package controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Models.ShopPOJO;

@RestController
public class AnnotationController {
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Welcome to MVC");
		return modelAndView;
	}
	
	@RequestMapping("/hackathon")
	public ModelAndView hackathon(){
		ModelAndView modelAndView = new ModelAndView("hackHome");
		modelAndView.addObject("welcomeMessage", "Welcome to MVC");
		return modelAndView;
	}
	

	@RequestMapping(value="/getRequest")
	public @ResponseBody ShopPOJO getShopInJSON() {
		ShopPOJO shop = new ShopPOJO();
		shop.setName("testName");		
		return shop;

	}

	@RequestMapping("/welcome/{name}")
	public ModelAndView welcomeTo(@PathVariable("name") String name){
		ModelAndView modelAndView = new ModelAndView("WelcomeTo");
		modelAndView.addObject("name",name);
		return modelAndView;
	}
	
	@RequestMapping("/welcome/{name}/{country}")
	public ModelAndView mapWelcome(@PathVariable Map<String,String> data){
		ModelAndView modelAndView = new ModelAndView("WelcomeTo");
		modelAndView.addObject(data.get("name"));
		modelAndView.addObject(data.get("country"));
		
		return modelAndView;
		
	}
	
	@RequestMapping("/cssTest")
	public ModelAndView cssTest(){
		return new ModelAndView("cssTest");
		
	}
	
	@RequestMapping("/cssProject")
	public ModelAndView cssProject(){
		return new ModelAndView("cssProject");
	}
}
