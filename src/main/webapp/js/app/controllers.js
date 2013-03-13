'use strict';

function TodoListController($scope, $location, Todo) {
	
	$scope.loading = true;
	
    $scope.todos = Todo.query(function() {
    	$scope.loading = false ;	
    });
    
    
    $scope.gotoTodoNewPage = function () {
        $location.path("/todo/new")
    };
    $scope.deleteTodo = function (todo) {
        todo.$delete({'id':todo.id}, function () {
            $location.path('/');
        });
    };
}

function TodoController($scope, $routeParams, $location, Todo) {
	var id = $routeParams.id;
	if(id){
	    $scope.todo = Todo.get({id:id}, function (todo) {
	    });
	}
	
    
    $scope.submit = function () {
    	Todo.save($scope.todo, function (todo) {
          $location.path('/');
        });
    };
    $scope.gotoTodoListPage = function () {
        $location.path("/")
    };
    
    
}

