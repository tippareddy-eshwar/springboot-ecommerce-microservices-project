// ICategoryService.java
package com.eshwar.service;
import java.util.List;
import com.eshwar.dto.CategoryDTO;
public interface ICategoryService
{
   public String registerCategory(CategoryDTO categoryDTO);
   public List<CategoryDTO>showAllCategories();
   public CategoryDTO showCategoryById(Integer categoryId);
   public String updateCategory(Integer categoryId,CategoryDTO categoryDTO);
   public String deleteCategory(Integer categoryId);
}
