package com.web2h.nan.model.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.web2h.nan.model.entity.common.FieldMaxLength;
import com.web2h.nan.model.entity.common.IdentifiableAndVersionableEntity;

/**
 * Application user entity class.
 *
 * @author Web2h
 */
@Entity
@Table(name = "users")
public class User extends IdentifiableAndVersionableEntity {

	private static final long serialVersionUID = 1L;

	/** User email. */
	@Column(name = "email", length = FieldMaxLength.EMAIL, nullable = false, unique = true)
	private String email;

	/** User name or pseudo. */
	@Column(name = "name", length = FieldMaxLength.NAME, nullable = false)
	private String name;

	/** Encrypted password. */
	@Column(name = "password", length = FieldMaxLength.PASSWORD, nullable = false)
	private String password;

	/** Salt used to secure the password encryption. */
	@Column(name = "salt", length = FieldMaxLength.PASSWORD, nullable = false)
	private String salt;

	// @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval =
	// true)
	// private Set<UserRole> roles = new HashSet<UserRole>();

	/** User status */
	@Column(name = "status", nullable = false, length = FieldMaxLength.STATUS)
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.INACTIVE;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getSalt() {
		return salt;
	}

	public UserStatus getStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/**
	 * Is the user active?
	 *
	 * @return true if he is, false if he is not
	 */
	@Transient
	public boolean isActive() {
		return UserStatus.ACTIVE.equals(status);
	}

	/**
	 * Is the user inactive?
	 *
	 * @return true if he is, false if he is not
	 */
	@Transient
	public boolean isInactive() {
		return UserStatus.INACTIVE.equals(status);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Set<UserRole> getRoles() { return roles; }
	 *
	 * public void addRole(UserRole role) { roles.add(role); }
	 */

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
}