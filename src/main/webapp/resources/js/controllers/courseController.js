
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