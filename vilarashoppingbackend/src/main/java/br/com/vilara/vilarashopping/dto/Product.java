package br.com.vilara.vilarashopping.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	/**
	 * Private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	
	@Column(name = "unit_price")
	private double unitPrice;
	private int quatity;
	
	@Column(name= "is_active")
	@JsonIgnore
	private boolean isActive;
	
	@ManyToOne
	@JsonIgnore
	private Category categoryId;
	
	@ManyToOne
	@JsonIgnore
	private User_detail supplierId;
	
	private int purchases;
	private int views;
	
	
	public Product() {
		
		this.code = "PROD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuatity() {
		return quatity;
	}


	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Category getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}


	public User_detail getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(User_detail supplierId) {
		this.supplierId = supplierId;
	}


	public int getPurchases() {
		return purchases;
	}


	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public String getCode() {
		return code;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quatity=" + quatity + ", isActive=" + isActive
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	
	
	

}
