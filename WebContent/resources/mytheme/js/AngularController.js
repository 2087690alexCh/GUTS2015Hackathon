var demoApp = angular.module('demoApp',['ngRoute']);

//Factory
demoApp.factory("ExampleFactory", function (){
	var factory={};
	var customers=[
	                  { name: 'alex', city: 'Phoenix'},
	                  { name: 'Jamie', city: 'Atlanta'}
	                  ];
	factory.getCustomers=function (){
		return customers;
	};
	
	return factory;
});

demoApp.controller('SimpleController', function ($scope,ExampleFactory){
//	$scope.customers=[
//	                  { name: 'alex', city: 'Phoenix'},
//	                  { name: 'Jamie', city: 'Atlanta'}
//	                  ];
	
	$scope.customers=ExampleFactory.getCustomers();
	$scope.addCustomer = function (){
		$scope.customers.push({ name: $scope.newCustomer.name,
			city: $scope.newCustomer.city});
	
	};
	$scope.test="test";
	$scope.deleteFunction = function (){
		
		for (var i=0;i<$scope.customers.length;i++){
			if ($scope.customers[i].name==$scope.deletedName)
				$scope.customers.splice(i,1);
		}
		
	};
});




demoApp.config(function ($routeProvider){
	$routeProvider
		.when('/view1',
				{
					controller: 'SimpleController',
					templateUrl: 'View1.jsp'
				})
	     .when('/view2',
	    		 {
	    			 controller: 'SimpleController',
	    			 templateUrl: 'View2.jsp'	    				 
	    		 })
	    .otherwise({redirectTo:'/view1'});
});

