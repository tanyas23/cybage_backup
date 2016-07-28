'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('project.services', []).

service('projectEventService', function($resource) {
    return $resource('', {}, {
      getAll: {method:'GET',isArray:true, url:'projectEventsAll'},
      get: {method:'GET', params: {id: "@id" }, url:'projectEvent' + '/:id' },
      submit: {method:'POST', url:'projectEvent'},
     
    });
});