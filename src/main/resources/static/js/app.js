var myApp = angular.module('myApp', ['ngRoute', 'sharing', 'auth', 'home', 'navigation']);

myApp.config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {

	$locationProvider.html5Mode(true);

	$routeProvider.when('/', {
		templateUrl : 'js/home/home.html',
		controller : 'HomeCtrl',
		controllerAs : 'controller'
	}).when('/login', {
		templateUrl : 'js/navigation/login.html',
		controller : 'NavCtrl',
		controllerAs : 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

}]);

myApp.run(['auth', function(auth) {
	auth.init('/', '/login', '/logout');
}]);