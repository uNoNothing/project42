package com.yeti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50)
	private String username;

	@NotNull
	@Column(length = 200)
	private String password;

	@NotNull
	private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
	private Authorities authorities;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
	private UsersDetails usersDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}

	public UsersDetails getUsersDetails() {
		return usersDetails;
	}

	public void setUsersDetails(UsersDetails usersDetails) {
		this.usersDetails = usersDetails;
	}
}