<div>
	<h1> Hi  from {{controllerName}}</h1>
		<input data-ng-model="inputData">{{inputData}}
	<br/>
	
	<table>
		<tr>
			<th><a href="" ng-click="sortedField='name'; reverse=!reverse">Name</a></th><th><a href="" ng-click="sortedField='address';reverse=!reverse">Address</a></th>
		</tr>
		<tr data-ng-repeat="person in data | filter: inputData | orderBy: sortedField:reverse ">
			<td><a href="#/{{person.name | encodeFilter}}">{{person.name}}</a></td>
			<td>{{person.address}}</td>
		</tr> 
	</table>
	<!-- Angular forms -->
	<form data-ng-submit="addPerson()">
		Enter Name:<br/>
		<input type="text" ng-model="name"><br/>
		Enter Address:<br/>
		<input type="text" ng-model="address"><br/>
		<input type="submit"> 
	</form>
	<h2>Delete</h2>
	<form data-ng-submit="delPerson()">
		Enter Name:<br/>
		<input type="text" ng-model="delName">
		<input type="submit">
	</form>
	<a href="#alex">Go to PathParam View</a>
</div>