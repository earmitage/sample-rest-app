# Sample project for Rest services

To generate the REST docs first run

	mvn clean install

Run the app using

	mvn spring-boot:run

For the swagger-docs go to

	http://localhost:8080/swagger-ui.html   
	
For the REST Docs go to 

	http://localhost:8080/docs/documentation.html
	
The 'functional' services are protected. So to get a token you can call

	curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"password": "vettel", "username": "sebastian" }' 'http://localhost:8080/api/auth'

This will give back something like 	

		{"token":"eyJhbGciOiJIUzUxMi...."}
	
So subsequent calls can now be made using the token as --header 'Authorization: e' ...

		curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'Authorization: eyJhbGciOiJIUzUxMi....' 'http://localhost:8080/api/drivers'
	


