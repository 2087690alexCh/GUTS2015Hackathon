var app=angular.module('officeAdvisor',[]);

app.controller('mainController',["$http",function($http){
	
	var map;
	
	var heatMapData;
	
	var request = $.get("http://localhost:8080/AngularAndSpring/getRequest");
	
	request.done(function(data) {
		window.heatMapData = [];
//		window.heatMapData = [
//{location: new google.maps.LatLng(55.756068694055,-4.818744050540207), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(55.042788526455325,-4.9900493119597975), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(55.43977976342554,-4.000426305274605), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(54.85088539366103,-3.487719056377666), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(54.87213660598709,-4.321847098636997), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(55.60257588007879,-4.759397052326212), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(55.60966062348142,-4.358054329360469), weight: Math.random() * Math.random() }, 
//{location: new google.maps.LatLng(55.0,-4.669373779202712), weight: Math.random() * Math.random() }
//];
		for (i = 0; i < data.length; i++) { 
			window.heatMapData.push( {location: new google.maps.LatLng(data[i].lat,data[i].lng), weight: Math.random() * Math.random()});
		}
//		var stringres = "";
//		for(var i in data) {
//			stringres += ("{location: new google.maps.LatLng(" + data[i].lat + "," + data[i].lng + "), weight:" + data[i].score + "},");
//		}
		
		
//		stringres = stringres.substring(0, stringres.length - 1);
//		console.log(stringres);
//		window.heatMapData.push(stringres);
//		
		var heatmap = new google.maps.visualization.HeatmapLayer({
		      data: window.heatMapData,
		      radius:300,
		      dissipating:true
		    });
		heatmap.setMap(map);
		setTimeout(function(){heatmap.setMap(map);}, 2000);
	});
	

	function initMap() {
	   map = new google.maps.Map(document.getElementById('map'), {
	      center: new google.maps.LatLng(55.8580,-4.259),
	      zoom: 14,
	      scrollwheel: false,
	      zoomControl: false,
	      streetViewControl: false,
	      mapTypeId: google.maps.MapTypeId.ROADMAP
	   });
	   
	}
	 
	 

	    
	    

	    
		google.maps.event.addDomListener(window, 'load', initMap);
	
		
//		heatMapData = [
//		                   {location: new google.maps.LatLng(55.756068694055,-4.818744050540207), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(55.042788526455325,-4.9900493119597975), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(55.43977976342554,-4.000426305274605), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(54.85088539366103,-3.487719056377666), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(54.87213660598709,-4.321847098636997), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(55.60257588007879,-4.759397052326212), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(55.60966062348142,-4.358054329360469), weight: Math.random() * Math.random() }, 
//		                   {location: new google.maps.LatLng(55.0,-4.669373779202712), weight: Math.random() * Math.random() }
//	];

		   
	
	
}]);