package com.oracle.medrec.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User
  extends VersionedEntity
{
  private static final long serialVersionUID = 1L;
  @Column(unique=true)
  private String username;
  private String password;
  @Column(unique=true)
  private String email;
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
    setUsername(email);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    User user = (User)o;
    if (!this.email.equals(user.email)) {
      return false;
    }
    if (!this.password.equals(user.password)) {
      return false;
    }
    if (!this.username.equals(user.username)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.username.hashCode();
    result = 31 * result + this.password.hashCode();
    result = 31 * result + this.email.hashCode();
    return result;
  }
}
