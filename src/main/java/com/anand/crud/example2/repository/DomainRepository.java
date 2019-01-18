package com.anand.crud.example2.repository;

import com.anand.crud.example2.model.Domain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DomainRepository extends CrudRepository<Domain, Long> {

    public List<Domain> findByCompanyId(Long companyId);
}
