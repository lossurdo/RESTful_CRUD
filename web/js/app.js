/* ***********************************************************
 * Definição do import dos controller que serão utilizados
 */
var app = angular.module('myApp', [
    'ngRoute'
    ,'TemplateController'
    ,'ClienteController'
]);

/* ***********************************************************
 * Controle dos roteamentos
 */
app.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'partials/principal.html',
      controller: 'IndexController'
    })
    .when('/pesquisar-cliente', {
      templateUrl: 'partials/pesquisar-cliente.html',
      controller: 'ClienteController'
    })
    .otherwise({
      redirectTo : '/'
    });
});

/* ***********************************************************
 * Controle da página principal
 */
app.controller('IndexController', function($scope, $http, $location) {

});
