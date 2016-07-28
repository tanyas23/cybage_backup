
//Display and edit table
function getIterationData($scope,$http)
	{
	$(".container-editIteration").hide();
   		
/*	var dataService = $resource("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchiterations");
	  $scope.jsonobj = dataService.query();*/
	$http.get("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchiterations")
    	.success(function(response2) {
    		$scope.jsonstring = response2;
    		$scope.jsonobj = angular.fromJson($scope.jsonstring);
    });
   		$scope.edititeration=function(index) {
   			
   			$(".container-searchIteration").hide();
   			$(".container-editIteration").show(); 	
   			var temp=parseInt(index)-1;
 			
   			$scope.IterationTitle = $scope.jsonobj[temp].Title;
   			$scope.IterationDescription = $scope.jsonobj[temp].Discription;
   			$scope.IterationStartDate = $scope.jsonobj[temp].StartDate;
   			$scope.IterationEndDate = $scope.jsonobj[temp].EndDate;
   			$scope.IterationItems = $scope.jsonobj[temp].Items;			
   			$scope.IterationStatus = $scope.jsonobj[temp].Status;
   			$scope.IterationType = $scope.jsonobj[temp].Type;	
   			$scope.index=$scope.jsonobj[temp].index;
   		}
   		
}


function getReleaseData($scope,$http)
{
	$(".container-editrelease").hide(); 
	
		 $http.get("http://localhost:8080/ALM-ReleaseManagement/releasemanagement/searchrelease")
	.success(function(response3) {
		$scope.jsonstring1 = response3;
		$scope.jsonobj1 = angular.fromJson($scope.jsonstring1);
}); 
		$scope.editrelease=function(index) {
			
			$(".container-searchrelease").hide();
			$(".container-editrelease").show(); 
			var temp=parseInt(index)-1;
			$scope.ReleaseTitle = $scope.jsonobj1[temp].Title;
			$scope.ReleaseDescription = $scope.jsonobj1[temp].Discription;
			$scope.ReleaseStartDate = $scope.jsonobj1[temp].StartDate;
			$scope.ReleasePlannedDate = $scope.jsonobj1[temp].PlannedDate;
			$scope.ReleaseReleaseDate = $scope.jsonobj1[temp].ReleaseDate;			
			$scope.ReleaseType = $scope.jsonobj1[temp].Type;
			$scope.ReleaseTo = $scope.jsonobj1[temp].To ;	
			$scope.ReleaseItems=$scope.jsonobj1[temp].Items;
			$scope.ReleaseStatus=$scope.jsonobj1[temp].Status;
			$scope.ReleaseManager=$scope.jsonobj1[temp].Manager;
			$scope.ReleaseVersion=$scope.jsonobj1[temp].Version;
			//,,,
		}
		
}



 
sampleApp.controller('resourceController', function($scope, $resource) {
	  var dataService = $resource('http://localhost:8080/gontu_MVC1_NoAnnotations/greeting/Iteration/ToJSONobj');
	  $scope.data = dataService.query();
	}); 



sampleApp.controller('searchrelease', function($scope) {
	$(".container-editrelease").hide();
	$scope.releaseJSON = [
	  					{index:0,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',PlannedDate:'01-Sep-2014',ReleaseDate:'01-Sep-2014',Type:'MileStone',To:'Dev Test',Items:'sad',Status:'Planned',Manager:'Manager',Version:'bre'},
	  					{index:1,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
	  					{index:2,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
	  					{index:3,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'},
	  					{index:4,Title:'brb',Discription:'sad',StartDate:'lol',PlannedDate:'sad',ReleaseDate:'sad',Type:'vre',To:'erb',Items:'sad',Status:'ert',Manager:'117StartDate',Version:'bre'}
	  				];
	//$scope.IterationTitle="works";   //value gets set
	$scope.editrelease=function(index) {
		
		$(".container-searchrelease").hide();
		$(".container-editrelease").show();
		$scope.ReleaseTitle = $scope.releaseJSON[index].Title;
		$scope.ReleaseDescription = $scope.releaseJSON[index].Discription;
		$scope.ReleaseStartDate = $scope.releaseJSON[index].StartDate;
		$scope.ReleasePlannedDate = $scope.releaseJSON[index].PlannedDate;
		$scope.ReleaseReleaseDate = $scope.releaseJSON[index].ReleaseDate;
		$scope.ReleaseType = $scope.releaseJSON[index].Type;
		$scope.ReleaseTo = $scope.releaseJSON[index].To;
		$scope.ReleaseItems = $scope.releaseJSON[index].Items;
		$scope.ReleaseStatus = $scope.releaseJSON[index].Status;
		$scope.ReleaseManager = $scope.releaseJSON[index].Manager;
		$scope.ReleaseVersion = $scope.releaseJSON[index].Version;
	}
});
 


