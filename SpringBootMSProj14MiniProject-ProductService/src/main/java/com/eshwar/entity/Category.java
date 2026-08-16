//Category.java(Parent Class)
package com.eshwar.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Data
@Table(name="CATEGORIES")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "products")//while generating toString() method DO NOT include the products field
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
	
	@Column(length=30,nullable=false)
    private String categoryName;
	
	//HAS-A Property
	@JsonManagedReference
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product>products;
}
