var navigation = angular.module('navigation', ['auth']);

navigation.controller('NavCtrl', ['auth', function(auth) {

	var self = this;

	self.credentials = {};

	self.authenticated = function() {
		return auth.authenticated;
	};

	self.login = function() {
		auth.authenticate(self.credentials, function(authenticated) {
			if (authenticated) {
				console.log("Login Succeeded")
				self.error = false;
			} else {
				console.log("Login Failed")
				self.error = true;
			}
		});
	};

	self.logout = function() {
		auth.clear();
	};

}]);