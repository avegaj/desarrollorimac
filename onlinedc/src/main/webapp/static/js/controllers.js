/*Controladores ADMINISTRADOR*/

function adminCtrl() {
	this.userName = 'Eloyus';
    this.helloText = 'Bienvenido a Prometeo';
    this.descriptionText = '¡Vamos a lograrlo!';
};

function datatablesCtrl($scope, $http, $compile, DTOptionsBuilder, DTColumnBuilder) {
    var vm = this;
    
    vm.message = '';
    vm.editUser = editUser;
    vm.activateUser = activateUser;
    vm.infoUser = infoUser;
    vm.dtInstance = {};
    vm.persons = {};
    vm.activate = '';
    vm.nameuser = '';
    vm.descriptionuser = '';
       
    vm.dtOptions = DTOptionsBuilder.fromSource('/onlinedc/json/data/admin/entities')
	    .withPaginationType('full_numbers')
	    .withOption('createdRow', createdRow)
	    .withDOM('lTfgit<"html5buttons"pB>')
	    .withButtons([
	        {extend: 'csv'},
	        {extend: 'excel'},
	    ]);
        
    vm.dtColumns = [
        DTColumnBuilder.newColumn('id')
        	.withTitle('ID')
        	.withOption("width","10%"),
        DTColumnBuilder.newColumn(null)
        	.withTitle('Nombre')
        	.withOption("width","30%")
        	.renderWith(action1Html)
        	.notSortable(),
        DTColumnBuilder.newColumn('description')
        	.withTitle('Descripción')
        	.withOption("width","30%")
        	.notSortable(),
        DTColumnBuilder.newColumn(null)
        	.withTitle('Acciones')
        	.withOption("width","15%")
        	.withClass('column_text_center')
        	.notSortable()
            .renderWith(action2Html),
        DTColumnBuilder.newColumn(null)
        	.withTitle('Estado')
        	.withOption("width","15%")
        	.withClass('column_text_center')
        	.notSortable()
        	.renderWith(switchHtml)
    ];

    function editUser(data) {
        vm.message = 'You are trying to edit the row: ' + JSON.stringify(data.name);
        // Edit some data and call server to make changes...
        // Then reload the data so that DT is refreshed
        // vm.dtInstance.reloadData();
    }
    function activateUser(data) {
    	vm.message = 'You are activate row: ' + JSON.stringify(data.activate);
    	$http({
    		method: 'PUT',
    		url: '/onlinedc/json/data/admin/activate/'+data.id,
    		data: JSON.stringify(data),
    		headers:{
    			'Content-Type':'application/json'
    		}
    	})
    }
    function infoUser(data) {
    	vm.nameuser = data.name;
    	vm.descriptionuser = data.description;
    }
    
    function createdRow(row, data, dataIndex) {
        // Recompiling so we can bind Angular directive to the DT
        $compile(angular.element(row).contents())($scope);
        vm.persons[data.id] = data;
        vm.nameuser = vm.persons[1].name;
        vm.descriptionuser = vm.persons[1].description;
    }
    
    function action1Html(data) {
        vm.persons[data.id] = data;
        return '<a class="client-link" ng-click="showCase.infoUser(showCase.persons[' + data.id + '])">'+data.name+'</a>'
    }
    
    function action2Html(data, type, full, meta) {
        vm.persons[data.id] = data;
        return '<button type="button" class="btn btn-warning btn-circle" ng-click="showCase.editUser(showCase.persons[' + data.id + '])">' +
        '   <i class="fa fa-edit"></i>' +
        '</button>'
    }
    
    function switchHtml(data, type, full, meta) {
        vm.persons[data.id] = data;
        return '<input type="checkbox" class="js-switch" ' +
        'ui-switch="{size:' + "'small'" + ', color:' + "'#0080ff'" + '}" ' +
        'checked '+
        'ng-model="showCase.persons[' + data.id + '].activate"' +
        'ng-change="showCase.activateUser(showCase.persons[' + data.id + '])">' +
        /*'ng-true-value=1 ng-false-value=0 >' +*/
        '</input>'
        vm.dtInstance.reloadData();
    }
}

