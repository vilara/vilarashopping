package br.com.vilara.vilarashopping.dto;

public class Category {

	/**
	 * Private fields
	 */

	private int id;
	private String name;
	private String description;
	private String umageURL;
	private boolean active = true;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUmageURL() {
		return umageURL;
	}

	public void setUmageURL(String umageURL) {
		this.umageURL = umageURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
