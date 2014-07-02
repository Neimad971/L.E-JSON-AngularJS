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
        when('/app/results',
        {
          templateUrl: 'resources/views/myResults.html',
          controller: 'AssessementResultController'
        }).
        when('/app/asProfessor',
        {
          templateUrl: 'resources/views/asProfessor.html',
          controller: 'ProfessorController'
        }).
        when('/app/assessments',
                {
                  templateUrl: 'resources/views/myAssessments.html',
                  controller: 'AssessmentsController'
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
	
	
	
	app.controller('CourseController', ['$scope', '$http', function ($scope, $http) 
	{
		 $scope.message = "all courses page";
		 
		 //do GET to find all courses
         $http.get('app/courses').success(function(allCourses)
		 {
        	$scope.myData = allCourses;		// to feel ngGrid
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
				[{field:'name', displayName:'Intitulé'},
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
				//$route.reload();
			});
			
			
		};
 		 
		
		//show my courses
		$scope.getMyCourses = function ()
		{
			// do GET to find my course(s)
			$http.get('app/mycourses').success(function(myCourses)
			{
				$scope.myData = myCourses;		// to feel ngGrid
			});
		};
	}]);
	
	
	app.controller('AssessementResultController', ['$scope', '$http', function ($scope, $http) 
  	{
		$scope.message = "assessementResult";
		
		//do GET to find my results
        $http.get('app/results').success(function(myResults)
		{
        	$scope.myData = myResults;		// to feel ngGrid
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
				[{field:'assessmentName', displayName:'Cours'}]
		 };
    }]);
	
	
	app.controller('ProfessorController', ['$scope', '$http', function ($scope, $http) 
 	{
		$scope.message = "professor";
		
		$scope.items = ['dropOffResult', 'addCourse'];
		
		
		$scope.dropOffResult = function ()
		{
			$scope.selection = $scope.items[0];
		};
		
		$scope.addCourse = function ()
		{
			$scope.selection = $scope.items[1];
		};
		
		
		$scope.submitAssessmentResult = function ()
		{
			var result = $scope.resultForm;
			
			$http.post('app/dropoffresult', result).success(function()
			{
				alert("Le resultat a ete poster");
			});
		};
		
		
		$scope.submitCourse = function ()
		{
			var course = $scope.courseForm;
			
			$http.post('app/dropoffcourse', course).success(function()
			{
				alert("Le cours a ete poster");
			});
		};
		
 	}]);
	
	
	app.controller('AssessmentsController', ['$scope', '$http', function ($scope, $http) 
	{
		$scope.message = "assessments";
		
		$http.get('app/assessments').success(function(myAssessments)
		{
			alert(typeof myAssessments);
			$scope.myData = myAssessments;
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
				[{field:'title', displayName:'Intitulé'}]
		};
	}]);
	
	


//})();