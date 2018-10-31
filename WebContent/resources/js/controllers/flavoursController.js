'use-strict';
angular.module('flavoursApp',[]).controller('flavoursCtrl',function($scope, $http,$window){
	 
	 
            $scope.getFlavours = function(){
        		  $http.get('http://localhost:8080/PW2SpringMVCBase/getFlavours').then(function(response){
          			  $scope.flavours = response.data;
                  });
            }
            
            $scope.getFlavour = function(id){
        		  $http.post('http://localhost:8080/PW2SpringMVCBase/getFlavour', id).then(function(response){
        			  $scope.flavour = response.data;
                });
    			  $('#editModal').modal('show');
              }
            
            $scope.editFlavour = function(editedFlavour){
            	editedFlavour.id = $scope.flavour.id;
            	
            	if(editedFlavour.name === undefined ) {
            		editedFlavour.name = $scope.flavour.name;
            	}
            	if (editedFlavour.salePrice === undefined){
            		editedFlavour.salePrice = $scope.flavour.salePrice;
            	} 
            	if(editedFlavour.costPrice === undefined){
            		editedFlavour.costPrice = $scope.flavour.costPrice ;
            	}
        		  $http.post('http://localhost:8080/PW2SpringMVCBase/editFlavour', editedFlavour).then(function(response){
        			  location.reload();
        			  });
              }
            
            $scope.addFlavour = function(newFlavour){
        		  $http.post('http://localhost:8080/PW2SpringMVCBase/addFlavour', newFlavour).then(function(response){
        			  location.reload();
        			  });
              }
            
            
            $scope.deleteFlavour = function(id){
        		  $http.delete('http://localhost:8080/PW2SpringMVCBase/deleteFlavour/'+ id).then(function(response){
        			  location.reload();
                  }); 
            }
            
            $scope.init = function(){
            	$scope.getFlavours();
          }
           
            $scope.init();
            
});