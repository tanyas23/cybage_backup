'use strict';

angular.module('project.factory', []).
factory('$exceptionHandler',function($injector){
    return function(exception, cause){
        var rScope = $injector.get('$rootScope');
        if(rScope){
            rScope.$broadcast('exception',exception, cause);
        }
    };
});