'use strict';

angular.module('todoApp', ['todoService']).
        config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
            when('/todo/list', {templateUrl:'views/todo-list.html', controller:TodoListController}).
            when('/todo/new', {templateUrl:'views/todo-new.html', controller:TodoController}).
            when('/todo/:id', {templateUrl:'views/todo-new.html', controller:TodoController}).
            otherwise({redirectTo:'/todo/list'});
}]);
