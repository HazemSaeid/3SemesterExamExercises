var app = angular.module('examApp', []);
app.controller("MyController", ["$scope", "StudentFactory", "restFac", function ($scope, StudentFactory, restFac) {
        $scope.studentsInfo = StudentFactory.student;
//        console.log($scope.studentsInfo);
//        console.log(StudentFactory.student);
//        
//        EXAMPLE ON HOW WE CAN FETCH DATA IF WE HAD A REST CALL
//        $scope.getRestCall = function () {
//            restFac.getRestCall().then(function (response) {
//                $scope.rest = response.data;
//            }, function (error) {
//                return"woops, something went wrong" + error;
//            });
//        };
    }]);
app.filter("average", function () {
    return function (input) {
        var output = [];
        var number = 0;
        angular.forEach(input, function (student) {
            student.average = 0;
            number = 0;
            for (var i = 0; i < student.grades.length; i++) {
                if (!angular.equals(student.grades[i], {})) {
                    number++;
                    student.average += parseInt(student.grades[i].grade);
                }
            }
            student.average = (student.average) / number;
            output.push(student);
        });
        return output;
    };

});
app.directive("studentDirective", function () {
    return {
        restrict: "AE",
        templateUrl: "students.html"
    };
});
app.factory("StudentFactory", function () {

    var studentsInfo = {};
    studentsInfo.allCourses = [
        {courseId: 1000, courseName: "Basic Programming"},
        {courseId: 1001, courseName: "Advanced Programming"},
        {courseId: 1003, courseName: "DataBase Intro"}];
    studentsInfo.students = [];
    studentsInfo.students.push({studentId: 100, name: "Peter Hansen", grades: [{grade: "10"}, {grade: "12"}, {}]});
    studentsInfo.students.push({studentId: 101, name: "Jan Olsen", grades: [{grade: "7"}, {grade: "10"}, {}]});
    studentsInfo.students.push({studentId: 102, name: "Gitte Poulsen", grades: [{grade: "7"}, {grade: "7"}, {}]});
    studentsInfo.students.push({studentId: 103, name: "John McDonald", grades: [{grade: "10"}, {}, {grade: "7"}]});
    return {student: studentsInfo};

});
//app.factory('restFac', ['$http', function ($http) {
//        var restFac = {};
//        var call = "www.jdnaskjdnasjk.dk/dbhasbd/ds";
//        restFac.getRestCall = function () {
//            return $http.get(call);
//        };
//        return restFac;
//    }]);