package com.learn.jersey.Masters.Exception;

public class ErrorMessage
{
private String errorCode;
private String errorMessage;
private String errorDoc;
@Override
public String toString() {
	return "ErrorMessage [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorDoc=" + errorDoc + "]";
}
public ErrorMessage(String errorCode, String errorMessage, String errorDoc) {
	super();
	this.errorCode = errorCode;
	this.errorMessage = errorMessage;
	this.errorDoc = errorDoc;
}



	
}
