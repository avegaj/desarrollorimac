<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>Import</h2>
		<ol class="breadcrumb">
			<li><a href="index.html">Inicio</a></li>
			<li class="active"><strong>Lista</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"
	ng-controller="excelCtrl as showCase">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">

				<div class="ibox-content">
			
					<div class="fileinput fileinput-new input-group" data-provides="fileinput">
  						<div class="form-control" data-trigger="fileinput"><i class="glyphicon glyphicon-file fileinput-exists"></i> <span class="fileinput-filename"></span></div>
  						<span class="input-group-addon btn btn-default btn-file"><span class="fileinput-new">Seleccione archivo</span><span class="fileinput-exists">Cambiar</span><input type="file" name="file" onchange='angular.element(this).scope().UploadFile(this.files);$("#upload-file-info").html($(this).val())'></span>
  						<a class="input-group-addon btn btn-success fileinput-exists" ng-disabled="!SelectedFileForUpload" ng-click="ParseExcelDataAndSave()">Importar</a>
  						<a href="#" class="input-group-addon btn btn-default fileinput-exists" data-dismiss="fileinput">Retirar</a>
					</div>
				</div>
				<p class="text-danger">
					<strong>{{ showCase.message }}</strong>
				</p>
			</div>
		</div>
	</div>
</div>