package com.oracle.medrec.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="drugs")
@NamedQuery(name="Drug.findAllDrugs", query="SELECT d FROM Drug d ORDER BY d.id")
public class Drug
  extends VersionedEntity
{
  private static final long serialVersionUID = 1L;
  
  private String name;
  private BigDecimal price;
  
  public void setID(long id)
  {
    super.setId(Long.valueOf(id));
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getProducer()
  {
    return "Oracle";
  }
  
  public BigDecimal getPrice()
  {
    return this.price;
  }
  
  public void setPrice(BigDecimal price)
  {
    this.price = price;
  }
}
