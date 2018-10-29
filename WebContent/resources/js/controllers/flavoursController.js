'use-strict';
angular.module('flavoursApp',[]).controller('flavoursCtrl',function($scope, $http,$window){
	 
	 
            $scope.getFlavours = function(){
        		  $http.get('http://localhost:8085/PW2SpringMVCBase/getFlavours').then(function(response){
          			  $scope.flavours = response.data;
                  });
            }
            
            $scope.getFlavour = function(id){
        		  $http.post('http://localhost:8085/PW2SpringMVCBase/getFlavour', id).then(function(response){
        			  $scope.flavour = response.data;
                });
              }
            
            $scope.editFlavour = function(editedFlavour){
            	editedFlavour.id = $scope.flavour.id;
        		  $http.post('http://localhost:8085/PW2SpringMVCBase/editFlavour', editedFlavour).then(function(response){
        			  $scope.flavour = response.data;
                });
              }
            
            $scope.deleteFlavour = function(id){
        		  $http.delete('http://localhost:8085/PW2SpringMVCBase/deleteFlavour/'+ id).then(function(response){
                  }); 
            }
            
            $scope.init = function(){
            	$scope.getFlavours();
          }
           
            $scope.init();
            
});