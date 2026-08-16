//SwaggerConfig .java(Configuration class  Contains API Information)
package com.eshwar.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SwaggerConfig 
{

	 //This method returns OpenAPI Object and SpringDoc reads this object while starting your application.It uses this information to generate Swagger UI
	 @Bean
     OpenAPI customOpenAPI()
     {
    	 log.debug("SwaggerConfig Class customOpenAPI() method is executed...");
    	 
    	 log.info("SwaggerConfig Class Of Inventory Service customOpenAPI() method is OpenAPI Class Object");
    	 return new OpenAPI()//This creates an OpenAPI object. Think of it as a API Documentation Object
    			   .info(new Info()//creates the Info Class Object which contains API information like title,version,description,contact and etc
    					    .title("Inventory Service API")//This sets the title of the API Documentation which is appears  on the Swagger UI Page.   
    					        .version("1.0")//This sets the version of the API Documentation which is appears  on the Swagger UI Page.
    					          .description("Rest APIs For Inventory Service")//This sets the description of the API Documentation ,Which is useful for explaining what this service does.
    					             .contact(new Contact()//Creates the Contact Object which contains the contact information of the developer or the team responsible for the API
    					            	.name("Eshwar Reddy")//sets the name of the developer that will appear on the Swagger UI
    					            	   .email("eshwart438@gmail.com")//sets the email of the developer that will appear on the Swagger UI
    					            		 
    					            		 )
    					   
    					   );
    					   
     }
}
