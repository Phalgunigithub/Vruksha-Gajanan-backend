package com.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Carts extends BaseEntity{
	
	private CartItem cartitem;
	
	
	

}
