angular.module("personList", [
    "ui.router"
]);

angular.module("personList").config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('home', {
            url: "/",
            templateUrl: 'personList.html',
            controller: "MainController"
        })
        .state('newPerson', {
            url: "/new-person",
            templateUrl: 'new.html',
            controller: "PersonController"
        })
        .state('details', {
            url: "/details/:id",
            templateUrl: 'details.html',
            controller: "PersonController"
        });
}]);

angular.module("personList").constant("persons",
    {
        personsList: [
            {id: 1, name: 'Hazem', age: 22},
            {id: 2, name: 'Emilie', age: 18},
            {id: 3, name: 'Lars', age: 12},
            {id: 3, name: 'thomas', age: 16},
            {id: 3, name: 'David', age: 16}
        ]
    }
);

angular.module("personList").controller("ListController", ['persons', '$scope', function (persons, $scope) {
    $scope.persons = persons.personsList;
}]);

angular.module("personList").controller("PersonController", ['$stateParams', 'persons', '$scope', function ($stateParams, persons, $scope) {
    for (var i = 0, max = persons.personsList.length; i < max; i++) {
        if (persons.personsList[i].id == $stateParams.id) {
            $scope.person = persons.personsList[i];
        }
    }

    $scope.addPerson = function () {
        persons.personsList.push({id: persons.personsList.length + 1, name: $scope.name, age: $scope.age});
    };
}]);

