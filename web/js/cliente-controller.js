var app = angular.module('clienteApp', []);
app.controller('ClienteController', function ($scope, $http) {
    $scope.salvar = function () {
        console.log($scope.fields);
        $http({
            method: 'POST',
            data: $scope.fields,
            url: '/RESTful_CRUD/rest/cliente/salvar',
            headers: {'Content-Type': 'application/json'}
        }).success(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        }).error(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        });
    };
    
    $scope.todos = function() {
        $http.get('/RESTful_CRUD/rest/cliente/todos').success(function (data) {
            $scope.clientes = data;
            $scope.existemDados = true;
        });
    };

    $scope.consultar = function(cli) {
        $http.get('/RESTful_CRUD/rest/cliente/' + cli.codigo).success(function (data) {
            $scope.fields = data;
        });
    };

    $scope.excluir = function(cli) {
        $http({
            method: 'POST',
            data: cli,
            url: '/RESTful_CRUD/rest/cliente/excluir',
            headers: {'Content-Type': 'application/json'}
        }).success(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        }).error(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        });
    };
});
