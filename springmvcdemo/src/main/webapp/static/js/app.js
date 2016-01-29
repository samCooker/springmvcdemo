
angular.module('webapp',['ui.bootstrap'])
	.controller('loginController',LoginController)
;

function LoginController($scope,$http,$httpParamSerializer){
	
	$scope.submit=function(){
		var req = {
				 method: 'POST',
				 url: '/spring-simple-demo/login_check',
				 headers: {
				   'Content-Type': 'application/x-www-form-urlencoded'
				 },
				 data: $httpParamSerializer({username:'sam',password:1,roletype:"admin"})
				};
	    $http(req);
	};
	
	$scope.logout=function(){
		$http.post("/spring-simple-demo/logout").then(function(data){
			console.log(data);
		});
	}
	
}