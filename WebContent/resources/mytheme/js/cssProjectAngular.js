cssApp = angular.module("cssApp",["ngRoute"]);

cssApp.controller("IndexController",["$scope", function ($scope){
	
}]);

cssApp.config(function($routeProvider){
	$routeProvider
		.when("/",{
			controller: "IndexController",
			templateUrl: "partials/cssProject/IndexPage.jsp"
		})
		.when("/workExamples",{
			controller: "IndexController",
			templateUrl: "partials/cssProject/workExamples.jsp"
		})
		.otherwise({redirectTo: "/"});
});