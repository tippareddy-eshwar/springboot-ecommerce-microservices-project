//ProductServiceImpl.java(implemented class for IProductService Interface)
package com.eshwar.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eshwar.dto.ProductDTO;
import com.eshwar.entity.Category;
import com.eshwar.entity.Product;
import com.eshwar.exceptionhandling.CategoryNotFoundException;
import com.eshwar.exceptionhandling.ProductNotFoundException;
import com.eshwar.repository.ICategoryRepository;
import com.eshwar.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductServiceImpl implements IProductService
{

    private final IProductRepository repo;
	private final ICategoryRepository categoryRepo;
	
	//Constructor Injection
	public ProductServiceImpl(IProductRepository repo,ICategoryRepository categoryRepo)
	{
		log.debug("ProductServiceImpl Class Parameterized Constructor(---,---) is Executed...");
		this.repo=repo;
		this.categoryRepo =categoryRepo;
	}
	
	@Override
	public String saveProduct(ProductDTO productDTO)
	{
		 log.debug("ProductServiceImpl Class saveProduct(---) method is executed...");
		 // DTO->Entity
		 Product product=new Product();
		 product.setProductName(productDTO.getProductName());
		 product.setProductPrice(productDTO.getProductPrice());
		 product.setProductQuantity(productDTO.getProductQuantity());
		 
		 //Finding the Category using categoryId
		 Category category = categoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("Category is Not Found With The Id :  "+productDTO.getCategoryId()));
		 product.setCategory(category);
		 //calling the save(---) method of CrudRepository Interface(saving the product)
		 Product savedProduct = repo.save(product);
		 log.info("ProductServiceImpl Class saveProduct(---) method is returning Some Message in String Format");
		 return "Product Details Saved Sucessfully With the Product Id : "+savedProduct.getProductId();
		
	}

	@Override
	public List<ProductDTO> getAllProducts() 
	{
		log.debug("ProductServiceImpl Class getAllProducts()  method is executed...");
		//calling the findAll() method of ListCrudRepository Interface
		log.info("ProductServiceImpl Class getAllProducts()  method is returning List Of Products");
		//Entity->DTO
		return repo.findAll().stream().map(product->
		        {
			        ProductDTO productDTO=new ProductDTO();
			        productDTO.setProductId(product.getProductId());
			        productDTO.setProductName(product.getProductName());
			        productDTO.setProductPrice(product.getProductPrice());
			        productDTO.setProductQuantity(product.getProductQuantity());
			        if(product.getCategory()!=null)
			        {
			        	productDTO.setCategoryId(product.getCategory().getCategoryId());
			        }
			        return productDTO;
		        }).toList();
				
	
	}

	@Override
	public ProductDTO getProductById(Integer productId) 
	{
		log.debug("ProductServiceImpl Class getProductById(---) method is executed...");
		
		log.info("ProductServiceImpl Class getProductById(---)  method is returning ProductDTO Object");
	    Product product = repo.findById(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With the Id : "+productId));
	    //Entity -> DTO
	    ProductDTO productDTO=new ProductDTO();
	    productDTO.setProductId(product.getProductId());
	    productDTO.setProductName(product.getProductName());
	    productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductQuantity(product.getProductQuantity());
        if(product.getCategory()!=null)
        {
        	productDTO.setCategoryId(product.getCategory().getCategoryId());
        }
		return productDTO;
	}

	@Override
	public String updateProduct(ProductDTO productDTO) 
	{
		log.debug("ProductServiceImpl Class updateProduct(---) method is executed...");
		
		 Product product = repo.findById(productDTO.getProductId()).orElseThrow(() -> new ProductNotFoundException( "Product Not Found With the Id : "+ productDTO.getProductId()));
		 //DTO->Entity
		 product.setProductName(productDTO.getProductName());
		 product.setProductPrice(productDTO.getProductPrice());
	     product.setProductQuantity(productDTO.getProductQuantity());
	     //Finding the Category using categoryId
		 Category category = categoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("Category is Not Found With The Id :  "+productDTO.getCategoryId()));
		 product.setCategory(category);             
		 repo.save(product);
		
		log.info("ProductServiceImpl Class updateProduct(---) method is returning Some Message in String Format");
		return "Product Updated Sucessfully ";
	}

	@Override
	public String deleteProduct(Integer productId) 
	{
		log.debug("ProductServiceImpl Class deleteProduct(---) method is executed...");
		Product prod=repo.findById(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With the Id : "+productId));
		repo.delete(prod);
		
		log.info("ProductServiceImpl Class deleteProduct(---) method is returning Some Message in String Format");
		return "Product Deleted Sucessfully Whose ProductId is : "+productId;
	}

}
