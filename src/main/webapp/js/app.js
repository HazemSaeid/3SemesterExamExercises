var myApp = angular.module('myApp', ['ngRoute']);
myApp.config(function ($routeProvider) {
    $routeProvider
            .when("/allCars", {
                templateUrl: "views/allCars.html",
                controller: "CarController"
            }).when("/addCar", {
        templateUrl: "views/addCar.html",
        controller: "CarController"

    }).when("/editCar", {
        url: '/editCar/:id',
        templateUrl: "views/editCar.html",
        controller: "EditController"
    }).otherwise({
        redirectTo: "views/allCars.html"
    });




});
    myApp.controller('CarController', ['CarFactory', '$scope', function (CarFactory, $scope) {
        $scope.cars = CarFactory.getCars();
        
        $scope.predicate = 'year';
        $scope.reverse = false;
        
        $scope.deleteCar = function(id) {
            CarFactory.deleteCar(id);
            $scope.cars = CarFactory.getCars();
        }

    }]);

