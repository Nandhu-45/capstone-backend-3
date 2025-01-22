package com.hcl.entity;

public class Owner {

	private int ownerId;
	private String ownerName;
	private String ownerEmail;
	private String ownerPassword;
	private String ownerPic;
	public Owner() {
		
	}
	public Owner(int ownerId, String ownerName, String ownerEmail, String ownerPassword, String ownerPic) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
		this.ownerPic = ownerPic;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	public String getOwnerPic() {
		return ownerPic;
	}
	public void setOwnerPic(String ownerPic) {
		this.ownerPic = ownerPic;
	}
	
	

}
