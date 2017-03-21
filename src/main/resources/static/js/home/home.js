angular.module('home', ['sharing']).controller('home', function($http, currentUser) {

	var self = this;

	$http.get('/api/read/user/' + currentUser.getUser()).then(function(response) {
		self.home = response.data;
	})
});