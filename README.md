#LegalAidCamp

## Get Started:
- Get Maven at www.maven.org and add it to your path
- Make sure `GOOGLE_APPLICATION_CREDENTIALS` env variable is set to your GCP service account json file to run locally (Not applicable for GAE)
- Create a Cloud SQL instance for your GCP project and configure application.properties
    - `spring.cloud.gcp.sql.database-name={YOUR-DATABASE-NAME}`
    - `spring.cloud.gcp.sql.instance-connection-name={YOUR-INSTANCE-CONNECTION-NAME}`
- Import ./template_lac.sql into your Cloud SQL instance for starter tables. (Languages, Bar Councils, etc.)
- Run `mvn spring-boot:run` to run the project locally 
- Run `mvn appengine:deploy` to deploy to GAE

Swagger docs at http://localhost:8000/swagger-ui.html

### Status:
🥚 - Not Implemented
🐣 - Possibly bugged
🐥 - Working

| Services           	| Status 	|
|--------------------	|--------	|
| Create a user      	| 🐥      	|
| Retrieve form data 	| 🐥      	|
| Basic Auth         	| 🐥      	|
| Create a lawyer    	| 🐥      	|
| Custom auth roles  	| 🥚      	|
| Assign lawyers        | 🐣      	|
| Accept a case      	| 🥚      	|
| Create a case      	| 🐣      	|
| View case details     | 🐥      	|
| Everything else    	| 🥚      	|
