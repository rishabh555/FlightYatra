package com.mytechtra.spring.FlightYatra.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table (name="FlightUser")
@NamedQuery(name = "findByName", query = "from FlightUser f where f.userName = ?1 ")
public class FlightUser implements UserDetails {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="isAccountNonExpired")
	private boolean isAccountNonExpired;
	
	@Column(name="isAccountNonLocked")
	private boolean isAccountNonLocked;
	
	@Column(name="isCredentialsNonExpired")
	private boolean isCredentialsNonExpired;

	@Column(name="isEnabled")
	private boolean isEnabled;
	
	@Column(name="authoritiesStr")
	private String authoritiesStr;
	
	public enum YatraRole implements GrantedAuthority{
		ROLE_USER,ROLE_ADMIN,ROLE_TIMEPASS;

		@Override
		public String getAuthority() {
			return this.name();
		}
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setAuthoritiesStr(String authorities) {
		this.authoritiesStr = authorities;
	}
	
	public String getAuthoritiesStr() {
		return authoritiesStr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] roles = authoritiesStr.split(",");
		List<YatraRole> gas = new ArrayList<FlightUser.YatraRole>();
		for(String role : roles) {
			gas.add(YatraRole.valueOf(role));
		}
		return gas;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

}
