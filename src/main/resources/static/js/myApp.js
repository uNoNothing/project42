angular.module('myApp', ['ngRoute', 'sharing', 'auth', 'home', 'navigation']).config(function($locationProvider, $routeProvider, $httpProvider) {

	$locationProvider.html5Mode(true);

	$routeProvider.when('/', {
		templateUrl : 'js/home/home.html',
		controller : 'home',
		controllerAs : 'controller'
	}).when('/login', {
		templateUrl : 'js/navigation/login.html',
		controller : 'navigation',
		controllerAs : 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

}).run(function(auth) {
	auth.init('/', '/login', '/logout');
});