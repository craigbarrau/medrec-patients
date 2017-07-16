package com.oracle.medrec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.medrec.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
