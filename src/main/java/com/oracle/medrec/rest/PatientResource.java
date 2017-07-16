package com.oracle.medrec.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.medrec.model.Patient;
import com.oracle.medrec.repository.PatientRepository;

@Component
@Path("/patients")
public class PatientResource implements Resource {
  
  @Autowired
  private PatientRepository repository;

  @GET
  public List<Patient> query(){
    return repository.findAll();
  }
}
