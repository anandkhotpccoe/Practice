package com.anand.crud.example2.repository;

import com.anand.crud.example2.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
