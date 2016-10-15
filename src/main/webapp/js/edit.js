/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('myApp').controller('EditController', ['CarFactory', '$scope', '$routeParams', '$location', function (CarFactory, $scope, $routeParams, $location) {
            $scope.id = $routeParams.id;
            $scope.newcar = CarFactory.getCarById($scope.id);
        $scope.editCar = function (car) {
            car.id = $routeParams.id;
            CarFactory.addEditCar(car);
            $location.path("/allCars");
        };
    }]);