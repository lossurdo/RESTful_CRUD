var app = angular.module('personagemApp', []);
app.controller('PersonagemController', function ($scope, $http) {
    
    $scope.salvar = function () {
        console.log($scope.fields);
        $http({
            method: 'POST',
            data: $scope.fields,
            url: '/RESTful_CRUD/rest/personagens',
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
        $http.get('/RESTful_CRUD/rest/personagens').success(function (data) {
            $scope.personagens = data;
            $scope.existemDados = true;
        });
    };

    $scope.consultar = function(personagem) {
        $http.get('/RESTful_CRUD/rest/personagens/' + personagem.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
        });
    };

    $scope.excluir = function(personagem) {
        $http.delete('/RESTful_CRUD/rest/personagens/' + personagem.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
            $scope.todos();
        });
    };
    
});
