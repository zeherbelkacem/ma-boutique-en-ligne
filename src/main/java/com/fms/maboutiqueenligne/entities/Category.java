package com.fms.maboutiqueenligne.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe Category
 * @author Stagiaires06P
 *
 */

@Entity @NoArgsConstructor@AllArgsConstructor @ToString
public class Category implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="category")
	private Collection<Article> articles;
}
