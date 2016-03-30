package com.web2h.nan.model.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Abstract mapped entity class to specify that an entity has a version number.
 * 
 * @author Web2h
 */
@MappedSuperclass
public class VersionableEntity implements Serializable {

	/** Entity version. */
	@Version
	private Integer version;
	
	private static final long serialVersionUID = 1L;
}
