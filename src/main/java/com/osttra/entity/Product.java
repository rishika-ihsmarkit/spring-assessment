package com.osttra.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	@Id
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Min(value = 10, message = "Minimum price should be 10 Rs")
	private double price;
	
	@NotNull
	@Min(value = 5, message = "Minimum quantity should be 5")
	private int quantity;

}
