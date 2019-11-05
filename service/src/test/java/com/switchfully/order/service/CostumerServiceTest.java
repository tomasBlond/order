package com.switchfully.order.service;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.costumer.CostumerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CostumerServiceTest {
    private CostumerService costumerService = new CostumerService(new CostumerRepository());

    @Test
    void getCostumerById_costumerExists_returnCostumer(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        Costumer costumer2 = new Costumer("tomas2", "blondeel2", "email", "address", 123456);
        costumerService.createCostumer(costumer);
        costumerService.createCostumer(costumer2);

        Assertions.assertEquals(costumer, costumerService.getCostumerById("blondeeltomas"));
        Assertions.assertEquals(costumer2, costumerService.getCostumerById("blondeel2tomas2"));
    }

    @Test
    void getCostumerById_costumerDOESNOTExist_throwException(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        costumerService.createCostumer(costumer);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> costumerService.getCostumerById("blondeel2tomas"));
    }
}