<div>
	Welcome to {{controllerName}}<br/>
	<ul>
		<li data-ng-repeat="person in data | filter: inputData | orderBy: 'name' ">{{person.name}}
			<a href="" ng-click="remove(person.name)">remove</a>
		</li> 
	</ul>
	{{deleted}}
</div>