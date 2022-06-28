package com.fms.maboutiqueenligne.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@Email(regexp = ".+[@].+[\\.].+", message = "Please enter à valid mail")
	private String email;
	
	@Column
	private String phone;
	
	@Column
	private String address;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<>();

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", user=" + user + ", orders=" + orders + "]";
	};
	
	
}
