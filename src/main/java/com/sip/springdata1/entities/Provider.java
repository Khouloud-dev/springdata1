package com.sip.springdata1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Provider {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
    @NotBlank(message="name is required")
    @Column(name="name")
	private String name;
    
    @NotBlank(message="adress is required")
    @Column(name="adress")
	private String adress;
    
    @NotBlank(message="email is required")
    @Column(name="email")
	private String email;

	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Provider(String name, String adress, String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    
    
}
