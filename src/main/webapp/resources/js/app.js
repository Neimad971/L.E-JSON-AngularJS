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
		
		
         
         $http.get('app/courses').success(function(allCourses)
		 {
            // $scope.courses = allCourses;
             //alert(allCourses[0].name);
        
         
		 });  
         $scope.mySelections =[];
         //prendre mes course plutot que mes données en dur
		 $scope.myData = [{name: "fezfezf", desc : "ezdezdz", incription : false},
		                  {name: "fezfezf", desc : "ezdezdz"},
		                  {name: "fezfezf", desc : "ezdezdz"},
		                  {name: "fezfezf", desc : "ezdezdz"},{name: "fezfezf", desc : "ezdezdz"},{name: "fezfezf", desc : "ezdezdz"}];
 		
 		 $scope.gridOptions = {
 			data : 'myData',
 			selectedItems : $scope.mySelections,
 			multiSelection : false
 		 };
 		 
 		 
 		$scope.submitSelectedCourses = function (){
 			alert("submit ok");
 			
 			var input = $scope.mySelections
 			//creer une mothode pour faire un post
 			//
 			$http.post('app/courses', input).success()
 		} ;
 		 
		
       
    }]);
	
	
	
	app.controller('CourseDetailController', ['$scope', '$http', '$location','$routeParams', function ($scope, $http, $location, $routeParams) 
	{
		 
         $scope.getCourseDetail = function(idCourse) 
         {
			 $http.get('app/courses/' + idCourse).success(function(oneCourse)
	    	 {
				 
				 
				 return $scope.test = oneCourse;
				 
				// $location.path('app/courses/'+idCourse);
				 
	    	 });
        	 
         };
         
         
	}]);
	
	


//})();