<div class="container">
	<h2>View1</h2>
	Name:
	<br/>
	<input type="text" data-ng-model="SearchedName"/>
	<br/>
	<ul>
		<li data-ng-repeat="cust in customers | filter: SearchedName | orderBy: 'name'">{{cust.name}}</li>
	</ul>
	
	<br/>
	Customer Name:<br/>
	<input type="text" data-ng-model="newCustomer.name"/>
	<br/>
	Customer City: <br/>
	<input type="text" data-ng-model="newCustomer.city"/>
	<br/>
	<button data-ng-click="addCustomer()">Add Customer</button>
	<br/>
	<a href="#/view2">View 2</a>
	
	<br/>
	Remove name: <br/>
	<input type="text" data-ng-model="deletedName"/>
	<br/>
	<button data-ng-click="deleteFunction()">Delete Customer</button>

</div>