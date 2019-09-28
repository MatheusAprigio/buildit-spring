package br.com.buildit.resource;

import br.com.buildit.model.Company;
import br.com.buildit.repository.CompanyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Operações para manipulação/visualização de empresas")
@RestController
@RequestMapping("api/v1/companies")
public class CompanyResource {

    @Autowired
    private CompanyRepository companyRepository;

    @ApiOperation(value = "Retorna uma lista de todas as empresas disponíveis")
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

}
