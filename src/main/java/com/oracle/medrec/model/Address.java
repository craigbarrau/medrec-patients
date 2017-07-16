package com.oracle.medrec.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  private String city;
  private String country;
  private String state;
  private String street1;
  private String street2;
  private String zip;
  
  public String getCity()
  {
    return this.city;
  }
  
  public void setCity(String city)
  {
    this.city = city;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public void setCountry(String country)
  {
    this.country = country;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getStreet1()
  {
    return this.street1;
  }
  
  public void setStreet1(String street1)
  {
    this.street1 = street1;
  }
  
  public String getStreet2()
  {
    return this.street2;
  }
  
  public void setStreet2(String street2)
  {
    this.street2 = street2;
  }
  
  public String getZip()
  {
    return this.zip;
  }
  
  public void setZip(String zip)
  {
    this.zip = zip;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Address address = (Address)o;
    if (this.city != null ? !this.city.equals(address.city) : address.city != null) {
      return false;
    }
    if (this.country != null ? !this.country.equals(address.country) : address.country != null) {
      return false;
    }
    if (this.state != null ? !this.state.equals(address.state) : address.state != null) {
      return false;
    }
    if (this.street1 != null ? !this.street1.equals(address.street1) : address.street1 != null) {
      return false;
    }
    if (this.street2 != null ? !this.street2.equals(address.street2) : address.street2 != null) {
      return false;
    }
    if (this.zip != null ? !this.zip.equals(address.zip) : address.zip != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.city != null ? this.city.hashCode() : 0;
    result = 31 * result + (this.country != null ? this.country.hashCode() : 0);
    result = 31 * result + (this.state != null ? this.state.hashCode() : 0);
    result = 31 * result + (this.street1 != null ? this.street1.hashCode() : 0);
    result = 31 * result + (this.street2 != null ? this.street2.hashCode() : 0);
    result = 31 * result + (this.zip != null ? this.zip.hashCode() : 0);
    return result;
  }
}
