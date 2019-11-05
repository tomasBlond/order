package com.switchfully.order.domain.costumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostumerRepositoryTest {
    private CostumerRepository costumerRepository;

    @Test
    void createCostumer_whenCostumerIsCreated_costumerIsAddedToRepository(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        costumerRepository = new CostumerRepository();
        costumerRepository.save(costumer);

        assertTrue(costumerRepository.getAllCostumers().contains(costumer));
    }

    @Test
    void createCostumer_whenCostumerAlreadyExists_throwIllegalArgumentException(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        costumerRepository = new CostumerRepository();
        costumerRepository.save(costumer);

        Assertions.assertThrows(IllegalArgumentException.class, ()->  costumerRepository.save(costumer));
    }

}