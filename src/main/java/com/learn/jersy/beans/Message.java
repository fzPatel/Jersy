package com.learn.jersy.beans;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message
{
private long id;
private String message;
private Date created;
private String authore;

public Message() {
	// TODO Auto-generated constructor stub
}


public Message(long id, String message, String authore) {
	super();
	this.id = id;
	this.message = message;
	this.created = new Date();
	this.authore = authore;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public String getAuthore() {
	return authore;
}
public void setAuthore(String authore) {
	this.authore = authore;
}
@Override
public String toString() {
	return "Message [id=" + id + ", message=" + message + ", created=" + created + ", authore=" + authore + "]";
}



}
