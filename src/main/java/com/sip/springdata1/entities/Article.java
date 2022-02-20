package com.sip.springdata1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Article {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
    @NotBlank(message="label is required")
    @Column(name="label")
	private String label;
    
    @NotBlank(message="price is required")
    @Column(name="price")
	private float price;


	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Article(@NotBlank(message = "label is required") String label,
			@NotBlank(message = "price is required") float price) {
		super();
		this.label = label;
		this.price = price;
	}

	public Article(long id, @NotBlank(message = "label is required") String label,
			@NotBlank(message = "price is required") float price) {
		super();
		this.id = id;
		this.label = label;
		this.price = price;
	}
	
	
    
}
