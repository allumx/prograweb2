'use-strict';
angular.module('orderApp',[]).controller('orderCtrl',function($scope, $http,$window){
	 $scope.showInformation = false;
	 $scope.selectedOrder = {
			 orderNumber: null,
			 date: null,
			 items: {
				 flavours: [],
				 products: []
			 }
	 };
            $scope.getOrders = function(){
      		  $http.get('http://localhost:8085/PW2SpringMVCBase/getOrders').then(function(response){
      			  $scope.orders = response.data;
              });
            }
            
            $scope.getOrder = function(id){
            	$scope.selectedOrder.products = [];
            	$scope.showInformation = true;
        		  $http.post('http://localhost:8085/PW2SpringMVCBase/getOrder', id).then(function(response){
        			  $scope.selectedOrder.orderNumber = response.data.id;
        			  $scope.selectedOrder.date = response.data.date;
        			  angular.forEach(response.data, function(value, key){
        			        if(key == "itemsList"){
        			        	angular.forEach(value, function(value, key){
        			        		$scope.selectedOrder.items.products.push(value.product.name);
        			        		angular.forEach(value.flavourList, function(value, key){
            			        		$scope.selectedOrder.items.flavours.push(value.name);
            			        	})
        			        	}) 
        			        } 
        			    });
                  });            	
            }
            
            $scope.changeOrderState = function(id){
            	alert("ok");
            }
            
            $scope.deleteOrder = function(id){
      		  $http.delete('http://localhost:8085/PW2SpringMVCBase/deleteOrder/'+ id).then(function(response){
              });    
            }
            
            $scope.init = function(){
            	$scope.getOrders();
              }
            
            $scope.init();
            
});