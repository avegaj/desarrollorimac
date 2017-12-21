<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>Avance de Ventas</h2>
		<ol class="breadcrumb">
			<li><a ui-sref="content.welcome">Inicio</a></li>
			<li class="active"><strong>Dashboard</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content" ng-controller="dashboardVentas as chart">
	<div class="row">
		<div class="col-lg-3">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-info pull-right">Bueno</span>
					<h5><a ui-sref="content.welcome">Worksite</a></h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">$ {{chart.worksite}}</h1>
					<div class="stat-percent font-bold {{chart.worksite_c1}}">{{chart.worksite_p}}%<i class="{{chart.worksite_c2}}"></i>
					</div>
					<small>Total primas</small>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-info pull-right">Bueno</span>
					<h5><a ui-sref="content.welcome">Vida</a></h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">$ {{chart.vida}}</h1>
					<div class="stat-percent font-bold {{chart.vida_c1}}">{{chart.vida_p}}%<i class="{{chart.vida_c2}}"></i>
					</div>
					<small>Total primas</small>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-info pull-right">Bueno</span>
					<h5><a ui-sref="content.welcome">Telemarketing</a></h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">$ {{chart.telemarketing}}</h1>
					<div class="stat-percent font-bold {{chart.telemarketing_c1}}">{{chart.telemarketing_p}}%<i class="{{chart.telemarketing_c2}}"></i>
					</div>
					<small>Total primas</small>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<span class="label label-danger pull-right">Bajo</span>
					<h5><a ui-sref="content.welcome">Rentas Vitalicias</a></h5>
				</div>
				<div class="ibox-content">
					<h1 class="no-margins">$ 80,600</h1>
					<div class="stat-percent font-bold text-danger">38%<i class="fa fa-level-down"></i>
					</div>
					<small>Total primas</small>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>Canales</h5>
					<div class="pull-right">
						<div class="btn-group" ng-init="tab = 1">
							<button type="button" class="btn btn-xs btn-white" ng-class="{active:tab===1}" href ng-click="tab = 1">Diario</button>
							<button type="button" class="btn btn-xs btn-white" ng-class="{active:tab===2}" href ng-click="tab = 2">Mensual</button>
						</div>
					</div>
				</div>
				<div class="ibox-content" ng-show="tab === 1">
					<div class="row">
						<div class="col-lg-9">
							<div class="flot-chart">
								<div flot class="flot-chart-content" dataset="chart.flotData"
									options="chart.flotOptions"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<ul class="stat-list">
								<li>
									<h2 class="no-margins"> {{chart.polizas}}</h2>
									<small>Pólizas</small>
									<div class="stat-percent font-bold {{chart.polizas_c1}}">20%<i class="{{chart.polizas_c2}}"></i>
									</div>
									<div class="progress progress-mini">
										<div style="width: 20%;" class="progress-bar"></div>
									</div>
								</li>
								<li>
									<h2 class="no-margins ">$  {{chart.vta_nueva}}</h2>
									<small>Venta nueva</small>
									<div class="stat-percent font-bold {{chart.vta_nueva_c1}}">60%<i class="{{chart.vta_nueva_c2}}"></i>
									</div>
									<div class="progress progress-mini">
										<div style="width: 60%;" class="progress-bar"></div>
									</div>
								</li>
								<li>
									<h2 class="no-margins ">$  1,980</h2>
									<small>Contable</small>
									<div class="stat-percent font-bold text-info">35%<i class="fa fa-level-up"></i>
									</div>
									<div class="progress progress-mini">
										<div style="width: 35%;" class="progress-bar"></div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>