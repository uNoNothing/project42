'use strict';

var home = angular.module('home', ['sharing', 'constants']);

home.factory('HomeService', ['$http', '$q', 'CONSTANTS', function($http, $q, CONSTANTS) {

	var factory = {
		fetchUser : fetchUser
	};

	return factory;

	function fetchUser(username) {
		var deferred = $q.defer();
		$http({
			url : CONSTANTS.API_USER + username,
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


home.controller('HomeCtrl', ['$http', 'currentUser', 'CONSTANTS', 'HomeService', function($http, currentUser, CONSTANTS, HomeService) {

	var username = currentUser.getUser();
	var self = this;
	
	fetchUser(username);

/*	$http.get(CONSTANTS.API_USER + username).then(function(response) {
		self.user = response.data;
	})*/
	
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
