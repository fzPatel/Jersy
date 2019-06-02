package com.learn.jersy.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile
{
private long id;
private String profilename;
private String firstname;
private String lastname;
private Date create;

public Profile() {
	// TODO Auto-generated constructor stub
}

public Profile(long id, String profilename, String firstname, String lastname) {
	super();
	this.id = id;
	this.profilename = profilename;
	this.firstname = firstname;
	this.lastname = lastname;
	this.create = new Date();
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getProfilename() {
	return profilename;
}

public void setProfilename(String profilename) {
	this.profilename = profilename;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Date getCreate() {
	return create;
}

public void setCreate(Date create) {
	this.create = create;
}



}
