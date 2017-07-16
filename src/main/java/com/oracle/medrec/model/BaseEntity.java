package com.oracle.medrec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity
  extends DomainModel
{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  public Long getId()
  {
    return this.id;
  }
  
  protected void setId(Long id)
  {
    this.id = id;
  }
}
