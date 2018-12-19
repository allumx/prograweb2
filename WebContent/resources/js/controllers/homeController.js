'use-strict';
angular.module('homeApp',[]).controller('homeCtrl',function($scope, $http,$window){
	var port = window.location.port;
	 
	 
            $scope.getFlavours = function(){
        		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getFlavours').then(function(response){
          			  $scope.flavours = response.data;
                  });
            }
            
            $scope.init = function(){
            	$scope.getFlavours();
          }
           
            $scope.init();
            
});