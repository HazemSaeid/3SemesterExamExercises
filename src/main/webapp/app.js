/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("myApp", []);
//ex3
app.service("MyService", function () {
    var self = this;
    self.getRandomNumber = function (n) {
        n = Math.floor((Math.random() * 36) + 1);
        return n;
    };
    self.getRandomString = function (n) {
        return Array(n + 1).join((Math.random().toString(36) + '00000000000000000').slice(2, 18)).slice(0, n);
    };
});
app.controller("Controller", function ($scope, MyService) {
    $scope.randomNumber = MyService.getRandomNumber();
    $scope.randomString = MyService.getRandomString(5);
});
//ex1a
app.controller("MyController", [function () {
        var self = this;
        self.persons = [
            {name: 'Hans', gender: 'male', age: 8}, {name: 'Grethe', gender: 'female', age: 7},
            {name: 'Frederik', gender: 'male', age: 61}, {name: 'Hassan', gender: 'male', age: 13},
            {name: 'Karen', gender: 'female', age: 31}];
        console.log(self.persons);
    }]);
app.filter("myFilter", function () {
    return function (persons) {
        var arr = [];
        angular.forEach(persons, function (person) {
            if (person.age >= 6 && person.age <= 15) {
                arr.push(person);
            }
        });
        return arr;
    };
});
    //Ex2b
    app.directive("linkDemo", [function() {
        return {
            restrict: "AE",
            link: function(scope, element, attrs){
                var attributeParts = attrs.linkDemo.split(',');
                scope.images = [];
                console.log(attributeParts);
                for (var i = 0; i < attributeParts.length; i++) {
                    scope.images.push(attributeParts[i]);
                    
                }
            }
        };    
    }]);
//ex1b
app.controller("ChessCtrl", function ($scope) {
    $scope.board = ["wr", "wkn", "wb", "wq", "wk", "wb", "wkn", "wr"];
});
app.filter("Chess", ['$sce', function ($sce) {
        return function (input) {
            var arr = ["&#9820;", "&#9822;", "&#9821;", "&#9819;", "&#9818;", "&#9821;", "&#9822;", "&#9820;"];
            var output;
            if (input == "wr") {
                output = arr[0];
            } else if (input == "wkn") {
                output = arr[1];
            } else if (input == "wb") {
                output = arr[2];
            } else if (input = "wq") {
                output = arr[3];
            } else if (input = "wk") {
                output = arr[4];
            } else if (input = "wb") {
                output = arr[5];
            } else if (input = "wkn") {
                output = arr[6];
            } else if (input = "wr") {
                output = arr[7];
            }
            return $sce.trustAsHtml(output);
        };
    }]);

//ex2a    
app.controller("DirectiveController", ['$scope', function ($scope) {
        $scope.user = {companyName: "Coolest Company on Earth", 
            companyUrl: "http://www.cool.cooler.com", 
            created: new Date()
        };
    }]);
        app.directive("formatCompany", function() {
            return {
                restrict: "AE",
                templateUrl: "format-company.html"
            };
        });
       
       
app.factory('CountryFactory', ['$http', function ($http) {
        var countryFactory = {};
        var allCountries = "https://restcountries.eu/rest/v1/all";
        var allAfrica = "https://restcountries.eu/rest/v1/region/africa";
        var allCode = "https://restcountries.eu/rest/v1/alpha?codes=gb";
        countryFactory.getAllCountries = function () {
            return $http.get(allCountries);
        };
        countryFactory.getAfrica = function () {
            return $http.get(allAfrica);
        };
        countryFactory.getCode = function () {
            return $http.get(allCode);
        };
        return countryFactory;
    }]);

//EX4
app.controller('CountryController', ['$scope','CountryFactory', function($scope, CountryFactory) {
        $scope.getAllCountries = function(){
            CountryFactory.getAllCountries().then(function(response){
                $scope.countries = response.data;
            }, function(error){
                console.log(error);
            });
        };
        $scope.getAfricanCountries = function() {
            CountryFactory.getAfrica().then(function(response) {
                $scope.african = response.data;
            }, function(error) {
                console.log(error);
            });
        };
        $scope.getCountriesByCode = function() {
            CountryFactory.getCode().then(function(response){
                $scope.code = response.data;
            }, function(error){
                console.log(error);
            });
        };
        $scope.getCountriesByCode();
        $scope.getAfricanCountries();
       $scope.getAllCountries();
}]);
app.directive('countryDirective', function() {
    return {
        restrict: "AE",
        templateUrl: "countries.html"
    };
});