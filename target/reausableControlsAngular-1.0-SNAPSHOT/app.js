'use strict';

var app = angular.module('myApp', []);
app.filter('nameFilter', function() {
    return function(input){
        return input.lastName + ',' + input.firstName;
    };
});
app.directive('loginForm', function(){
    return{
        restrict: "AE",
        templateUrl:"login.html"
    };    
});
app.service('caseService', function() {
    var self = this;
    self.titleCase = function(input) {
        var arr = input.split(' ');
        for (var i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substr(0,1).toUpperCase() + arr[i].substr(1,arr[i].length-1);
        }
        return arr.join(' ');
    };
    self.camelCase = function(input){
        var arr = input.split(' ');
        for (var i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substr(0,1).toUpperCase() + arr[i].substr(1,arr[i].length-1);
        }
        return arr.join('');;
    };
    self.dashCase = function(input){
        var arr = input.split(' ');
        for (var i = 0; i < arr.length; i++) {
            arr[i];
            
        }
        return arr.join('-');
    };
});
app.controller('MyController',['$scope','caseService',function($scope, caseService) {
    $scope.titleCase = caseService.titleCase("hej med dig");
    $scope.camelCase = caseService.camelCase("hej med dig");
    $scope.dashCase = caseService.dashCase("hej med dig");
}]);

