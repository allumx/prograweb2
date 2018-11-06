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
    	 //aca se agrega  a itemlist. product

     } 
     
     $scope.additem= function(){
    	 //aca se agrega se crea el objeto
     } 
     
     $scope.addFlavour = function(flavour){
    	 $scope.miflavour = flavour.name;
    	 //aca se pushea a itemlist.flavourList
  }
     $scope.completeOrder= function(){
    	 //enviamos todo el objeto de orden validado 
   		  $http.get('http://localhost:8080/PW2SpringMVCBase/createOrder', order).then(function(response){
			  location.reload();
        });
     } 
     
     
            $scope.init = function(){
            	$scope.getFlavours();
            	$scope.getProducts();
            	
              }
            
            $scope.init();
            
});