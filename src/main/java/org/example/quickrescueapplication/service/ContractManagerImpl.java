package org.example.quickrescueapplication.service;


import org.example.quickrescueapplication.dao.repository.ContractRepositoryService;
import org.example.quickrescueapplication.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractManagerImpl implements ContractManager {

    @Autowired
    private ContractRepositoryService contractRepositoryService;

    /**
     * This method is used to create a contract
     * @param contract
     * @return
     */
    @Override
    public Contract create(Contract contract) {
        Contract savedContract = contractRepositoryService.create(contract);
        return savedContract;
    }

    /**
     * This method is used to update a contract
     * @param contract
     * @return
     */
    @Override
    public Contract update(Contract contract) {
        Contract updateContractEntity = contractRepositoryService.update(contract);
        return updateContractEntity;
    }

    /**
     * This method is used to delete a contract
     * @param id
     */
    @Override
    public void delete(Long id) {
        contractRepositoryService.delete(id);
    }

    /**
     * This method is used to find a contract
     * @param id
     * @return
     */
    @Override
    public Optional<Contract> find(Long id) {
        Optional<Contract> contract = contractRepositoryService.find(id);
        return contract;
    }

    /**
     * This method is used to get a contract by id
     * @param id
     * @return
     */
    @Override
    public Contract getById(Long id) {
        return null;
    }

    /**
     * This method is used to get a contract by account id
     * @param accountId
     * @return
     */
    @Override
    public Contract findByAccountId(Long accountId) {
      Contract contract=  contractRepositoryService.findByAccountId(accountId);
        return contract;
    }
}
