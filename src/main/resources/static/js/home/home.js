'use strict';

var home = angular.module('home', ['share', 'constants']);

home.factory('HomeService', ['$http', '$q', 'CONST', function($http, $q, CONST) {

	var factory = {
		fetchUser : fetchUser
	};

	return factory;

	function fetchUser(username) {
		var deferred = $q.defer();
		$http({
			url : CONST.API_USER + username,
			method : 'GET'
		}).success(function(data) {
			console.log('Fetch data for user: ', username);
			deferred.resolve(data);
		}).error(function(error) {
			console.error('Error while fetching user: ', username);
			deferred.reject();
		});
		return deferred.promise;
	}
}]);


home.controller('HomeCtrl', ['$http', 'currentUser', 'HomeService', function($http, currentUser, HomeService) {

	var username = currentUser.getUser();
	var self = this;
	
	fetchUser(username);
	
	function fetchUser(username){
		HomeService.fetchUser(username)
		.then(
		function(data){
			self.user = data;
		},
		function(errResponse){
			console.error('Error while fetching user: ', username);
		}
		);
	}

}]);
