package com.oracle.medrec.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class RegularUser extends User {
  
  private static final long serialVersionUID = 1L;

  private PersonName name = new PersonName();
  private String phone;

  public PersonName getName() {
    return this.name;
  }

  public void setName(PersonName name) {
    this.name = name;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RegularUser)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    RegularUser that = (RegularUser) o;
    if (this.name != null ? !this.name.equals(that.name) : that.name != null) {
      return false;
    }
    if (this.phone != null ? !this.phone.equals(that.phone) : that.phone != null) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
    result = 31 * result + (this.phone != null ? this.phone.hashCode() : 0);
    return result;
  }
}
