package com.web2h.nan.model.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Abstract mapped entity class to specify that an entity has an ID and a version number.
 */
@MappedSuperclass
public abstract class Entity implements Serializable {

	/** Primary key. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	/** Entity version. */
	@Version
	private Integer version;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Checks if the object is in creation mode, false otherwise.
	 * 
	 * @return True if the object is in creation mode, false otherwise
	 */
	public boolean isCreation() {
		return id == null;
	}

	/**
	 * Checks if the object is in update mode, false otherwise.
	 * 
	 * @return True if the object is in update mode, false otherwise
	 */
	public boolean isUpdate() {
		return id != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}	
}