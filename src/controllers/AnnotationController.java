package controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
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
		
		try {
			URL url = new URL("https://raw.githubusercontent.com/2087690alexCh/GUTS2015Hackathon/master/src/controllers/CityEvents.txt");
	        BufferedReader br = new BufferedReader(
	        new InputStreamReader(url.openStream()));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    shop.setName(everything);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
