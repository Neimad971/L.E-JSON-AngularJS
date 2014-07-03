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