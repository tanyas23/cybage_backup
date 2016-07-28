
//Define an angular module for our app
var sampleApp = angular.module('sampleApp', []);
 
sampleApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/newrelease', {
        templateUrl: 'newrelease.html',
       controller: '' // change later
    }).
      when('/searchrelease', {
        templateUrl: 'searchrelease.html',
        controller: 'searchrelease'
      }).
      when('/newiteration', {
          templateUrl: 'newiteration.html',
          controller: ''
        }).
       when('/searchiteration', {
            templateUrl: 'searchiteration.html',
            controller: 'searchiteration'
          }).
      otherwise({
        redirectTo: '/'
      });
}]);
 
 
sampleApp.controller('searchiteration', function($scope) {
	$(".container-editIteration").hide();
	$scope.iterationJSON = [
	    					{index:0,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
	    					{index:1,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
	    					{index:2,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
	    					{index:3,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'},
	    					{index:4,Title:'brb',Discription:'sad',StartDate:'01-Sep-2014',EndDate:'01-Sep-2014',Items:'sad',Status:'Planned',Type:'MileStone'}
	    				];
	//$scope.IterationTitle="works";   //value gets set
	$scope.edititeration=function(index) {
		
		$(".container-searchIteration").hide();
		$(".container-editIteration").show();
		$scope.IterationTitle = $scope.iterationJSON[index].Title;
		$scope.IterationDescription = $scope.iterationJSON[index].Discription;
		$scope.IterationStartDate = $scope.iterationJSON[index].StartDate;
		$scope.IterationEndDate = $scope.iterationJSON[index].EndDate;
		$scope.IterationItems = $scope.iterationJSON[index].Items;			
		$scope.IterationStatus = $scope.iterationJSON[index].Status;
		$scope.IterationType = $scope.iterationJSON[index].Type;	
	}
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
 


