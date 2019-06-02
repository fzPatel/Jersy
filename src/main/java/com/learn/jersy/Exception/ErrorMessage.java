package com.learn.jersy.Exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage 
{
String errorMessage;
int errorCode;
String doc;


public ErrorMessage() {
	// TODO Auto-generated constructor stub
}
public ErrorMessage(String errorMessage, int errorCode, String doc) {
	super();
	this.errorMessage = errorMessage;
	this.errorCode = errorCode;
	this.doc = doc;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getDoc() {
	return doc;
}
public void setDoc(String doc) {
	this.doc = doc;
}
@Override
public String toString() {
	return "ErrorMessage [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", doc=" + doc + "]";
}
	

}
