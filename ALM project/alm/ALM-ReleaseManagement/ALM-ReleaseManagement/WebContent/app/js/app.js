var app = angular.module('app', ['ngRoute'])

app.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			controller: 'ChaptersController',
			templateUrl: 'view/chapters.html'
		})
		.when('/partials/editrelease.html', {
			controller: 'release',
			templateUrl: 'partials/editrelease.html'
		})
		.when('/addNote/:chapterId', {
			controller: 'AddNoteController',
			templateUrl: 'view/addNote.html'
		})
		.when('/deleteNote/:chapterId/:noteId', {
			controller: 'DeleteNoteController',
			templateUrl: 'view/addNote.html'
		})
	;
});
