package controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Models.Event;
import Models.EventType;
import Models.Grid;
import Models.MapNode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@RestController
public class AnnotationController {
	Grid grid = new Grid(50, 56, -5, 75);
	
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
	public @ResponseBody List<MapNode> getShopInJSON() {
		List<Event> events = new ArrayList<Event>();
		
		try {
			URL url = new URL("https://raw.githubusercontent.com/2087690alexCh/GUTS2015Hackathon/master/src/controllers/CityEvents.txt");
	        BufferedReader br = new BufferedReader(
	        new InputStreamReader(url.openStream()));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
		    
		    while (line != null) {
		    	String dateString = line.substring(0, 30);
		    	try{
			    	Date date = format.parse(dateString);
			    	System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
				    
			    	Event event = new Event();
			    	event.setDate(date);
			    	String[] words = line.split(" |\t"); 
			    	event.setLat(Double.parseDouble(words[6]));
			    	event.setLng(Double.parseDouble(words[7]));
			    	event.setEventType(EventType.valueOf(words[8]));
			    	event.setPeople(Integer.parseInt(words[9]));
			    	
			    	// deprecate me!!!
			    	events.add(event);
			    	grid.register(event);
		    	}
		    	catch (ParseException e){} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			    
		        line = br.readLine();
		        
		    }
		  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grid.getNodes();
		
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
