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
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Models.Event;
import Models.EventType;
import Models.Grid;
import Models.MapNode;
import Models.PebbleResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@RestController
public class AnnotationController {
	static Grid grid = new Grid(50, 55.7, -4.5, 75);
	static List<Event> events = new ArrayList<Event>();
	static boolean isDataRequested=false;
	static List<String> eventsNames;
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
	
//
//	@RequestMapping(value="/getRequest")
//	public @ResponseBody List<MapNode> getShopInJSON() {
//		
//		
//		if (!isDataRequested){
//		try {
//			isDataRequested=true;
//			URL url = new URL("https://raw.githubusercontent.com/2087690alexCh/GUTS2015Hackathon/master/src/controllers/CityEvents.txt");
//	        BufferedReader br = new BufferedReader(
//	        new InputStreamReader(url.openStream()));
//		    String line = br.readLine();
//		    
//		    DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
//
//		    while (line != null) {
//		    	String dateString = line.substring(0, 30);
//		    	try{
//			    	Date date = format.parse(dateString);
//			    	System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
//
//			    	Event event = new Event();
//			    	event.setDate(date);
//			    	String[] words = line.split(" |\t"); 
//			    	event.setLat(Double.parseDouble(words[6]));
//			    	event.setLng(Double.parseDouble(words[7]));
//			    	event.setEventType(EventType.valueOf(words[8]));
//			    	event.setPeople(Integer.parseInt(words[9]));
//			    	grid.register(event);
//			    	
//			    	// deprecate me!!!
//			    	events.add(event);
//		    	}
//		    	catch (ParseException e){} catch (java.text.ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				};
//			    
//		        line = br.readLine();
//		        
//		    }
//		  
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		}
//		List<Event> newEvents = new ArrayList<Event>();
//		List<Double> result = new ArrayList<Double>();
//		
//		Random randomGenerator = new Random();
//		for (int i=0;i<10;i++){
//			Event event = new Event();
//			event.setEventType(EventType.valueOf(eventsNames.get(randomGenerator.nextInt(eventsNames.size()))));
//			event.setLat(54.5+randomGenerator.nextDouble());
//			event.setLng(-5+randomGenerator.nextDouble());
//			event.setPeople(randomGenerator.nextInt(200));
//			newEvents.add(event);
//			grid.register(event);
//		}
//		
//		List<MapNode> nodes = grid.getNodes();
//		return nodes;
//		
//	}

	@RequestMapping(value="/getRequest")
	public @ResponseBody List<MapNode> getShopInJSON() {
		List<Event> events = new ArrayList<Event>();
		
		try {
			URL url = new URL("https://raw.githubusercontent.com/2087690alexCh/GUTS2015Hackathon/master/src/controllers/CityEvents.txt");
	        BufferedReader br = new BufferedReader(
	        new InputStreamReader(url.openStream()));
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
			    	grid.register(event);
			    	
			    	// deprecate me!!!
			    	events.add(event);
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
		List<MapNode> nodes = grid.getNodes();
		for(MapNode i: nodes)
			if(i.getScore()!=0.0)
				System.out.println(i);
		return nodes;
		
	}
	@RequestMapping("/getRequest/{lng}/{lat}")
	public @ResponseBody PebbleResponse getShopInJSON(@PathVariable("lng") double ourLng, @PathVariable("lat") double ourLat, HttpServletResponse response) {
		System.out.println("lat: " + ourLat + " lgn: " + ourLng);
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		List<MapNode> nodes = grid.getNodes();
		List<MapNode> notesInFiveM = new ArrayList<MapNode>();
		MapNode maxNode =nodes.get(0);
		for (MapNode curr: nodes){
			if ((curr.getLat()-ourLat<0.010736) && (curr.getLng()-ourLng<0.010736) ){
				if (curr.getScore()>maxNode.getScore())
					maxNode=curr;
			}
		}
		
		Random randomGenerator = new Random();
		
		eventsNames = new ArrayList<String>();
		eventsNames.add("RACE");
		eventsNames.add("FRAUD");
		eventsNames.add("MUGGING");
		eventsNames.add("ROBBERY");
		eventsNames.add("MURDER");
		
		PebbleResponse pR = new PebbleResponse();
		pR.setEventName(eventsNames.get(randomGenerator.nextInt(eventsNames.size())));
		pR.setLat(maxNode.getLat());
		pR.setLng(maxNode.getLng());
		pR.setScore(maxNode.getScore());
		

		if (ourLat>maxNode.getLng()){
			pR.setDirection("South");
		}
		else
			pR.setDirection("North");
		
		if (ourLng>maxNode.getLng()){
			pR.setDirection(pR.getDirection()+"-West");
		}
		else
			pR.setDirection(pR.getDirection()+"-East");
//		
		double distance=0.0;
//		double x = Math.abs(ourLng-maxNode.getLng());
//		double y = Math.abs(ourLat-maxNode.getLat());
//		distance=Math.sqrt(x*x+y*y);
		
			double R =3959; // Radius of the earth in km
			  double dLat =  Math.toRadians(maxNode.getLat()-ourLat);  // Javascript functions in radians
			  double dLon =  Math.toRadians(maxNode.getLng()-ourLng); 
			  double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
			          Math.cos( Math.toRadians(ourLat)) * Math.cos(Math.toRadians(maxNode.getLat())) *
			          Math.sin(dLon/2) * Math.sin(dLon/2); 
			  double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
			  double d = R * c; // Distance in km
		pR.setDistance(d/10);
		return pR;
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
