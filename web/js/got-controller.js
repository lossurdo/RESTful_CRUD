var app = angular.module('gotApp', []);
app.controller('GotController', function ($scope, $http) {
    
    $scope.salvar = function () {
        console.log($scope.fields);
        $http({
            method: 'POST',
            data: $scope.fields,
            url: '/RESTful_CRUD/rest/got',
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
        $http.get('/RESTful_CRUD/rest/got').success(function (data) {
            $scope.got = data;
            $scope.existemDados = true;
        });
    };

    $scope.consultar = function(got) {
        $http.get('/RESTful_CRUD/rest/got/' + got.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
        });
    };

    $scope.excluir = function(got) {
        $http.delete('/RESTful_CRUD/rest/got/' + got.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
            $scope.todos();
        });
    };
    
});
