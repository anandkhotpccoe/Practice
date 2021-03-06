package com.anand.crud.example2.controller;


import com.anand.crud.example2.model.Company;
import com.anand.crud.example2.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@Api(value = "Company Resource", description = "All API related to Company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @ApiOperation(value = "Add Company")
    @PostMapping("/companies")
    @ApiResponses(
            value =
                    {
                            @ApiResponse(code = 500, message = "Internal Server Error")
                    }
    )
    public ResponseEntity<Company> add(@RequestBody Company company)
    {
        Company result = companyService.add(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @GetMapping("/companies")
    public ResponseEntity<Iterable<Company>> getAll()
    {
        Iterable<Company> result = companyService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(companyService.get(id),HttpStatus.OK);
    }

    @PutMapping("/companies")
    public ResponseEntity<Company> update(@RequestBody Company company)
    {
        Company result = companyService.update(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        companyService.delete(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
