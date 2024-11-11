package org.example.quickrescueapplication.controller;


import org.example.quickrescueapplication.entity.Contract;
import org.example.quickrescueapplication.service.ContractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "*")
public class ContractApi {

    @Autowired
    private ContractManager contractManager;

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        Contract savedContract = contractManager.create(contract);
        return savedContract;
    }

    @GetMapping("/{id}")
    public Contract get(@PathVariable Long id) {
        Contract contract = contractManager.getById(id);
        return contract;
    }

    @PutMapping
    public Contract update(@RequestBody Contract contract) {
        Contract updatedContract = contractManager.update(contract);
        return updatedContract;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contractManager.delete(id);
    }

    @GetMapping
    public Contract getByAccount(@RequestParam Long accountId) {
        return contractManager.findByAccountId(accountId);
    }


}
