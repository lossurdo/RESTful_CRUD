var app = angular.module('personagemApp', []);
app.controller('PersonagemController', function ($scope, $http, $location) {
    
    $scope.urlAtual = $location.absUrl();
    
    $scope.salvar = function () {
        console.log($scope.fields);
        $http({
            method: 'POST',
            data: $scope.fields,
            url: $scope.urlAtual + 'rest/personagens',
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
        $http.get($scope.urlAtual + 'rest/personagens').success(function (data) {
            $scope.personagens = data;
            $scope.existemDados = true;
        });
    };

    $scope.consultar = function(personagem) {
        $http.get($scope.urlAtual + 'rest/personagens/' + personagem.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
        });
    };

    $scope.excluir = function(personagem) {
        $http.delete($scope.urlAtual + 'rest/personagens/' + personagem.codigo).success(function (data) {
            console.log(data);
            $scope.fields = data;
            $scope.todos();
        });
    };
    
});