function dashboardVentas($http) {
    var vm = this;
    
    vm.message = '';
    vm.worksite = 0;
    vm.worksite_p = 0;
    vm.worksite_c1 = '';
    vm.worksite_c2 = '';
    vm.vida = 0;
    vm.vida_p = 0;
    vm.vida_c1 = '';
    vm.vida_c2 = '';
    vm.telemarketing = 0;
    vm.telemarketing_p = 0;
    vm.telemarketing_c1 = '';
    vm.telemarketing_c2 = '';
    vm.polizas = 0;
    vm.polizas_p = 0;
    vm.polizas_c1 = '';
    vm.polizas_c2 = '';
    vm.vta_nueva = 0;
    vm.vta_nueva_p = 0;
    vm.vta_nueva_c1 = '';
    vm.vta_nueva_c2 = '';
    
	$http({
		method: 'GET',
		url: '/onlinedc/json/data/admin/avanceventa',
	}).then(function successCallback(response){
		;
		var l = response.data.length;
	    var data1 = [];
	    var data2 = [];
	    
	    for (var i = 0; i < l; i++) { 
	    	data1.push([gd(response.data[i].year, response.data[i].month, response.data[i].day), response.data[i].production]);
	    	data2.push([gd(response.data[i].year, response.data[i].month, response.data[i].day), response.data[i].prima_issued]);
	    	vm.polizas = vm.polizas + response.data[i].production;
	    	vm.polizas_p = vm.polizas_p + 100;
	    	vm.vta_nueva = vm.vta_nueva + response.data[i].prima_issued;
	    	vm.vta_nueva_p = vm.vta_nueva_p + 100;

	    	switch(response.data[i].channel) {
		        case "Worksite":
		        	vm.worksite = vm.worksite + response.data[i].prima_issued;
		        	vm.worksite_p = vm.worksite_p + 100;
		            break;
		        case "Vida":
		        	vm.vida = vm.vida + response.data[i].prima_issued;
		        	vm.vida_p = vm.vida_p + 100;
		            break;
		        case "Telemarketing":
		        	vm.telemarketing = vm.telemarketing + response.data[i].prima_issued;
		        	vm.telemarketing_p = vm.telemarketing_p + 100;
		            break;
		        default:
		            ""
	    	}
			if (vm.worksite_p > 100){
				vm.worksite_c1="text-success";
				vm.worksite_c2="fa fa-bolt";
			}
			else{
				vm.worksite_c1="text-danger";
				vm.worksite_c2="fa fa-level-down";
			}
			if (vm.vida_p > 100){
				vm.vida_c1="text-success";
				vm.vida_c2="fa fa-bolt";
			}
			else{
				vm.vida_c1="text-danger";
				vm.vida_c2="fa fa-level-down";
			}
			if (vm.telemarketing_p > 100){
				vm.telemarketing_c1="text-success";
				vm.telemarketing_c2="fa fa-bolt";
			}
			else{
				vm.telemarketing_c1="text-danger";
				vm.telemarketing_c2="fa fa-level-down";
			}
			if (vm.polizas_p > 100){
				vm.polizas_c1="text-success";
				vm.polizas_c2="fa fa-level-up";
			}
			else{
				vm.polizas_c1="text-danger";
				vm.polizas_c2="fa fa-level-down";
			}
			if (vm.vta_nueva_p > 100){
				vm.vta_nueva_c1="text-success";
				vm.vta_nueva_c2="fa fa-level-up";
			}
			else{
				vm.vta_nueva_c1="text-danger";
				vm.vta_nueva_c2="fa fa-level-down";
			}
	    }
	    var dataset = [
	        {
	            label: "Primas",
	            grow:{stepMode:"linear"},
	            data: data2,
	            color: "#1ab394",
	            bars: {
	                show: true,
	                align: "center",
	                barWidth: 24 * 60 * 60 * 600,
	                lineWidth: 0
	            }

	        },
	        {
	            label: "Pólizas",
	            grow:{stepMode:"linear"},
	            data: data1,
	            yaxis: 2,
	            color: "#1C84C6",
	            lines: {
	                lineWidth: 1,
	                show: true,
	                fill: true,
	                fillColor: {
	                    colors: [
	                        {
	                            opacity: 0.2
	                        },
	                        {
	                            opacity: 0.2
	                        }
	                    ]
	                }
	            }
	        }
	    ];


	    var options = {
	        grid: {
	            hoverable: true,
	            clickable: true,
	            tickColor: "#d5d5d5",
	            borderWidth: 0,
	            color: '#d5d5d5'
	        },
	        colors: ["#1ab394", "#464f88"],
	        tooltip: true,
	        xaxis: {
	            mode: "time",
	            tickSize: [3, "day"],
	            tickLength: 0,
	            axisLabel: "Date",
	            axisLabelUseCanvas: true,
	            axisLabelFontSizePixels: 12,
	            axisLabelFontFamily: 'Arial',
	            axisLabelPadding: 10,
	            color: "#d5d5d5"
	        },
	        yaxes: [
	            {
	                position: "left",
	                max: 1070,
	                color: "#d5d5d5",
	                axisLabelUseCanvas: true,
	                axisLabelFontSizePixels: 12,
	                axisLabelFontFamily: 'Arial',
	                axisLabelPadding: 3
	            },
	            {
	                position: "right",
	                color: "#d5d5d5",
	                axisLabelUseCanvas: true,
	                axisLabelFontSizePixels: 12,
	                axisLabelFontFamily: ' Arial',
	                axisLabelPadding: 67
	            }
	        ],
	        legend: {
	            noColumns: 1,
	            labelBoxBorderColor: "#d5d5d5",
	            position: "nw"
	        }

	    };

	    function gd(year, month, day) {
	        return new Date(year, month - 1, day).getTime();
	    }

	    /**
	     * Definition of variables
	     * Flot chart
	     */
	    vm.flotData = dataset;
	    vm.flotOptions = options;
	    
	}, function errorCallback(response){
		vm.message = "Error al cargar data"
	});
}


