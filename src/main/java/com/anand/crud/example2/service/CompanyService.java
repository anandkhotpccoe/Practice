package com.anand.crud.example2.service;

import com.anand.crud.example2.model.Company;

public interface CompanyService {

    public Company add(Company company);

    public void delete(Long id);

    public Company update(Company company);

    public  Company get(Long id);

    public Iterable<Company> getAll();
}
