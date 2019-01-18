package com.anand.crud.example2.controller;


import com.anand.crud.example2.model.Company;
import com.anand.crud.example2.model.Domain;
import com.anand.crud.example2.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DomainController {

    @Autowired
    DomainService domainService;

    @PostMapping("/companies/{companyId}/domain")
    public ResponseEntity<Domain> add(@RequestBody Domain domain, @PathVariable Long companyId)
    {
        domain.setCompany(new Company(companyId," ", ""));
        Domain result = domainService.add(domain);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/companies/{id}/domain")
    public ResponseEntity<Iterable<Domain>> getAll(@PathVariable Long id)
    {
        Iterable<Domain> result = domainService.getAll(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("companies/{companyId}/domain/{id}")
    public ResponseEntity<Domain> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(domainService.get(id),HttpStatus.OK);
    }

    @PutMapping("/companies/{companyId}/domain")
    public ResponseEntity<Domain> update(@RequestBody Domain domain, @PathVariable Long companyId)
    {
        domain.setCompany(new Company(companyId,"", ""));
        Domain result = domainService.update(domain);
        return new ResponseEntity<>(domain, HttpStatus.OK);
    }

    @DeleteMapping("/companies/{companyId}/domain/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        domainService.delete(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


}
