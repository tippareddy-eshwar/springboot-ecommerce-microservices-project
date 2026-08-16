//CategoryServiceImpl.java(Implemented Class for ICategoryService Interface)
package com.eshwar.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eshwar.dto.CategoryDTO;
import com.eshwar.entity.Category;
import com.eshwar.exceptionhandling.CategoryNotFoundException;
import com.eshwar.repository.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService
{
	
  
	private final ICategoryRepository repo;
	
	//constructor Injection
	public CategoryServiceImpl(ICategoryRepository repo)
	{
		log.debug("CategoryServiceImpl Class Parameterized Constructor is Executed...");
		this.repo=repo;
	}
    
	@Override
	public String registerCategory(CategoryDTO categoryDTO)
	{
		 log.debug("CategoryServiceImpl Class registerCategory(---) method is Executed...");
		 //DTO -> Entity
		 Category category=new Category();
		 category.setCategoryName(categoryDTO.getCategoryName());
		 
		 //calling the save(---) method of CrudRepository Interface (saving the entity)
		 Category savedCategory = repo.save(category);
		 Integer categoryId = savedCategory.getCategoryId();
		 log.info("CategoryServiceImpl Class registerCategory(---) method is returning Some Message in String Format");
		 return "Category Details Are Saved Sucessfully With The Category Id is :  "+categoryId;
		
	}

	@Override
	public List<CategoryDTO> showAllCategories() 
	{
		log.debug("CategoryServiceImpl Class showAllCategories()  method is Executed...");
		//calling the findAll() method ListCrudRepository Interface
		log.info("CategoryServiceImpl Class showAllCategories()  method is returning List Of Categories");
		
		//Entity->DTO
		return repo.findAll().stream().map(category-> 
		      {
		    	  CategoryDTO categoryDTO=new CategoryDTO();
		    	  categoryDTO.setCategoryId(category.getCategoryId());
		    	  categoryDTO.setCategoryName(category.getCategoryName());
		    	  return categoryDTO;
		      }).toList();
		   
	
	}

	@Override
	public CategoryDTO showCategoryById(Integer categoryId)
	{
		log.debug("CategoryServiceImpl Class showCategoryById(---)  method is Executed...");
		
		
	    Category category = repo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Invalid Category Id"));
	    
	    //Entity->DTO
	    CategoryDTO categoryDTO=new CategoryDTO();
	    categoryDTO.setCategoryId(category.getCategoryId());
	    categoryDTO.setCategoryName(category.getCategoryName());
		
	    log.info("CategoryServiceImpl Class  showCategoryById(---)  method is returning CategoyDTO Object");
	    return categoryDTO;
		
	}

	@Override
	public String updateCategory(Integer categoryId, CategoryDTO categoryDTO) 
	{
		log.debug("CategoryServiceImpl Class updateCategory(---)  method is Executed...");
		 Category category=repo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Invalid Category Id"));
	    //DTO->Entity
	    Category updateCategory = repo.save(category);
	    
	    log.info("CategoryServiceImpl Class  updateCategory(---,---)  method is returning  Some Message in String Format");
		return "Category Updated Sucessfully Whose Category Id is : "+updateCategory.getCategoryId();
	}

	@Override
	public String deleteCategory(Integer categoryId)
	{
		log.debug("CategoryServiceImpl Class deleteCategory(---)  method is Executed...");
		Category category = repo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Invalid Category Id,So Nothing To Delete"));
		repo.delete(category);
		
		log.info("CategoryServiceImpl Class  deleteCategory(---)  method is returning  Some Message in String Format");
		return "Category Deleted Sucessfully Whose Category Id is : "+categoryId;
	}
    
}
