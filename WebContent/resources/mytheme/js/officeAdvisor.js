var app=angular.module('officeAdvisor',[]);

app.controller('mainController',["$http",function($http){
	$http.get('http://localhost:8080/AngularAndSpring/getRequest').success(function(data){
	
	});
}]);