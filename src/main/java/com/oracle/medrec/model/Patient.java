package com.oracle.medrec.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "patients")
public class Patient extends RegularUser {
  
  private static final long serialVersionUID = 1L;
  
  @Temporal(TemporalType.DATE)
  private Date dob;
  @Enumerated(EnumType.STRING)
  private Gender gender;
  @Column(unique = true)
  private String ssn;
  private Address address;
  @Enumerated(EnumType.STRING)
  private Status status;
  @OneToMany(cascade = { javax.persistence.CascadeType.ALL })
  private List<Record> records;
  @Transient
  private boolean isSsnChanged;

  public Patient() {
    this.address = new Address();

    this.status = Status.REGISTERED;

    this.isSsnChanged = false;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Date getDob() {
    return this.dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getSsn() {
    return this.ssn;
  }

  public void setSsn(String ssn) {
    if ((this.ssn != null) && (!this.ssn.equals(ssn))) {
      setSsnChanged(true);
    }
    this.ssn = ssn;
  }

  public void approve() {
    setStatus(Status.APPROVED);
  }

  public void deny() {
    setStatus(Status.DENIED);
  }

  public boolean isApproved() {
    return Status.APPROVED.equals(getStatus());
  }

  public boolean isDenied() {
    return Status.DENIED.equals(getStatus());
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public boolean isSsnChanged() {
    return this.isSsnChanged;
  }

  public void setSsnChanged(boolean ssnChanged) {
    this.isSsnChanged = ssnChanged;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Patient)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Patient patient = (Patient) o;
    if (this.isSsnChanged != patient.isSsnChanged) {
      return false;
    }
    if (this.address != null ? !this.address.equals(patient.address) : patient.address != null) {
      return false;
    }
    if (this.dob != null ? !this.dob.equals(patient.dob) : patient.dob != null) {
      return false;
    }
    if (this.gender != patient.gender) {
      return false;
    }
    if (this.ssn != null ? !this.ssn.equals(patient.ssn) : patient.ssn != null) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (this.dob != null ? this.dob.hashCode() : 0);
    result = 31 * result + (this.gender != null ? this.gender.hashCode() : 0);
    result = 31 * result + (this.ssn != null ? this.ssn.hashCode() : 0);
    result = 31 * result + (this.address != null ? this.address.hashCode() : 0);
    result = 31 * result + (this.isSsnChanged ? 1 : 0);
    return result;
  }

  public static enum Status {
    REGISTERED, APPROVED, DENIED;

    private Status() {
    }
  }

  public static enum Gender {
    MALE, FEMALE;

    private Gender() {
    }
  }
}
