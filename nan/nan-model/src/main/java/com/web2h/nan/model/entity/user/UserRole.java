package com.web2h.nan.model.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.web2h.nan.model.entity.common.IdentifiableEntity;

@Entity
@Table(name = "user_roles")
public class UserRole extends IdentifiableEntity {

	private static final long serialVersionUID = 6159954101750943432L;

	/** Role label. */
	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	private Authority authority;

	/** User linked to this role. */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserRole() {
	}

	public UserRole(Authority authority) {
		this.authority = authority;
	}

	public UserRole(Authority authority, User user) {
		this.authority = authority;
		this.user = user;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!(object instanceof UserRole)) {
			return false;
		}
		UserRole other = (UserRole) object;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public Authority getAuthority() {
		return authority;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ROLE [" + id + "] " + authority + " - users [" + user.getId() + "]";
	}
}