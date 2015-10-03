var app=angular.module('officeAdvisor',[]);

app.controller('mainController',["$http",function($http){
//	while(true){
//		setTimeout(function (){
//			$http.get('http://localhost:8080/AngularAndSpring/getRequest').success(function(data){})
//			},5000);
//	}
	
	var map;
	
	//$http.get('/AngularAndSpring/getRequest').success(function(data){
//		var heatMapData = data;
		var heatMapData = [
		                   {location: new google.maps.LatLng(55.756068694055,-4.818744050540207), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(55.042788526455325,-4.9900493119597975), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(55.43977976342554,-4.000426305274605), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(54.85088539366103,-3.487719056377666), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(54.87213660598709,-4.321847098636997), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(55.60257588007879,-4.759397052326212), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(55.60966062348142,-4.358054329360469), weight: Math.random() * Math.random() }, 
		                   {location: new google.maps.LatLng(55.0,-4.669373779202712), weight: Math.random() * Math.random() }
	];

		    function initMap() {
		      map = new google.maps.Map(document.getElementById('map'), {
		        center: new google.maps.LatLng(55.8580,-4.259),
		        zoom: 7,
		        mapTypeId: google.maps.MapTypeId.ROADMAP
		      });
		      console.log('maps-API has been loaded, ready to use');
		    }
		 
		 

		    var heatmap = new google.maps.visualization.HeatmapLayer({
		      data: heatMapData,
		      radius:50,
		      dissipating:false
		    });
		    
		    
		    
		google.maps.event.addDomListener(window, 'load', initMap);
	//	setTimeout(function(){initMap(); }, 5000);
		setTimeout(function(){heatmap.setMap(map); }, 500);

		window.load =  console.log("should be ok");
	//});
	
	
}]);