package com.oracle.medrec.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="physicians")
public class Physician
  extends RegularUser
{
  private static final long serialVersionUID = 1L;
}
