var app = angular.module('clienteApp', []);
app.controller('ClienteController', function ($scope, $http) {
    
    $scope.salvar = function () {
        console.log($scope.fields);
        $http({
            method: 'POST',
            data: $scope.fields,
            url: '/RESTful_CRUD/rest/cliente',
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
        $http.get('/RESTful_CRUD/rest/cliente').success(function (data) {
            $scope.clientes = data;
            $scope.existemDados = true;
        });
    };

    $scope.consultar = function(cli) {
        $http.get('/RESTful_CRUD/rest/cliente/' + cli.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
        });
    };

    $scope.excluir = function(cli) {
        $http.delete('/RESTful_CRUD/rest/cliente/' + cli.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
            $scope.todos();
        });
    };
    
});
