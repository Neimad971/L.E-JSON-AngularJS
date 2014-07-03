'use strict';

//(function()
//{*
	
	var app = angular.module('learningengine',['ngRoute', 'ngGrid', 'ui.bootstrap']);
	
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
	
	
	
	app.controller('CourseController', ['$scope', '$http', '$route', function ($scope, $http, $route) 
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
				$route.reload();
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
	
	
	app.controller('ProfessorController', ['$scope', '$http', '$route', function ($scope, $http, $route) 
 	{
		$scope.message = "professor";
		
		$scope.items = ['dropOffResult', 'addCourse', 'addAssessment'];
		
		
		$scope.dropOffResult = function ()
		{
			$scope.selection = $scope.items[0];
		};
		
		$scope.addCourse = function ()
		{
			$scope.selection = $scope.items[1];
		};
		
		$scope.addAssessment = function ()
		{
			$scope.selection = $scope.items[2];
		};
		
		
		$scope.submitAssessmentResult = function ()
		{
			var result = $scope.resultForm;
			
			$http.post('app/dropoffresult', result).success(function()
			{
				alert("Le resultat a ete posté");
				$route.reload();
			});
		};
		
		
		$scope.submitCourse = function ()
		{
			var course = $scope.courseForm;
			
			$http.post('app/dropoffcourse', course).success(function()
			{
				alert("Le cours a ete posté");
				$route.reload();
			});
		};
		
		$scope.submitAssessment = function ()
		{
			var assessment = $scope.assessmentForm;
			
			$http.post('app/dropoffassessment', assessment).success(function()
			{
				alert("L'évaluation a ete posté");
				$route.reload();
			});
			
		};
		
		
 	}]);
	
	
	app.controller('DatepickerDemoCtrl',['$scope', function($scope)
	{
		$scope.today = function() 
		{
			$scope.dt = new Date();
		};
	    $scope.today();
	
	    
	    $scope.clear = function () 
	    {
	    	$scope.dt = null;
	    };
	
	    // Disable weekend selection
	    $scope.disabled = function(date, mode) 
	    {
	    	return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	    };
	
	  
	    $scope.toggleMin = function() 
	    {
	    	$scope.minDate = $scope.minDate ? null : new Date();
	    };
	    $scope.toggleMin();
	    
	
	    $scope.open = function($event) 
	    {
	    	$event.preventDefault();
	    	$event.stopPropagation();
	
	    	$scope.opened = true;
	    };
	
	  
	    $scope.dateOptions = 
	    {
    		formatYear: 'yy',
    		startingDay: 1
	    };
	
	  
	    $scope.initDate = new Date('2016-15-20');
	    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate', 'EEEE d MMMM yyyy'];
	    $scope.format = $scope.formats[4];
		
	}]);
	
	
	app.controller('AssessmentsController', ['$scope', '$http', function ($scope, $http) 
	{
		$scope.message = "assessments";
		
		$http.get('app/assessments').success(function(myAssessments)
		{
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