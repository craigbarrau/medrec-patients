package com.oracle.medrec.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prescriptions")
public class Prescription extends VersionedEntity {
  
  private static final long serialVersionUID = 1L;
  
  @Column(name = "date_prescribed")
  @Temporal(TemporalType.DATE)
  private Date datePrescribed = new Date();
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false, updatable = false)
  private Drug drug;
  private int dosage;
  private String frequency;
  private String instructions;
  @Column(name = "refills_remaining")
  private int refillsRemaining;

  public Date getDatePrescribed() {
    return this.datePrescribed;
  }

  public void setDatePrescribed(Date datePrescribed) {
    this.datePrescribed = datePrescribed;
  }

  public Drug getDrug() {
    return this.drug;
  }

  public void setDrug(Drug drug) {
    this.drug = drug;
  }

  public int getDosage() {
    return this.dosage;
  }

  public void setDosage(int dosage) {
    this.dosage = dosage;
  }

  public String getFrequency() {
    return this.frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getInstructions() {
    return this.instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public int getRefillsRemaining() {
    return this.refillsRemaining;
  }

  public void setRefillsRemaining(int refillsRemaining) {
    this.refillsRemaining = refillsRemaining;
  }

  public BigDecimal getCost() {
    if ((this.drug != null) && (this.dosage != 0)) {
      return this.drug.getPrice().multiply(new BigDecimal(this.dosage));
    }
    return BigDecimal.ZERO;
  }
}
