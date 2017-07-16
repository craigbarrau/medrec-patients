package com.oracle.medrec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VitalSigns
  implements Serializable
{
  
  private static final long serialVersionUID = 1L;
  
  @Column(name="systolic_blood_pressure")
  private Double systolicBloodPressure;
  @Column(name="diastolic_blood_pressure")
  private Double diastolicBloodPressure;
  private Double height;
  private Double pulse;
  private Double temperature;
  private Double weight;
  
  public Double getSystolicBloodPressure()
  {
    return this.systolicBloodPressure;
  }
  
  public void setSystolicBloodPressure(Double systolicBloodPressure)
  {
    this.systolicBloodPressure = systolicBloodPressure;
  }
  
  public Double getDiastolicBloodPressure()
  {
    return this.diastolicBloodPressure;
  }
  
  public void setDiastolicBloodPressure(Double diastolicBloodPressure)
  {
    this.diastolicBloodPressure = diastolicBloodPressure;
  }
  
  public Double getHeight()
  {
    return this.height;
  }
  
  public void setHeight(Double height)
  {
    this.height = height;
  }
  
  public Double getPulse()
  {
    return this.pulse;
  }
  
  public void setPulse(Double pulse)
  {
    this.pulse = pulse;
  }
  
  public Double getTemperature()
  {
    return this.temperature;
  }
  
  public void setTemperature(Double temperature)
  {
    this.temperature = temperature;
  }
  
  public Double getWeight()
  {
    return this.weight;
  }
  
  public void setWeight(Double weight)
  {
    this.weight = weight;
  }
}
