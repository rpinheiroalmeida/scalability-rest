package br.edu.scalability.bmfbovespa.company;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @RequestMapping(value = "/{code}")
    public  Company findCompany(@PathVariable String code) {
        return new CompanyBuilder().withCode(code).withName("Petrobras").build();
    }

    @RequestMapping("/list")
    public List<Company> list() {
        return Arrays.asList(new CompanyBuilder().withCode("PETR4").withName("Petrobras").build());
    }
}
