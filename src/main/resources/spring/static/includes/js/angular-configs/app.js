'use strict';
var ShenkarDBApp = angular.module('ShenkarDBApp', [
  'ui.router',
  'teachersInformationModule'
]);


ShenkarDBApp.config(function($stateProvider, $urlRouterProvider) {
	  $urlRouterProvider.otherwise("/teachers");

	  $stateProvider.state('teachers', {
		url: "/teachers",
		controller : 'teachersInformationController',
		templateUrl : 'includes/views/Teachers.html'
	});
});