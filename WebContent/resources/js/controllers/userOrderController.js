'use-strict';
angular.module('userOrderApp',[]).controller('userOrderCtrl',function($scope, $http,$window){

	$scope.select=[];
	$scope.itemsList=[];
	$scope.selectedProduct="";
	var selectedFlavours=[];

     $scope.getFlavours = function(){
		  $http.get('http://localhost:8080/PW2SpringMVCBase/getFlavours').then(function(response){
 			  $scope.flavours = response.data;
 			  setBtnUnselect();
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
    	 setBtnUnselect();
    	 $scope.selectedProduct="";
    	 
     } 
     
     $scope.addFlavour = function(flavour){
    	 if($scope.selectedProduct!=""){
    		 if(!flavour.selectFl){
        		 if(selectedFlavours.length<$scope.selectedProduct.quantity){
            		 selectedFlavours.push(flavour);
            		 flavour.selectFl=true;
            		 
            	 }
            		 
            	 else
            		 alert("No se admiten mas gustos");
        	 }
        	 else{
        		 rmFlfromArray(flavour);
        		 flavour.selectFl=false;
        	 }
    	 }
    	 else
    		 alert("Por favor seleccione un producto");
    	 
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
     var setBtnUnselect=function(){
    	 for(i in $scope.flavours){
    		 $scope.flavours[i].selectFl=false;
    	 }
     }
     var rmFlfromArray=function(fl){
    	 for(i in selectedFlavours){
    		 if(selectedFlavours[i].id==fl.id){
    			 selectedFlavours.splice(i,1);
    			 break;
    		 }	 
    	 }
     }
     $scope.getCost=function(){
    	 var total=0;
    	 if($scope.itemsList.length==0)
    		 return "$ "+0.0;
    	 else{
    		 for(i in $scope.itemsList){
    			 total=total+$scope.itemsList[i].product.price;
    		 }
    		 return "$ "+total;
    	 }
     }
     $scope.init = function(){
    	 $scope.getFlavours();
         $scope.getProducts();
         var a=1;
     }
            
     $scope.init();
            
});