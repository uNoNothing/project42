var sharing = angular.module('sharing', []);
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