/* RUTAS DE ADMINISTRADOR */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
	
	$urlRouterProvider.otherwise("/content/welcome"); //welcome

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider
	    .state('content', {
	        url: "/content",
	        templateUrl: "common/content",//controller
	        data: { pageTitle: 'Desarollo Comercial' }
	    })
        .state('content.welcome', {
            url: "/welcome",
            templateUrl: "common/welcome",
            data: { pageTitle: 'Desarollo Comercial' }
        })
        .state('content.avance_venta', {
            url: "/avance_venta",
            templateUrl: "home_division/avance_venta",
            data: { pageTitle: 'Avance de Ventas' },
	        resolve: {
	            loadPlugin: function ($ocLazyLoad) {
	                return $ocLazyLoad.load([
	                    {
	                        serie: true,
	                        name: 'angular-flot',
	                        files: [ 'static/js/plugins/flot/jquery.flot.js', 
	                        	'static/js/plugins/flot/jquery.flot.time.js', 
	                        	'static/js/plugins/flot/jquery.flot.tooltip.min.js', 
	                        	'static/js/plugins/flot/jquery.flot.spline.js', 
	                        	'static/js/plugins/flot/jquery.flot.resize.js', 
	                        	'static/js/plugins/flot/jquery.flot.pie.js', 
	                        	'static/js/plugins/flot/curvedLines.js', 
	                        	'static/js/plugins/flot/angular-flot.js' ]
	                    },
	                    {
	                        serie: true,
	                        files: ['static/js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js', 
	                        	'static/js/plugins/jvectormap/jquery-jvectormap-2.0.2.css']
	                    },
	                    {
	                        serie: true,
	                        files: ['static/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
	                    },
	                    {
	                        name: 'ui.checkbox',
	                        files: ['static/js/bootstrap/angular-bootstrap-checkbox.js']
	                    }
	                ]);
	            }
        }
        })
        .state('content.usuarios', {
            url: "/usuarios",
            templateUrl: "home_admin/usuarios",
            data: { pageTitle: 'Administrador' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: ['static/js/plugins/dataTables/datatables.min.js',
                            	'static/css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            files: ['static/js/plugins/jasny/jasny-bootstrap.min.js',
                            	'static/css/plugins/jasny/jasny-bootstrap.min.css']
                        },                        
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['static/js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['static/js/plugins/dataTables/angular-datatables.buttons.min.js']
                        },
                        {
                            name: 'ui.switchery',
                            files: ['static/css/plugins/switchery/switchery.css',
                            	'static/js/plugins/switchery/switchery.js',
                            	'static/js/plugins/switchery/ng-switchery.js']
                        }
                    ]);
                }
            }
        })
        .state('content.import', {
            url: "/import",
            templateUrl: "home_admin/import",
            data: { pageTitle: 'Import' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: ['static/js/plugins/sheetJS/jszip.js',
                            		'static/js/plugins/sheetJS/xlsx.full.min.js']
                        },
                        {
                            serie: true,
                            files: ['static/js/plugins/jasny/jasny-bootstrap.min.js',
                            	'static/css/plugins/jasny/jasny-bootstrap.min.css']
                        }
                    ]);
                }
            }
        })
}
angular
    .module('ngadmin')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });