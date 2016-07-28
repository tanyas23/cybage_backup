'use strict';

/* Controllers */
angular.module('project.controllers',[]).

controller('addEventCtrl',["$routeParams","projectEventService","$scope", function($routeParams,projectEventService,$scope) {
	alert("in controller");
	$scope.isSubmitted = false;
	$scope.isFailure = false;
	//$scope.project = projectService.get({ id : $routeParams.pid, pid : $routeParams.pid});
	//var tProj = $scope.project; 
	$scope.ProjectEvent=false;
	$scope.newProjectEvent=true;
	//$scope.response=false;
	//console.log($scope.project);
	$scope.submitProjectEvent = function() {
		alert("in submit");
		
		//$scope.projectEvent.project = tProj;
		projectEventService.submit($scope.projectEvent, function () {
			alert("submit 2");
			console.log('scope is', scope);
			alert("submit 3");
			$scope.isSubmitted = true;
			$scope.isFailure = false;
			$scope.projectEvent = {};
		},
		function() {
			$scope.isFailure = true;
			$scope.isSubmitted = false;
		});
		$scope.projectEvent = {};
		$("#myModal2").modal ('hide'); 
	};
    $('input').keyup(function() {
        this.value = this.value.toUpperCase();
        makeAllCaps($scope.projectEvent);
      });

    function makeAllCaps(Object) {
        for (var key in Object) {
        if(typeof Object[key] == 'number') {}
        else Object[key] = Object[key].toUpperCase();
       }
     }
}]).
controller('showEventsCtrl',["projectEventService","$scope","$routeParams", function(projectEventService,$scope,$routeParams) {
	//$scope.projectId = $routeParams.pid;	
	$scope.isException=false;
	$scope.projectEvents=projectEventService.getAll( function(responsedata) {
	},function(data)
	{
		$scope.isException=true;
		throw { message: 'Project Id Not Found' };	
	});
	
	$scope.$on('exception',function(e,cause){
	     $scope.exception = cause;
	  });
}]).
controller('showEventCtrl',["projectEventService","$scope","$routeParams", function(projectEventService,$scope,$routeParams) {
	alert("in event by id");
	$scope.response=true;
	$scope.ProjectEvent=true;
	$scope.isException=false;
	$scope.newProjectEvent=false;
	$('input,textarea').attr("readonly", true);
	$scope.projectId = $routeParams.pid;
	$scope.projectEvent = projectEventService.get({ pid: $routeParams.pid}, {id: $routeParams.id}, function(responsedata) {
		console.log("asdasd");
	},function(data)
	{
		$scope.isException=true;
		console.log("asdasd");
		throw { message: 'Event Id Not Found' };	
	});
	
	$scope.$on('exception',function(e,cause){
	     $scope.exception = cause;
	  });
}]);

