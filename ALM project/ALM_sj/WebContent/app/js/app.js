'use strict';

angular.module('project', ['ngRoute','ngResource',
                           'project.services',
                           'project.controllers',
                           'project.factory']).
config(['$routeProvider',function($routeProvider) {
    $routeProvider.
        when('/', {templateUrl: 'app/partials/home.html',controller: 'ProjectList'}).
        when('/errorPage', {templateUrl: 'app/partials/errorPage.html',controller: 'errorPageCtrl'}).
    	when('/project/event/show', {templateUrl: 'app/partials/showEvent.html',controller: 'showEventsCtrl'}).
    	when('/project/event', {templateUrl: 'app/partials/addProjectEvent.html',controller: 'addEventCtrl'}).
    	when('/project/event/showbyid', {templateUrl: 'app/partials/addProjectEvent.html',controller: 'showEventCtrl'}).
    	when('project/event/showbyid/:id/addProjectEvent', {templateUrl: 'app/partials/addProjectEvent.html',controller: 'showEventCtrl'});
    
}]);    