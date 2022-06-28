package com.fms.maboutiqueenligne.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe Category
 * 
 * @author Stagiaires06P
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max = 50)
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
	private Collection<Article> articles;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", articles=" + articles + "]";
	}
	
	
}
