'use-strict';
angular.module('userOrderApp',[]).controller('userOrderCtrl',function($scope, $http,$window){
	$scope.miflavour = null; 
	
	$scope.itemsList=[];
	$scope.selectedProduct="";
	var selectedFlavours=[];

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
     
     $scope.addItem= function(){
    	 var item={};
    	 item.product=$scope.selectedProduct;
    	 item.flavourList=selectedFlavours;
    	 $scope.itemsList.push(item);
    	
    	 
     } 
     
     $scope.addFlavour = function(flavour){
    	 if(selectedFlavours.length<$scope.selectedProduct.quantity)
    		 selectedFlavours.push(flavour);
    	 else
    		 alert("No se admiten mas gustos por favor reinicie el producto");
  }
     $scope.completeOrder= function(){
    	 //enviamos todo el objeto de orden validado 
   		  $http.get('http://localhost:8080/PW2SpringMVCBase/createOrder', order).then(function(response){
			  location.reload();
        });
     } 
     
     $scope.selectProduct=function(){
    	 selectedFlavours=[];
     }
            $scope.init = function(){
            	$scope.getFlavours();
            	$scope.getProducts();
            	
              }
            
            $scope.init();
            
});