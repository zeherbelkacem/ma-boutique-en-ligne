package com.fms.maboutiqueenligne.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe Article
 * 
 * @author Stagiaires06P
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Le champ doit contenir au moins 5 caractères")
	@Size(min = 5, max = 50)
	private String brand;

	
	@Size(min = 5, max = 50)
	@NotNull(message = "stringValue has to be present")
	private String description;

	@DecimalMin("50")
	private double price;

	private int quantity = 1;

	@ManyToOne
	private Category category;

	@Override
	public String toString() {
		return "Article [id=" + id + ", brand=" + brand + ", description=" + description + ", price=" + price;
				//+ ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	
	public Article(@Size(min = 5, max = 50) String description, @Size(min = 5, max = 50)
	String brand, @DecimalMin("50") double price, Category category) {
		super();
		this.description = description;
		this.brand=brand;
		this.price = price;
		this.category = category;
	}
	
}
