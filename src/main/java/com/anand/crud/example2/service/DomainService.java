package com.anand.crud.example2.service;

import com.anand.crud.example2.model.Domain;

public interface DomainService {


    public Domain add(Domain domain);

    public void delete(Long id);

    public Domain update(Domain domain);

    public  Domain get(Long id);

    public Iterable<Domain> getAll(Long id);
}
