package com.oracle.medrec.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="records")
@NamedQueries({@javax.persistence.NamedQuery(name="Record.findRecordsByPatientId", query="SELECT r FROM Record r WHERE r.patient.id = :patientId"), @javax.persistence.NamedQuery(name="Record.findRecordsByDateInterval", query="SELECT r FROM Record r WHERE r.date >= :startDate and r.date <= :endDate")})
public class Record
  extends VersionedEntity
{
  
  private static final long serialVersionUID = 1L;
  
  private String diagnosis;
  private String notes;
  @Temporal(TemporalType.DATE)
  @Column(name="CREATE_DATE")
  private Date date;
  private String symptoms;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  private Patient patient;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(nullable=false, updatable=false)
  private Physician physician;
  private VitalSigns vitalSigns;
  @Transient
  private BigDecimal cost = BigDecimal.ZERO;
  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.EAGER)
  private List<Prescription> prescriptions = new LinkedList<>();
  
  public String getDiagnosis()
  {
    return this.diagnosis;
  }
  
  public void setDiagnosis(String diagnosis)
  {
    this.diagnosis = diagnosis;
  }
  
  public String getNotes()
  {
    return this.notes;
  }
  
  public void setNotes(String notes)
  {
    this.notes = notes;
  }
  
  public Physician getPhysician()
  {
    return this.physician;
  }
  
  public void setPhysician(Physician physician)
  {
    this.physician = physician;
  }
  
  public List<Prescription> getPrescriptions()
  {
    return this.prescriptions;
  }
  
  public void setPrescriptions(List<Prescription> prescriptions)
  {
    this.prescriptions = prescriptions;
  }
  
  public void addPrescription(Prescription prescription)
  {
    this.prescriptions.add(prescription);
  }
  
  public Date getDate()
  {
    return this.date;
  }
  
  public void setDate(Date date)
  {
    this.date = date;
  }
  
  public String getSymptoms()
  {
    return this.symptoms;
  }
  
  public void setSymptoms(String symptoms)
  {
    this.symptoms = symptoms;
  }
  
  public VitalSigns getVitalSigns()
  {
    return this.vitalSigns;
  }
  
  public void setVitalSigns(VitalSigns vitalSigns)
  {
    this.vitalSigns = vitalSigns;
  }
  
  public Patient getPatient()
  {
    return this.patient;
  }
  
  public void setPatient(Patient patient)
  {
    this.patient = patient;
  }
  
  public BigDecimal countCost()
  {
    this.cost = BigDecimal.ZERO;
    if (this.prescriptions != null) {
      for (Prescription p : this.prescriptions) {
        this.cost = this.cost.add(p.getCost());
      }
    }
    return this.cost;
  }
  
  public BigDecimal getCost()
  {
    return this.cost;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Record record = (Record)o;
    if (this.diagnosis != null ? !this.diagnosis.equals(record.diagnosis) : record.diagnosis != null) {
      return false;
    }
    if (this.patient != null ? !this.patient.equals(record.patient) : record.patient != null) {
      return false;
    }
    if (this.physician != null ? !this.physician.equals(record.physician) : record.physician != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = this.diagnosis != null ? this.diagnosis.hashCode() : 0;
    result = 31 * result + (this.patient != null ? this.patient.hashCode() : 0);
    result = 31 * result + (this.physician != null ? this.physician.hashCode() : 0);
    return result;
  }
}
