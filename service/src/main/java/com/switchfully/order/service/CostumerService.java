package com.switchfully.order.service;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.costumer.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CostumerService {
    private CostumerRepository costumerRepository;

    @Autowired
    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Costumer> getAll(){
        return costumerRepository.getAllCostumers();
    }

    public void createCostumer(Costumer costumer){
        costumerRepository.save(costumer);
    }

    public Costumer getCostumerById(String id){
        if (costumerRepository.getAllCostumers()
                .stream().anyMatch(costumer -> costumer.getId().equals(id))) {
            return costumerRepository.getAllCostumers()
             .stream().filter(costumer -> costumer.getId().equals(id))
            .findAny().get();
        }
        throw new  IllegalArgumentException("Customer with that Id doesn't Exist");
    }
}
