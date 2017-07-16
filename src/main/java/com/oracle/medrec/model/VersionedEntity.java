package com.oracle.medrec.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class VersionedEntity
  extends BaseEntity
{
  private static final long serialVersionUID = 1L;

  @Version
  private Integer version;
  
  public Integer getVersion()
  {
    return this.version;
  }
  
  protected void setVersion(Integer version)
  {
    this.version = version;
  }
}
