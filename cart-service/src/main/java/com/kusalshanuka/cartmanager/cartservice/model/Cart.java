package com.kusalshanuka.cartmanager.cartservice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@NotNull
	String itemName;
	
	@NotNull
	Double price;
	
	@NotNull
	Double qty;
	
}
