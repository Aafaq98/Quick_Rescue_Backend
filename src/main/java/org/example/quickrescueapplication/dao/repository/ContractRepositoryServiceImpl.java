package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ContractRepositoryServiceImpl  implements ContractRepositoryService{

    @Autowired
    private ContractRepository contractRepository;

    /**
     * This method is used to create an contract
     * @param contract
     * @return
     */
    @Override
    public Contract create(Contract contract) {
        Contract savedContract = contractRepository.save(contract);
        return savedContract;
    }

    /**
     * This method is used to update an contract
     * @param contract
     * @return
     */
    @Override
    public Contract update(Contract contract) {
        Contract updateContractEntity = contractRepository.save(contract);
        return  updateContractEntity;
    }

    /**
     * This method is used to delete an contract
     * @param id
     */
    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    /**
     * This method is used to find an contract
     * @param id
     * @return
     */
    @Override
    public Optional<Contract> find(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        return contract;
    }

    /**
     * This method is used to get an contract by id
     * @param id
     * @return
     */
    @Override
    public Contract getById(Long id) {
        Contract contract = contractRepository.getById(id);
        return contract;
    }

    /**
     * This method is used to get an contract by account id
     * @param accountId
     * @return
     */
    @Override
    public Contract findByAccountId(Long accountId) {
        Contract contract = contractRepository.findByAccountId(accountId);
        return contract;
    }
}
