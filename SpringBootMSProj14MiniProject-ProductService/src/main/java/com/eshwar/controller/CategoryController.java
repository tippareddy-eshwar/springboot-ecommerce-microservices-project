//CategoryController .java (Rest Controller Class)
package com.eshwar.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eshwar.dto.CategoryDTO;
import com.eshwar.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/categories")//Global Path (or) Global Request Path
@Tag(name="Category Controller", description = "Rest APIs For Category Service")//This annotation is used to provide our choice name and description that will be reflects on the Swagger UI
public class CategoryController 
{
	
    private final  ICategoryService service;
    
    //Constructor Injection
    public CategoryController(ICategoryService service)
    {
    	log.debug("CategoryController Class Parameterized Constructor is Executed...");
    	this.service=service;
    }
	
	@PostMapping("/save")//Method Path (or) Method Request Path
	@Operation(summary = "Register Category", description = "Creates a new Category and stores it in the database")//It is a Open API(Swagger API) provided annotation which is used to document a REST API endpoint.Without @Operation, Swagger can still detect your API, but it only shows the endpoint URL and HTTP method. With @Operation, you provide meaningful information about what the API does.
	@ApiResponses({
		         @ApiResponse(responseCode="201" ,
		    		          description = "Category Created Successfully"
		    		          ),
		         
		         @ApiResponse(responseCode="400" ,
		                      description = "Validation Failed"
		                     ),
		         @ApiResponse(responseCode="500" ,
		                      description = "Internal Server Error"
		          ),
		         
	    })
	public ResponseEntity<String>saveCategory(@Valid @RequestBody CategoryDTO categoryDTO)
	{
		log.debug("CategoryController Class saveCategory(---) method is Executed...");
		//returning the ResponseEntity Class Object
		log.info("CategoryController Class saveCategory(---) method Returning the ResponseEntity<String> Class Object");
		return new ResponseEntity<String>(service.registerCategory(categoryDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/showAll")//Method Path (or) Method Request Path
	@Operation(summary = "Get All Categories", description = "Returns the list of all available categories")
	@ApiResponses({
	   @ApiResponse(responseCode="200" ,
                    description = "Categories Retrieved Successfully"
                    ),
	   @ApiResponse(responseCode="500" ,
                    description = "Internal Server Error"
                    ),
	   
	})
	
	public ResponseEntity<List<CategoryDTO>>showAllCategories()
	{
		log.debug("CategoryController Class showAllCategories() method is Executed...");
		//returning the ResponseEntity Class Object
		log.info("CategoryController Class showAllCategories() method Returning the ResponseEntity<List<Category>> Class Object");
		return new ResponseEntity<List<CategoryDTO>>(service.showAllCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/showById/{categoryId}")//Method Path (or) Method Request Path
	@Operation(summary = "Get Category By Id", description = "Returns Category details for the specified Category ID")
	@ApiResponses({
		   @ApiResponse(responseCode="200" ,
	                    description = "Category Retrieved Successfully"
	                    ),
		   @ApiResponse(responseCode="404" ,
                        description = "Category Not Found"
                        ),
		   @ApiResponse(responseCode="500" ,
	                    description = "Internal Server Error"
	                    ),
		   
		})
	//@Parameter(---,---) annotation is used to Describes an input parameter (or) document a parameter of an API in Swagger/OpenAPI.
	public ResponseEntity<String>showCategoryById(@Parameter(description = "ID of the Category", example = "1") @PathVariable Integer categoryId)
	{
		log.debug("CategoryController Class showCategoryById(---) method is Executed...");
		//returning the ResponseEntity Class Object
		log.info("CategoryController Class showCategoryById(---) method Returning the ResponseEntity<String> Class Object");
		return new ResponseEntity<String>(service.showCategoryById(categoryId).toString(),HttpStatus.OK);
	}
	
	
	@ApiResponses({
		   @ApiResponse(responseCode="200" ,
	                    description = "Category Updated Successfully"
	                    ),
		   @ApiResponse(responseCode = "400",
                        description = "Validation Failed"
                        ),
		   @ApiResponse(responseCode="404" ,
                     description = "Category Not Found"
                     ),
		   @ApiResponse(responseCode="500" ,
	                    description = "Internal Server Error"
	                    ),
		   
		})
	@PutMapping("/update/{categoryId}")//Method Path (or) Method Request Path
	@Operation(summary = "Updating the Category", description="Updating the Category Details for specified Category ID")
	public ResponseEntity<String>updateCategoryById(@Parameter(description = "ID Of the Category", example = "2") @PathVariable Integer categoryId,@Valid @RequestBody CategoryDTO categoryDTO)
	{
		log.debug("CategoryController Class updateCategoryById(---,---) method is Executed...");
		//returning the ResponseEntity Class Object
		log.info("CategoryController Class updateCategoryById(---,---) method Returning the ResponseEntity<String> Class Object");
		return new ResponseEntity<String>(service.updateCategory(categoryId, categoryDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")//Method Path (or) Method Request Path
	@Operation(summary="Deleting the Category", description = "Deleting the Category Details for the specified Category ID")
	@ApiResponses({
	    @ApiResponse(responseCode = "200",
	                 description = "Category Deleted Successfully"
	    ),
	    @ApiResponse(responseCode = "404",
	                 description = "Category Not Found"
	    ),
	    @ApiResponse(responseCode = "500",
	                description = "Internal Server Error"
	    )
	})
	public ResponseEntity<String>deleteCategoryById(@Parameter(description = "ID Of the Category", example = "3") @PathVariable Integer categoryId)
	{
		log.debug("CategoryController Class deleteCategoryById(---,---) method is Executed...");
		//returning the ResponseEntity Class Object
		log.info("CategoryController Class deleteCategoryById(---) method Returning the ResponseEntity<String> Class Object");
		return new ResponseEntity<String>(service.deleteCategory(categoryId),HttpStatus.OK);
	}
}
