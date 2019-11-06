package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@Column(name="authorid")
	private int authorID;
	@Column(name="firstname")
	private String firstName;
	@Column(name="middlename")
	private String middleName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="phoneno")
	private String phoneno;
public Author(int authorID, String firstName, String middleName, String lastName, String phoneno) {
	super();
	this.authorID = authorID;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.phoneno = phoneno;
}
public Author() {
	super();
}
public int getAuthorID() {
	return authorID;
}
public void setAuthorID(int authorID) {
	this.authorID = authorID;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
@Override
public String toString() {
	return "Author [authorID=" + authorID + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
			+ lastName + ", phoneno=" + phoneno + "]";
}


}
