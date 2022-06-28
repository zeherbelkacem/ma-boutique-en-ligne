package com.fms.springEx1.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Stagiaires11P
 *
 */

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION")
	@NotNull(message = "Can't be null!")
	//@Size(min = 10, max = 50)
	private String description;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "PRICE")
	@DecimalMin("10")
	private Double price;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID") // It will have the same name by default
	private Category category;

//	@Transient
//	@OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "article")
//	private OrderItem orderItem;
	
	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", brand=" + brand + ", price=" + price
				+ ", category=" + category.getName() + "]";
	}



	/**
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



//	public Article(Long id, @NotNull(message = "Can't be null!") String description, String brand,
//			@DecimalMin("10") Double price, int quantity, Category category) {
//		super();
//		this.id = id;
//		this.description = description;
//		this.brand = brand;
//		this.price = price;
//		this.quantity = quantity;
//		this.category = category;
//	}

}