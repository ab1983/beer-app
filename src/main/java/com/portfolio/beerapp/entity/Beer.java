package com.portfolio.beerapp.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="beers")
public class Beer {
	
	@Id
	private BigInteger id;
	private String name;
	@Column(name="descript")
	private String description;
	private Double abv;
	//@Column(name="brevery_id")
	private Long breweryId;
	@ManyToOne
	@JoinColumn(name = "breweryId", insertable=false, updatable=false)		
	private Brewery brewery;

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
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
	public Double getAbv() {
		return abv;
	}
	public void setAbv(Double abv) {
		this.abv = abv;
	}
	public Brewery getBrevery() {
		return brewery;
	}
	public void setBrevery(Brewery brevery) {
		this.brewery = brevery;
	}
	
	public Long getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abv == null) ? 0 : abv.hashCode());
		result = prime * result + ((brewery == null) ? 0 : brewery.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (abv == null) {
			if (other.abv != null)
				return false;
		} else if (!abv.equals(other.abv))
			return false;
		if (brewery == null) {
			if (other.brewery != null)
				return false;
		} else if (!brewery.equals(other.brewery))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", description=" + description + ", abv=" + abv + ", brevery="
				+ brewery + "]";
	}

	
	
}
