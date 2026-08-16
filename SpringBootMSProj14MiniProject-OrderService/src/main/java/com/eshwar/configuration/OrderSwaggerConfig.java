//OrderSwaggerConfig.java(Configuration Class Contains API Information)
package com.eshwar.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class OrderSwaggerConfig
{

	   @Bean
	   //This method returns OpenAPI Object and SpringDoc reads this object while starting your application.It uses this information to generate Swagger UI
	   OpenAPI cutomeOpenAPI()
	   {
		   log.debug("OrderSwaggerConfig  Class customOpenAPI() method is executed...");
		   
		   log.info("OrderSwaggerConfig  Class customOpenAPI() method is returning OpenAPI Class Object...");
		   return new OpenAPI()//This creates an OpenAPI object. Think of it as a API Documentation Object
				       .info(new Info()//This creates an Info Object which contains the API Information like title,version,description,contact and etc.
				    		 .title("Order Service API") //This sets the title of the API Documentation which is appears  on the Swagger UI Page.
				    		    .version("1.0")//This sets the version of the API Documentation which is appears  on the Swagger UI Page.
				    		       .description("Rest APIs For Order Service")//This sets the description of the API Documentation,Which is useful for explaining what this service does.
				    		          .contact(new Contact()//This creates the contact object which contains the contact information of the developer or the team responsible for the API
				    		        		  .name("Eshwar Reddy")//This displays the name of the developer
				    		        		     .email("eshwart438@gmail.com")//This displays the email of the developer
				    		        		      
				    		        		  )
				    		   );
				    		   
	   }
}
