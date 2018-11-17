'use-strict';
angular.module('userOrderApp',[]).controller('userOrderCtrl',function($scope, $http,$window, $location){
	$scope.order={};
	$scope.select=[];
	$scope.itemsList=[];
	$scope.selectedProduct='';
	$scope.canshowFlavours = false;
	$scope.canShowPartialOrder = false;
	$scope.selectedFlavours=[];
	var port = window.location.port;

     $scope.getFlavours = function(){
		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getFlavours').then(function(response){
 			  $scope.flavours = response.data;
 			  setBtnUnselect();
         });
   }
     
     $scope.getProducts = function(){
		  $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getProducts').then(function(response){
			  $scope.products = response.data;
        });
  }
     
     $scope.addItem = function(){
    	 var item={};
    	 item.product=$scope.selectedProduct;
    	 item.flavourList=$scope.selectedFlavours;
    	 $scope.itemsList.push(item);
    	 setBtnUnselect();
    	 $scope.selectedProduct="";
    	 $scope.canshowFlavours = false;
    	 $scope.canShowPartialOrder = true;	
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
    	 createObjOrder();
    	 $http.post('http://localhost:'+port+'PW2SpringMVCBase/createOrder', $scope.order).then(function(response){
            alert("Su orden fue crada exitosamente!")
    	 });
    	 
     } 
     
     $scope.selectProduct = function(){
    	 $scope.selectedFlavours=[];
    	 $scope.canshowFlavours = true;
    	 setBtnUnselect();
     }


     $scope.getCost = function(){
    	 var total=0;
    	 if($scope.itemsList.length==0)
    		 return 0.0;
    	 else{
    		 for(i in $scope.itemsList){
    			 total=total+$scope.itemsList[i].product.price;
    		 }
    		 return total;
    	 }
     }

     var setBtnUnselect = function(){
         for(i in $scope.flavours){
             $scope.flavours[i].selectFl=false;
         }
     }

     var rmFlfromArray = function(fl){
         for(i in $scope.selectedFlavours){
             if($scope.selectedFlavours[i].id==fl.id){
                 $scope.selectedFlavours.splice(i,1);
                 break;
             }   
         }
     }

     var createObjOrder = function(){
    	 var user= {
    	        "id": 1,  
    			"name": "Jose",
    			"email": "pepe@hotmail.com",
    			"address": "rivadavia 2331",
    			"phone": "111111",
    			"password": "1234",
    			"type": "2"
    	    };
    	 $scope.order.user=user;
    	 $scope.order.qr= null;
    	 $scope.order.orderType="1";
    	 $scope.order.date=1347918472690;
    	 $scope.order.total=$scope.getCost();
    	 $scope.getCost.orderState="P";
    	 $scope.order.itemsList = $scope.itemsList;
     }

     $scope.init = function(){
    	 $scope.getFlavours();
         $scope.getProducts();
     }

     $scope.init();
            
});