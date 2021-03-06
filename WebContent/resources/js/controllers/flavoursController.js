'use-strict';
angular.module('flavoursApp',[]).controller('flavoursCtrl',function($scope, $http,$window){
	var port = window.location.port;
	 
	 
            $scope.getFlavours = function(){
        		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getFlavours').then(function(response){
          			  $scope.flavours = response.data;
                  });
            }
            
            $scope.getFlavour = function(id){
        		  $http.post('http://localhost:'+port+'/PW2SpringMVCBase/getFlavour', id).then(function(response){
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
        		  $http.post('http://localhost:'+port+'/PW2SpringMVCBase/editFlavour', editedFlavour).then(function(response){
        			  location.reload();
        			  });
              }
            
            $scope.addFlavour = function(newFlavour){
        		  $http.post('http://localhost:'+port+'/PW2SpringMVCBase/addFlavour', newFlavour).then(function(response){
        			  location.reload();
        			  });
              }
            
            
            $scope.deleteFlavour = function(id){
        		  $http.delete('http://localhost:'+port+'/PW2SpringMVCBase/deleteFlavour/'+ id).then(function(response){
        			  location.reload();
                  }).catch(function(e){
                	  debugger;
                	  alert("Se deberan borrar todas las ordenes para eliminar este gusto.");
                  });
            }
            
            $scope.init = function(){
            	$scope.getFlavours();
          }
           
            $scope.init();
            
});