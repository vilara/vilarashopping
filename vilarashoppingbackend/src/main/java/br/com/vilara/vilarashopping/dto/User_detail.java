package br.com.vilara.vilarashopping.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.engine.spi.CascadeStyle;

@Entity
public class User_detail implements Serializable {

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

	@Column(name = "first_name")
	@NotBlank(message="Please enter first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message="Please enter last name")
	private String lastName;
	
	@NotBlank(message="Please enter name")
	@Email(message="Please enter with valid email")
	private String email;
	
	@Column(name = "contact_number")
	@NotBlank(message="Please enter contact number")
	private String contactNumber;

	private String role;
	
	@NotBlank(message="Please enter password")
	private String password;
	
	private boolean enabled = true;
	
	// confirm password transient field
	@Transient
	private String confirmPassword;
	
	

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "User_detail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled=" + enabled + ", cart=" + cart + "]";
	}

}
