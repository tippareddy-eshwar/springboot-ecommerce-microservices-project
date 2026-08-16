//IProductService .java
package com.eshwar.service;
import java.util.List;
import com.eshwar.dto.ProductDTO;
public interface IProductService 
{
   public String saveProduct(ProductDTO productDTO);
   public List<ProductDTO> getAllProducts();
   public ProductDTO getProductById(Integer productId);
   public String updateProduct(ProductDTO productDTO);
   public String deleteProduct(Integer productId);
   
} 
	
