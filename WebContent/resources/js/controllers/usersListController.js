'use-strict';
angular.module('usersListApp',[]).controller('usersListCtrl',function($scope, $http,$window){
	var port = window.location.port;
	 
	 
            $scope.getUsers = function(){
        		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getUsers').then(function(response){
          			  $scope.users = response.data;
          			  
                  });
            }
            
            
            $scope.giveAdminRole = function(user){
      		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/giveAdminRole', user).then(function(response){
        			  $scope.users = response.data;
        			  
                });
          }
            
            
            $scope.init = function(){
            	$scope.getUsers();
          }
           
            $scope.init();
            
});