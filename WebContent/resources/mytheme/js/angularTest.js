//Demonstrate how you get data from another angular file (module)
 demoApp = angular.module('demoApp',['ngRoute','countryControllers','angularSoap']);

//Factory
demoApp.factory("demoFactory", function (){
	var factory={};
	var data=[{name:"alex", address:"zondra"},{name:"chilikov",address:"no idea"}];
	factory.getData=function(){
		return data;
	};
	
	return factory;
});

demoApp.controller('SimpleController2',function($scope,demoFactory){
	$scope.data=demoFactory.getData();
	$scope.controllerName="Controller 2";
	
	$scope.remove= function(name){
		for (var i=0;i<$scope.data.length;i++){
			if ($scope.data[i].name==name)
				$scope.data.splice(i,1);
		}
		
	};
});

//if angular minified the $scope, $http so on are minified as well and
//angular cannot read them
//That is why use this approach
demoApp.controller("MinifiedCaseController", ['$scope',function(scope){
	//names in function(scope,..) can be anything, they are scope in our case
	//body, use: scope.something
}]);


demoApp.controller('SimpleController', function ($scope,demoFactory){
	$scope.test="test";
	$scope.data=demoFactory.getData();
	$scope.controllerName="SimpleController1";
	$scope.addPerson=function (){
		$scope.data.push({name:$scope.name,address:$scope.address});
		$scope.name="";
		$scope.address="";
	};
	
	$scope.delPerson= function (){
		for (var i=0;i<$scope.data.length;i++){
			if ($scope.data[i].name==$scope.delName)
				$scope.data.splice(i,1);
		}
		$scope.delName="";
	};
	
	$scope.sortedField="name";
	//Change orderBy
	$scope.reverse=true;
	
	//invoke when lastName is changed
	$scope.$watch('lastName',function(newValue,oldValue){
		//some code
	});
	
	setTimeout(function(){
		$scope.lastName= 'Smith';
		//this asynchronous function is not managed by Angular
		//To apply changes do:
		$scope.$apply();
	},1000);
	
	
});

demoApp.controller("PathParamController",['$scope','$routeParams',function($scope,$routeParams){
	$scope.pathParam=$routeParams.name;
	
}]);

//Factory caching data

demoApp.factory("FetchFactory", function($http){
	var cachedData;
	
	return {
		list: function(callback){
			if (cachedData)
				callback(cachedData);
			else{
			$http.get('countries.json').success(function(data){
				cachedData = data;
				callback(data);
			});
			}
		}
	};
});

//Example controller using FetchFactor
demoApp.controller("FetchController",['$scope','FetchFactory',function($scope,FetchFactory){
	FetchFactory.list(function(dataReceived){
		$scope.data=dataReceived;
	});
}]);
	
demoApp.config(function($routeProvider){
	$routeProvider
		.when('/',
				{
					controller:"SimpleController",
					templateUrl:"partials/angularTest1.jsp"
				})
	    .when('/view2',
	    		{
	    			controller:"SimpleController2",
	    			templateUrl:"partials/angularTest2.jsp"
	    		})
//	    .when('/:name',{
//	    	controller:"PathParamController",
//	    	templateUrl:"partials/angularPathParam.jsp"
//	    		})
	    .when('/',{
	    	controller: "MainCtrl",
	    	templateUrl: "partials/soapTest.jsp"
	    })
	    .otherwise({redirectTo:"/"});
});

// Custom filters
demoApp.filter("encodeFilter", function(){
	return window.encodeURI;
});

// Custom directives

/*
 * A - <span ng-sparkline></span>
 * E - <ng-sparkline></ng-sparkline>
 * C - <span class="ng-sparkline"></span>
 * M - <! -- directive: ng-sparkline -->
 */
demoApp.directive("country",function(){
	return {
		restrict: 'A',
		templateUrl: "country.jsp",
			//also direct template: "<div ..></div>" allowed
		scope: {
			country: '='
		},
		controller: function($scope){
			//do sth
		}
	}; 
});




demoApp.factory("testService", ['$soap',function($soap){
    var base_url = "http://www.cooldomain.com/SoapTest/webservicedemo.asmx";

    return {
        CreateUser: function(firstName, lastName){
            return $soap.post(base_url,"CreateUser", {firstName: firstName, lastName: lastName});
        }
    };
}]);

demoApp.controller('MainCtrl', function($scope, testService) {

  testService.CreateUser($scope.firstName, $scope.lastName).then(function(response){
    $scope.response = response;
  });

});