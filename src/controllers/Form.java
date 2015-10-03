package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Models.Student;

@Controller
public class Form {
		 
		@ModelAttribute
		public void addingCommonObjects(Model model1){
			model1.addAttribute("common for all requests", "some data");
		}
		
		@RequestMapping(value="/form", method=RequestMethod.GET)
		public ModelAndView getForm(){
			ModelAndView modelAndView = new ModelAndView("form");
			return modelAndView;
		}
		
		@RequestMapping(value="/formIntial", method=RequestMethod.POST)
		public ModelAndView postForm(@RequestParam(value="studentName", defaultValue="Mr. Nobody" ) String name, @RequestParam("studentHobby") String hobby){
			//Can use @RequestMapping Map<String,String> data, and get from map
			ModelAndView modelAndView = new ModelAndView("processedForm");
			modelAndView.addObject("studentName", name);
			modelAndView.addObject("hobby",hobby);
			
			return modelAndView;
		}
		
		//Alternative
		@RequestMapping(value="/form", method=RequestMethod.POST)
		public ModelAndView postForm(@ModelAttribute("student1") Student student){
			ModelAndView modelAndView= new ModelAndView("processedForm");
			
			return modelAndView;
		}
}
