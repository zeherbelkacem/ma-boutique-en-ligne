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
import lombok.ToString;

/**
 * Classe Article
 * @author Stagiaires06P
 *
 */

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Article implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max=50)
	private String brand;
	
	@NotNull
	@Size(min=5, max=50)
	private String description;
	
	@DecimalMin("50")
	private double price;
	
	private int quantity;
	
	@ManyToOne
	@NotNull
	private Category category;
}
