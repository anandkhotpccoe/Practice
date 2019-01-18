package com.anand.crud.example2.service.impl;


import com.anand.crud.example2.model.Company;
import com.anand.crud.example2.repository.CompanyRepository;
import com.anand.crud.example2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company add(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);

    }

    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company get(Long id) {
        Company company = null;

        Optional<Company> result = companyRepository.findById(id);
        if (result.isPresent())
        {
            company = result.get();
        }

        return company;
    }

    @Override
    public Iterable<Company> getAll() {
        Iterable<Company> result = companyRepository.findAll();
        return result;
    }
}
