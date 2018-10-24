'use-strict';
angular.module('registerApp',[]).controller('registerCtrl',function($scope, $http,$window){

            $scope.register = function(user){
            	user.type = "1";
            	debugger;
            }
});