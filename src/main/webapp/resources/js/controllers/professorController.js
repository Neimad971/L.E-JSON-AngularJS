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