package br.com.vilara.vilarashopping.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	@NotBlank(message = "Please enter the product name!")
	private String name;
	@NotBlank(message = "Please enter the brand name!")
	private String brand;
	@JsonIgnore
	@NotBlank(message = "Please enter the description for product!")
	private String description;
	
	@Column(name = "unit_price")
	@Min(value=1, message="The minimum price don't less than 1")
	private double unitPrice;
	private int quantity;
	
	@Column(name= "is_active")
	private boolean isActive;
	
	@Column(name= "category_id")
	@JsonIgnore
	private int categoryId;
	
	public void setCode(String code) {
		this.code = code;
	}


	@ManyToOne
	@JsonIgnore
	private User_detail supplierId;
	
	private int purchases = 0;
	private int views = 0;
	
	
	@Transient
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}





	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
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
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", isActive=" + isActive
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	

	
	

}
