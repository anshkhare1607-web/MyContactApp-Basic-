package com.userregistration;

public abstract class User {
	private String email;
	private String passwordHash;
	private UserProfile profile;
	
	public User(String email,String passwordHash,UserProfile profile) {
		this.email = email;
		this.passwordHash = passwordHash;
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfileInfo(UserProfile profile) {
		this.profile = profile;
	}
	public abstract void showUserDetails();
}
