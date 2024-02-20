package com.backend.bookStore.model;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	
	private static final long serialVersionUID = -2842914500969554169L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private byte active;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String modifiedBy;
	private String mobileNumber;
	private String profilePicturePath;
	private Timestamp creationTimestamp;
	private Timestamp modificationTimestamp;
	private Timestamp lastLoggedInTimestamp;
	private Timestamp lastLoggedOutTimestamp;
	private byte isLoggedIn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public Timestamp getModificationTimestamp() {
		return modificationTimestamp;
	}
	public void setModificationTimestamp(Timestamp modificationTimestamp) {
		this.modificationTimestamp = modificationTimestamp;
	}
	public Timestamp getLastLoggedInTimestamp() {
		return lastLoggedInTimestamp;
	}
	public void setLastLoggedInTimestamp(Timestamp lastLoggedInTimestamp) {
		this.lastLoggedInTimestamp = lastLoggedInTimestamp;
	}
	public Timestamp getLastLoggedOutTimestamp() {
		return lastLoggedOutTimestamp;
	}
	public void setLastLoggedOutTimestamp(Timestamp lastLoggedOutTimestamp) {
		this.lastLoggedOutTimestamp = lastLoggedOutTimestamp;
	}
	public byte getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(byte isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.mobileNumber;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
