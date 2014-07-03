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