'use-strict';
angular.module('userOrderApp',[]).controller('userOrderCtrl',function($scope, $http,$window){

	$scope.select=[];
	$scope.itemsList=[];
	$scope.selectedProduct='';
	$scope.canshowFlavours = false;
	$scope.canShowButtonOrder = false;
	$scope.selectedFlavours=[];

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
     
     $scope.addItem= function(){
    	 var item={};
    	 item.product=$scope.selectedProduct;
    	 item.flavourList=$scope.selectedFlavours;
    	 $scope.itemsList.push(item);
    	 setBtnUnselect();
    	 $scope.selectedProduct="";
    	 $scope.canshowFlavours = false;
    	 $scope.canShowButtonOrder = true;	
    	 $scope.selectedFlavours =[];
     } 
     
     $scope.addFlavour = function(flavour){
    	 if($scope.selectedProduct!=""){
    		 if(!flavour.selectFl){
        		 if($scope.selectedFlavours.length<$scope.selectedProduct.quantity){
            		 $scope.selectedFlavours.push(flavour);
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
    	 $scope.selectedFlavours=[];
    	 $scope.canshowFlavours = true;
    	 setBtnUnselect();
     }
     var setBtnUnselect=function(){
    	 for(i in $scope.flavours){
    		 $scope.flavours[i].selectFl=false;
    	 }
     }
     var rmFlfromArray=function(fl){
    	 for(i in $scope.selectedFlavours){
    		 if($scope.selectedFlavours[i].id==fl.id){
    			 $scope.selectedFlavours.splice(i,1);
    			 break;
    		 }	 
    	 }
     }
     $scope.getCost=function(){
    	 var total=0;
    	 debugger
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