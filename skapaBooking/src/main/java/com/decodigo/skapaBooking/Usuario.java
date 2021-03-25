package com.decodigo.skapaBooking;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {
	private int code;
	private String name;
	private String username;
	
	public Usuario(int code, String name, String username) {
		super();
		this.code = code;
		this.name = name;
		this.username = username;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [code=" + code + ", name=" + name + ", username=" + username + "]";
	}
	

}
