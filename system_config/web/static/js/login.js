
var app = angular.module('start',['ui.bootstrap']);
app.config(function ($httpProvider) {
	//$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
});
app.controller('loginController',function($scope,$http,$httpParamSerializer){
	$scope.loginData={username:'cookie',password:'1'};
	//登陆
	$scope.login=function(){
		console.log($scope.loginData);
		$http.post('./login_check',$scope.loginData).success(function(data){
			if(data=="true"){
				console.log(data);
			}else{
				console.log(data);
			}
		}).error(function(error){
			console.log(error);
		});
	};

	$scope.logout= function () {
		$http.get('./logout.json').success(function (data) {
			console.log(data);
		});
	}

})

;