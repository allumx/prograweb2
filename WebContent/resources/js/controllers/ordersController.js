'use-strict';
angular.module('orderApp', []).controller('orderCtrl', function($scope, $http, $window) {
    $scope.showInformation = false;
    var port = window.location.port;

    $scope.getOrders = function() {
        $http.get('http://localhost:'+port+'/PW2SpringMVCBase/getOrders').then(function(response) {
            $scope.orders = response.data;
            $scope.totalOrders = response.data.length;
        });
    }

    $scope.getOrder = function(id) {
        // items=[];
        $http.post('http://localhost:'+port+'/PW2SpringMVCBase/getOrder', id).then(function(response) {
            $scope.selectedOrder = response.data;
            $('#logoutModal').modal('show');
        });
        /*
		 * $scope.selectedOrder.items.products = [];
		 * $scope.selectedOrder.items.flavours = []; $scope.showInformation =
		 * true; $http.post('http://localhost:8080/PW2SpringMVCBase/getOrder',
		 * id).then(function(response){ $scope.selectedOrder.orderNumber =
		 * response.data.id; $scope.selectedOrder.date = response.data.date;
		 * angular.forEach(response.data, function(value, key){ if(key ==
		 * "itemsList"){ angular.forEach(value, function(value, key){
		 * $scope.selectedOrder.items.products.push(value.product.name);
		 * angular.forEach(value.flavourList, function(value, key){
		 * $scope.selectedOrder.items.flavours.push(value.name); }) }) } });
		 * $('#logoutModal').modal('show');
		 */

    }
    
        $scope.filterByDate = function(from, to ) {
        	var filter = {};
        	filter.from = from.getTime();
        	filter.to = to.getTime();
        	
        	 $http.post('http://localhost:'+port+'/PW2SpringMVCBase/filterProfitByDate', filter).then(function(response) {
                 $scope.orders = response.data;
                  $scope.getTotalPofit($scope.orders);
             });
    }
        
        $scope.getTotalPofit = function(orders) {
        	var total = 0; 
        	for (var orderIndex in orders) {
        		  total += orders[orderIndex].total;
        		}
        	$scope.totalProfit =total;
        	
    }
        
        

    $scope.deleteOrder = function(id) { // id menos uno dado que tiene que
										// pasarse como indice del array
        var orden = $scope.orders[id - 1];
        $http.delete('http://localhost:'+port+'/PW2SpringMVCBase/deleteOrder/' + id).then(function(response) {
            $scope.init();
        });
    }

    $scope.changeOrderState = function(id) {

        $http.post('http://localhost:'+port+'/PW2SpringMVCBase/changeOrderState/' + id).then(function(response) {
            $scope.init();
        });
    }

    $scope.init = function() {
        $scope.getOrders();
    }

    $scope.init();

});