'use strict';

var app = angular.module('myApp.view6', ['ngRoute']);
app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view6', {
            templateUrl: 'app/view6/view6.html',
            controller: 'signUpCtrl'
        });
    }]);

app.controller("signUpCtrl", function ($scope, $http) {
    $scope.user = {username: "Frank", password: "password", repassword: "password"};

    $scope.addUser = function () {
        if (this.user.password === this.user.repassword) {
            $http.post('api/signup', this.user)
                    .success(function (data) {
                        alert("You have successfully created an account!");
                    })
                    .error(function (data) {
                        console.log(data);
                    });
        }

    };
});