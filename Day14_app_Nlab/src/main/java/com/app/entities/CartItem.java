package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class CartItem extends BaseEntity{
	
	private int quantity;
	
	private double totalPrice;
	
	private Carts cart;

}
