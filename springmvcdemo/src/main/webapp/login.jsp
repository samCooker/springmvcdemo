<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>

<script type="text/javascript" src="lib/angularjs/angular.min.js"></script>
<script type="text/javascript" src="lib/angular-animate/angular-animate.min.js"></script>
<script type="text/javascript" src="lib/uiboostrap/ui-bootstrap-tpls.js"></script>

<script type="text/javascript" src="static/js/login.js"></script>

<link rel="stylesheet" href="libs/boostrap/css/bootstrap.min.css" />
<title>login demo•</title>
</head>
<body ng-app="webapp">
<div ng-controller='loginController'>
	<table >
		<tr>
			<td>username:</td>
			<td><input type ='text' name='username'></td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type ='password' name='password'></td>
		</tr>
		<tr>
			<td><button type="button" class='btn btn-default' ng-click="logout()">clear</button></td>
			<td><button type="button" class='btn btn-default' ng-click="submit()">submit</button></td>
		</tr>
	</table>
</body>
</html>
