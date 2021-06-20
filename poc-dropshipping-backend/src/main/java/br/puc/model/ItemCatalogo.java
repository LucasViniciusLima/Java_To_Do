package br.puc.model;

import javax.persistence.*;

/**
 * Classe representa um produto.
 */
@Entity
public class ItemCatalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double vlrVenda;
	private String category;
	private String about;
	private Integer rating;

	@Lob
	@Column(length = 100000)
	private String image;

	public ItemCatalogo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(Double vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImagePath(String image) {
		this.image = image;
	}

}
