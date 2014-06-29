'use strict';

//(function()
//{*
	
	var app = angular.module('learningengine',['ngRoute', 'ngGrid']);
	
	app.config(['$routeProvider', function($routeProvider) 
	{
      $routeProvider.
        when('/app',
        {
          templateUrl: 'resources/views/home.html',
          controller: 'HomeController'
        }).
        when('/app/courses',
        {
          templateUrl: 'resources/views/allCourses.html',
          controller: 'CourseController'
        }).
        when('/app/courses/:courseId',
        {
          templateUrl: 'resources/views/oneCourse.html',
          controller: 'CourseDetailController'
        }).
        otherwise(
        {
          redirectTo: '/app'
        });
    }]);

	
	app.controller('HomeController', ['$scope', function ($scope) 
	{
         $scope.message = "home page";
    }]);
	
	
	
	app.controller('CourseController', ['$scope', '$http', '$location', function ($scope, $http, $location) 
	{
		 $scope.message = "all courses page";
		 
		 //do GET to find all courses
         $http.get('app/courses').success(function(allCourses)
		 {
        	$scope.myData = allCourses;		// to feel ngGrid
    		$scope.courses = allCourses;	//for databinding to the view 
        	
		 });
         
         //set ngGrid properties  
         $scope.mySelections = [];
         $scope.myData = [];
		 $scope.gridOptions = 
		 {
			data : 'myData',
			selectedItems : $scope.mySelections,
			multiSelection : false,
			columnDefs: 
				[{field:'name', displayName:'Intitule'},
	             {field:'validated', displayName:'Validé'}]
		 };
	
		 
 		//Follow one or several course(s) 
		$scope.submitSelectedCourses = function ()
		{
			var selectedCourses = $scope.mySelections;
	 		
			// do POST to submit selected course(s)
			$http.post('app/subscribe', selectedCourses).success(function()
			{
				alert("Vous etes maintenant inscrit au(x) cours que vous avez selectione(s)");
			});
			
			
		};
 		 
		
		//show my courses
		$scope.getMyCourses = function ()
		{
			// do GET to find my course(s)
			$http.get('app/mycourses').success(function(myCourses)
			{
				$scope.myData = myCourses;		// to feel ngGrid
				$scope.courses = myCourses;	//for databinding to the view 
			        	
			});
		};
	}]);
	
	
	
	
	


//})();