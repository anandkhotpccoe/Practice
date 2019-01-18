package com.anand.crud.example2.service.impl;

import com.anand.crud.example2.model.Domain;
import com.anand.crud.example2.repository.DomainRepository;
import com.anand.crud.example2.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DomainServiceImpl implements DomainService {


    @Autowired
    DomainRepository domainRepository;


    @Override
    public Domain add(Domain domain) {
        return domainRepository.save(domain);
    }

    @Override
    public void delete(Long id) {
        domainRepository.deleteById(id);

    }

    @Override
    public Domain update(Domain domain) {
        return domainRepository.save(domain);
    }

    @Override
    public Domain get(Long id) {
        Domain finalresult = null;
        Optional<Domain> result =domainRepository.findById(id);
        if (result.isPresent())
        {
            finalresult = result.get();
        }

        return finalresult;
    }

    @Override
    public Iterable<Domain> getAll(Long id) {
        Iterable<Domain> result = domainRepository.findByCompanyId(id);
        return result;
    }
}
