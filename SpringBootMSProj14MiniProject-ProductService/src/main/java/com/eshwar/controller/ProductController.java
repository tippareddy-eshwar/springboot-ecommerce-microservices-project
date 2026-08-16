//ProductController .java(Rest Controller Class)
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
import com.eshwar.dto.ProductDTO;
import com.eshwar.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/products-api")//Global Path (or) Global Request Path
@Tag(name="Product Controller", description = "Rest APIs For  Product Service")//This annotation is used to provide our choice name and description that will be reflects on the Swagger UI
public class ProductController 
{
	
	private final IProductService service;
	
	//Constructor Injection
	public ProductController(IProductService service)
	{
		log.debug("ProductController Class Parameterized Constructor is Executed...");
		this.service=service;
	}
	
	
	@PostMapping("/add")//Method Path (or) Method Request Path
	@Operation(summary = "Register Product", description ="Creates a new product in the database")//TIt is a Open API(Swagger API) provided annotation which is used to document a REST API endpoint.Without @Operation, Swagger can still detect your API, but it only shows the endpoint URL and HTTP method. With @Operation, you provide meaningful information about what the API does.
	@ApiResponses({//@ApiResponses groups multiple possible API responses for Swagger/OpenAPI documentation."
		//@ApiResponse describes one possible response from an API.
		  @ApiResponse(responseCode="201",
				         description = "Product Created Sucessfully"
				  ),
		  @ApiResponse(responseCode="400",
		                 description = "Validation Failed"
				  ),
		  @ApiResponse(responseCode = "404",
		              description = "Category Not Found"
				  ),
		  @ApiResponse(responseCode = "500",
		             description = "Internal Server Error"
				  )
		  })
    public ResponseEntity<String>addProduct(@Valid @RequestBody ProductDTO productDTO)
    {
		log.debug("ProductController Class addProduct(---) method is executed...");
    	//returning ResponseEntity Class Object
		log.info("ProductController Class addProduct(---) method Returning the ResponseEntity<String> Class Object");
    	return new ResponseEntity<String>(service.saveProduct(productDTO),HttpStatus.CREATED);
    	
    }
	
	@GetMapping("/all")//Method Path (or) Method Request Path
	@Operation(summary = "Get All Products", description = "Returns the list of all available products")
	@ApiResponses({
	    @ApiResponse(responseCode = "200",
	                 description = "Products Retrieved Successfully"
	    ),
	    @ApiResponse(responseCode = "500",
	                description = "Internal Server Error"
	    )
	})
    public ResponseEntity<List<ProductDTO>>getAllProducts()
	{
		log.debug("ProductController Class getAllProducts() method is executed...");
    	//returning ResponseEntity Class Object
		log.info("ProductController Class getAllProducts() method Returning the ResponseEntity<List<Product>> Class Object");
    	return new ResponseEntity<List<ProductDTO>>(service.getAllProducts(),HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{productId}")//Method Path (or) Method Request Path
	@Operation(summary = "Get Product By Id", description = "Returns product details for the specified Product ID")
	@ApiResponses({
		        @ApiResponse(responseCode = "200",
		        		      description = "Product Retrieved Successfully"
		        		),
		        @ApiResponse(responseCode = "404",
	        		         description = "Product Not Found"
		        		),
		        
		        @ApiResponse(responseCode = "500",
                description = "Internal Server Error"
                             )
		        })
	public ResponseEntity<ProductDTO>getProductById(@Parameter(description = "ID Of the Product", example = "1") @PathVariable Integer productId)
	{
		log.debug("ProductController Class getProductById(---) method is executed...");
    	//returning ResponseEntity Class Object
		log.info("ProductController Class getProductById(---) method Returning the ResponseEntity<Product> Class Object");
		return new ResponseEntity<ProductDTO>(service.getProductById(productId),HttpStatus.OK);
	}
	
	
	@PutMapping("/updateProd")//Method Path (or) Method Request Path
	@Operation(summary = "Updating the Product", description = "Updating the Product Details for specified Product ID")
	@ApiResponses({
	    @ApiResponse(responseCode = "200",
	                 description = "Product Updated Successfully"
	    ),
	    @ApiResponse(responseCode = "400",
	                 description = "Validation Failed"
	    ),
	    @ApiResponse(responseCode = "404",
	                 description = "Product or Category Not Found"
	    ),
	    @ApiResponse(responseCode = "500",
	                 description = "Internal Server Error"
	    )
	})
	public ResponseEntity<String>updateProduct(@Valid @RequestBody ProductDTO productDTO)
	{
		log.debug("ProductController Class updateProduct(---) method is executed...");
    	//returning ResponseEntity Class Object
		log.info("ProductController Class updateProduct(---) method Returning the ResponseEntity<String> Class Object");
		return new ResponseEntity<String>(service.updateProduct(productDTO),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{productId}")//Method Path (or) Method Request Path
	@Operation(summary = "Deleting the Product", description = "Deleting the Product Details for specified Product ID")
	@ApiResponses({
	    @ApiResponse(responseCode = "200",
	                 description = "Product Deleted Successfully"
	    ),
	    @ApiResponse(responseCode = "404",
	                 description = "Product Not Found"
	    ),
	    @ApiResponse(responseCode = "500",
	                description = "Internal Server Error"
	    )
	})
	public ResponseEntity<String>deleteProduct(@Parameter(description = "ID Of the Product",example = "2") @PathVariable Integer productId)
	{
		log.debug("ProductController Class deleteProduct(---) method is executed...");
    	//returning ResponseEntity Class Object
		log.info("ProductController Class deleteProduct(---) method Returning the ResponseEntity<String> Class Object");	
		return new ResponseEntity<String>(service.deleteProduct(productId),HttpStatus.OK);
	}
}