function excelCtrl($http, $scope) {
    var vm = this;
    vm.message = '';
    
    $scope.UploadFile = function(files){
    	$scope.$apply(function(){
   		$scope.SelectedFileForUpload = files[0];
   		})
   	}
    
    //Parse Excel Data
    $scope.ParseExcelDataAndSave = function(){
    	var file = $scope.SelectedFileForUpload;
    	if(file){
    		var reader = new FileReader();
    		reader.onload = function(e){
    			var data = e.target.result;
    			//XLSX de la librería js-xlsx, cuando lo agrego a la vista
    			var workbook = XLSX.read(data,{type: 'binary'});
    			var sheetName = workbook.SheetNames[0];
    			var excelData =XLSX.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
    			if (excelData.length > 0){
    				//Salvar data
    				$scope.SaveData(excelData);
    			}
    			else{
    				vm.message = "No data found";
    			}
    		}
    		reader.onerror  = function(ex){
    			console.log(ex);
    		}
    		reader.readAsBinaryString(file);
    	}
    }
    //Salvar la data excel en nuestra base de datos
    $scope.SaveData = function(excelData){
    	$http({
    		method: 'POST',
    		url: '/onlinedc/json/data/admin/savedata',
    		data: JSON.stringify(excelData),
    		headers:{
    			'Content-Type':'application/json'
    		}
    	}).then(function successCallback(data){
    		if (data.status){
   			vm.message = excelData.length + "filas insertadas";
    		}
    		else{
    			vm.message = "Failed";
    		}
    	}, function errorCallback(error){
    		vm.message = "Error al cargar hoja de Excel";
    	})
    }
}

angular
    .module('ngadmin')
    .controller('adminCtrl', adminCtrl)
    .controller('datatablesCtrl', datatablesCtrl)
    .controller('dashboardVentas',dashboardVentas)
    .controller('excelCtrl',excelCtrl)
    