package com.fms.springEx1.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Stagiaires11P
 *
 */

@Entity
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * Category name using String
	 */
//	@Column(name = "NAME")
//	private String name;
	
	/*
	 * Category name using Enum
	 */
	@Column(name = "CAT_NAME")
//	@Enumerated(EnumType.STRING)
//	private CategoryEnum name;
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Collection<Article> articles;

	/**
	 * 
	 */
	public Category() {
	}
	
	/**
	 * 
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}	
	

}
