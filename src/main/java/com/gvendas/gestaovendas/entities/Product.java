package com.gvendas.gestaovendas.entities;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;
	
	@Column(name = "descricao")
	private String drescription;
	
	@Column(name = "quantidade")
	private Integer quantity;
	
	@Column(name = "preco_curto")
	private BigDecimal priceCost;
	
	@Column(name = "preco_venda")
	private BigDecimal priceSale;
	
	@Column(name = "observacao")
	private String observation;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Category category;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDrescription() {
		return drescription;
	}


	public void setDrescription(String drescription) {
		this.drescription = drescription;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPriceCost() {
		return priceCost;
	}


	public void setPriceCost(BigDecimal priceCost) {
		this.priceCost = priceCost;
	}


	public BigDecimal getPriceSale() {
		return priceSale;
	}


	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		return Objects.hash(category, drescription, id, observation, priceCost, priceSale, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(drescription, other.drescription)
				&& Objects.equals(id, other.id) && Objects.equals(observation, other.observation)
				&& Objects.equals(priceCost, other.priceCost) && Objects.equals(priceSale, other.priceSale)
				&& Objects.equals(quantity, other.quantity);
	}
	
	
}
