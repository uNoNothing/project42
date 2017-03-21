angular.module('auth', ['sharing']).factory('auth', function($rootScope, $http, $location, currentUser) {

	var auth = {
		authenticated : false,

		loginPath : '/login',
		logoutPath : '/logout',
		homePath : '/',

		authenticate : function(credentials, callback) {

			var headers = credentials && credentials.username ? {
				authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)
			} : {};

			$http.get('api/userauthentication', {
				headers : headers
			}).then(function(response) {
				if (response.data.name) {
					auth.authenticated = true;
					currentUser.setUser(response.data.name);
					console.log("User: \"", response.data.name, "\" Authenticated");
				} else {
					auth.authenticated = false;
					currentUser.setUser("");
					console.log("User: \"", credentials.username, "\" NOT Authenticated");
				}

				$location.path(auth.path == auth.loginPath ? auth.homePath : auth.path);
			}, function() {
				auth.authenticated = false;
				currentUser.setUser(credentials.username);
				console.log("User: \"", credentials.username, "\" NOT Authenticated");
				callback && callback(false);
			});
		},

		clear : function() {
			auth.authenticated = false;
			console.log("User Logged Out")
			$location.path(auth.loginPath);
			$http.post(auth.logoutPath, {});
		},

		init : function(homePath, loginPath, logoutPath) {
			auth.homePath = homePath;
			auth.loginPath = loginPath;
			auth.logoutPath = logoutPath;

			auth.authenticate({}, function(authenticated) {
				if (authenticated) {
					$location.path(auth.path);
				}
			});

			$rootScope.$on('$routeChangeStart', function() {
				enter();
			});
		}

	};

	enter = function() {
		if ($location.path() != auth.loginPath) {
			auth.path = $location.path();
			if (!auth.authenticated) {
				$location.path(auth.loginPath);
			}
		}
	}

	return auth;
});