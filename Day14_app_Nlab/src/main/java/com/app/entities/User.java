package com.app.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@FieldNameConstants
public class User extends BaseEntity implements UserDetails{
	
	@Column(length = 30,nullable=false)
	private String name;
	
	@Column(length = 30, unique = true) 
	private String email;
	
	@Column(nullable = false) // =>NOT NULL
	private String password;
	
	private String address;
	
	@Column(length = 10)
	private String phone;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL )
	Set<Roles> role=new HashSet<>();

	@OneToOne(mappedBy ="user")
	private Carts cart;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role.stream().map(e->new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
