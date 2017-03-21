var sharing = angular.module('share', []);
sharing.service('currentUser', function() {
	var user;
	return {
		getUser : function() {
			return user;
		},
		setUser : function(value) {
			user = value;
		}
	};
});