package com.fms.maboutiqueenligne.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * OrderItem Entity
 * 
 * @author Delmerie JOHN ROSE
 *
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Article article;

	private int quantity;
	private double price;
	
	@ManyToOne
	private Orders orders;

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", article=" + article + ", quantity=" + quantity + ", price=" + price
				+ ", orders=" + orders + "]";
	}
	
	
}
