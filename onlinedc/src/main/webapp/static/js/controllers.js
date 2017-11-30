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
    vm.dtInstance = {};
    vm.persons = {};
    vm.activate = '';
       
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
        DTColumnBuilder.newColumn('name')
        	.withTitle('Nombre')
        	.withOption("width","30%"),
        DTColumnBuilder.newColumn('description')
        	.withTitle('Descripción')
        	.withOption("width","30%"),
        DTColumnBuilder.newColumn(null)
        	.withTitle('Acciones')
        	.withOption("width","15%")
        	.withClass('column_text_center')
        	.notSortable()
            .renderWith(actionsHtml),
        DTColumnBuilder.newColumn(null)
        	.withTitle('Estado')
        	.withOption("width","15%")
        	.withClass('column_text_center')
        	.notSortable()
        	.renderWith(switchHtml)
    ];

    function editUser(person) {
        vm.message = 'You are trying to edit the row: ' + JSON.stringify(person.name);
        // Edit some data and call server to make changes...
        // Then reload the data so that DT is refreshed
        // vm.dtInstance.reloadData();
    }
    function activateUser(person) {
    	vm.message = 'You are activate row: ' + JSON.stringify(person.activate);
    	$http({
    		method: 'PUT',
    		url: '/onlinedc/json/data/admin/activate/'+person.id,
    		data: JSON.stringify(person),
    		headers:{
    			'Content-Type':'application/json'
    		}
    	})
    }
    function createdRow(row, data, dataIndex) {
        // Recompiling so we can bind Angular directive to the DT
        $compile(angular.element(row).contents())($scope);
    }
    
    function actionsHtml(data, type, full, meta) {
        vm.persons[data.id] = data;
        return '<button type="button" class="btn btn-warning btn-circle" ng-click="showCase.editUser(showCase.persons[' + data.id + '])">' +
        '   <i class="fa fa-edit"></i>' +
        '</button>'
    }
    
    function switchHtml(data, type, full, meta) {
        vm.persons[data.id] = data;
        return '<input type="checkbox" class="js-switch" ' +
        'ui-switch="{size:' + "'small'" + ', color:' + "'#1AB394'" + '}" ' +
        'checked '+
        'ng-model="showCase.persons[' + data.id + '].activate"' +
        'ng-change="showCase.activateUser(showCase.persons[' + data.id + '])">' +
        /*'ng-true-value=1 ng-false-value=0 >' +*/
        '</input>'
        vm.dtInstance.reloadData();
    }
}

function dashboardVentas() {

    var data1 = [
        [gd(2012, 1, 1), 7],
        [gd(2012, 1, 2), 6],
        [gd(2012, 1, 3), 4],
        [gd(2012, 1, 4), 8],
        [gd(2012, 1, 5), 9],
        [gd(2012, 1, 6), 7],
        [gd(2012, 1, 7), 5],
        [gd(2012, 1, 8), 4],
        [gd(2012, 1, 9), 7],
        [gd(2012, 1, 10), 8],
        [gd(2012, 1, 11), 9],
        [gd(2012, 1, 12), 6],
        [gd(2012, 1, 13), 4],
        [gd(2012, 1, 14), 5],
        [gd(2012, 1, 15), 11],
        [gd(2012, 1, 16), 8],
        [gd(2012, 1, 17), 8],
        [gd(2012, 1, 18), 11],
        [gd(2012, 1, 19), 11],
        [gd(2012, 1, 20), 6],
        [gd(2012, 1, 21), 6],
        [gd(2012, 1, 22), 8],
        [gd(2012, 1, 23), 11],
        [gd(2012, 1, 24), 13],
        [gd(2012, 1, 25), 7],
        [gd(2012, 1, 26), 9],
        [gd(2012, 1, 27), 9],
        [gd(2012, 1, 28), 8],
        [gd(2012, 1, 29), 5],
        [gd(2012, 1, 30), 8],
        [gd(2012, 1, 31), 25]
    ];

    var data2 = [
        [gd(2012, 1, 1), 800],
        [gd(2012, 1, 2), 500],
        [gd(2012, 1, 3), 600],
        [gd(2012, 1, 4), 700],
        [gd(2012, 1, 5), 500],
        [gd(2012, 1, 6), 456],
        [gd(2012, 1, 7), 800],
        [gd(2012, 1, 8), 589],
        [gd(2012, 1, 9), 467],
        [gd(2012, 1, 10), 876],
        [gd(2012, 1, 11), 689],
        [gd(2012, 1, 12), 700],
        [gd(2012, 1, 13), 500],
        [gd(2012, 1, 14), 600],
        [gd(2012, 1, 15), 700],
        [gd(2012, 1, 16), 786],
        [gd(2012, 1, 17), 345],
        [gd(2012, 1, 18), 888],
        [gd(2012, 1, 19), 888],
        [gd(2012, 1, 20), 888],
        [gd(2012, 1, 21), 987],
        [gd(2012, 1, 22), 444],
        [gd(2012, 1, 23), 999],
        [gd(2012, 1, 24), 567],
        [gd(2012, 1, 25), 786],
        [gd(2012, 1, 26), 666],
        [gd(2012, 1, 27), 888],
        [gd(2012, 1, 28), 900],
        [gd(2012, 1, 29), 178],
        [gd(2012, 1, 30), 555],
        [gd(2012, 1, 31), 993]
    ];


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
    this.flotData = dataset;
    this.flotOptions = options;
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
    		url: '/onlinedc/json/data/admin/SaveData',
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
    		vm.message = JSON.stringify(excelData);
    	})
    }
}

angular
    .module('ngadmin')
    .controller('adminCtrl', adminCtrl)
    .controller('datatablesCtrl', datatablesCtrl)
    .controller('dashboardVentas',dashboardVentas)
    .controller('excelCtrl',excelCtrl)
    