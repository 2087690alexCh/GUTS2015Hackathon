<div class="container">
	<h2>View 2</h2>
	City:
	<br/>
	<input type="text" data-ng-model="city"/>
	<br/>
	<ul>
		<li data-ng-repeat="cust in customers | filter: city | orderBy: 'name'">{{cust.name}}</li>
	</ul>
	
</div>