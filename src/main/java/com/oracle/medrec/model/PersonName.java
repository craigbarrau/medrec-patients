package com.oracle.medrec.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersonName implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private String firstName;
  private String lastName;
  private String middleName;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder(this.lastName);
    builder.append(" ");
    if (this.middleName != null) {
      builder.append(this.middleName);
      builder.append(" ");
    }
    builder.append(this.lastName);
    return builder.toString();
  }
}
