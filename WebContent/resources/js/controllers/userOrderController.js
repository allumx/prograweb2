'use-strict';
angular.module('userOrderApp',[]).controller('userOrderCtrl',function($scope, $http,$window){
	$scope.miflavour = null; 
     $scope.getFlavours = function(){
		  $http.get('http://localhost:8080/PW2SpringMVCBase/getFlavours').then(function(response){
 			  $scope.flavours = response.data;
         });
   }
     
     $scope.getProducts = function(){
		  $http.get('http://localhost:8080/PW2SpringMVCBase/getProducts').then(function(response){
			  $scope.products = response.data;
        });
  }
     
     $scope.addProduct= function(product){
     } 
     
     $scope.addFlavour = function(flavour){
    	 $scope.miflavour = flavour.name;
  }
    
     
            $scope.init = function(){
            	$scope.getFlavours();
            	$scope.getProducts();
            	
              }
            
            $scope.init();
            
});