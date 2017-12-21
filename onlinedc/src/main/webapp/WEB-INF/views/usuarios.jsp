<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>Usuarios</h2>
		<ol class="breadcrumb">
			<li><a ui-sref="content.Welcome">Inicio</a></li>
			<li class="active"><strong>Lista</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>

<!--

<div class="fileinput fileinput-new input-group" 
	data-provides="fileinput" >
	<div class="form-control" data-trigger="fileinput">
		<i class="glyphicon glyphicon-file fileinput-exists"></i> <span
			class="fileinput-filename"></span>
	</div>
	<span class="input-group-addon btn btn-default btn-file"> <span
		class="fileinput-new">Seleccione archivo</span> <span
		class="fileinput-exists">Cambiar</span> <input type="file" name="file"
		onchange='angular.element(this).scope().UploadFile(this.files);$("#upload-file-info").html($(this).val())'></span>
	<a class="input-group-addon btn btn-success fileinput-exists"
		ng-disabled="!SelectedFileForUpload"
		ng-click="ParseExcelDataAndSave()">Importar</a> <a href="#"
		class="input-group-addon btn btn-default fileinput-exists"
		data-dismiss="fileinput">Retirar</a>
</div>

-->

<div class="wrapper wrapper-content animated fadeInRight"
	ng-controller="datatablesCtrl as showCase">
	<div class="row">
		<div class="col-sm-8">
			<div class="ibox float-e-margins">
				<!--<div class="ibox-title">
					<h5>Título</h5>
					 Configuración de ayuda <div ibox-tools></div> 
				</div>-->

				<div class="ibox-content">

					<table datatable="" dt-options="showCase.dtOptions"
						dt-columns="showCase.dtColumns" dt-instance="showCase.dtInstance"
						class="table table-hover">
					</table>

				</div>
				<p class="text-danger">
					<strong>{{ showCase.message }}</strong>
				</p>
			</div>
		</div>
		<div class="col-sm-4">
            <div class="ibox ">
                <div class="ibox-content">
                        <div>
                            <div class="row m-b-lg">
                                <div class="col-lg-4 text-center">
                                    <h2>{{showCase.nameuser}}</h2>

                                    <div class="m-b-sm">
                                        <img alt="image" class="img-circle" src=""
                                             style="width: 62px">
                                    </div>
                                </div>
                                <div class="col-lg-8">
                                    <strong>
                                        About me
                                    </strong>

                                    <p>
                                        {{showCase.descriptionuser}}.
                                    </p>
                                    <button type="button" class="btn btn-primary btn-sm btn-block"><i
                                            class="fa fa-envelope"></i> Send Message
                                    </button>
                                </div>
                            </div>
                            <div class="client-detail">
                                <div class="full-height-scroll" full-scroll>

                                    <strong>Last activity</strong>

                                    <ul class="list-group clear-list">
                                        <li class="list-group-item fist-item">
                                            <span class="pull-right"> 09:00 pm </span>
                                            Please contact me
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> 10:16 am </span>
                                            Sign a contract
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> 08:22 pm </span>
                                            Open new shop
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> 11:06 pm </span>
                                            Call back to Sylvia
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> 12:00 am </span>
                                            Write a letter to Sandra
                                        </li>
                                    </ul>
                                    <strong>Notes</strong>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua.
                                    </p>
                                    <hr/>
                                    <strong>Timeline activity</strong>
                                    <div id="vertical-timeline" class="vertical-container dark-timeline">
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon gray-bg">
                                                <i class="fa fa-coffee"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>Conference on the sales results for the previous year.
                                                </p>
                                                <span class="vertical-date small text-muted"> 2:10 pm - 12.06.2014 </span>
                                            </div>
                                        </div>
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon gray-bg">
                                                <i class="fa fa-briefcase"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>Many desktop publishing packages and web page editors now use Lorem.
                                                </p>
                                                <span class="vertical-date small text-muted"> 4:20 pm - 10.05.2014 </span>
                                            </div>
                                        </div>
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon gray-bg">
                                                <i class="fa fa-bolt"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>There are many variations of passages of Lorem Ipsum available.
                                                </p>
                                                <span class="vertical-date small text-muted"> 06:10 pm - 11.03.2014 </span>
                                            </div>
                                        </div>
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon navy-bg">
                                                <i class="fa fa-warning"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>The generated Lorem Ipsum is therefore.
                                                </p>
                                                <span class="vertical-date small text-muted"> 02:50 pm - 03.10.2014 </span>
                                            </div>
                                        </div>
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon gray-bg">
                                                <i class="fa fa-coffee"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>Conference on the sales results for the previous year.
                                                </p>
                                                <span class="vertical-date small text-muted"> 2:10 pm - 12.06.2014 </span>
                                            </div>
                                        </div>
                                        <div class="vertical-timeline-block">
                                            <div class="vertical-timeline-icon gray-bg">
                                                <i class="fa fa-briefcase"></i>
                                            </div>
                                            <div class="vertical-timeline-content">
                                                <p>Many desktop publishing packages and web page editors now use Lorem.
                                                </p>
                                                <span class="vertical-date small text-muted"> 4:20 pm - 10.05.2014 </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </div>
	</div>
</div>

