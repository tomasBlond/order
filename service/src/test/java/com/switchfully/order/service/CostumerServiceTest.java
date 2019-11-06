package com.switchfully.order.service;

import com.switchfully.order.domain.costumer.Costumer;
import com.switchfully.order.domain.costumer.CostumerRepository;
import com.switchfully.order.domain.item.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CostumerService.class, CostumerRepository.class})
class CostumerServiceTest {
    @Autowired  private CostumerService costumerService;

    @Test
    void getCostumerById_costumerExists_returnCostumer(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        Costumer costumer2 = new Costumer("tomas2", "blondeel2", "email2", "address2", 1123456);
        costumerService.createCostumer(costumer2);

        Assertions.assertEquals(costumer, costumerService.getCostumerById("blondeeltomas"));
        Assertions.assertEquals(costumer2, costumerService.getCostumerById("blondeel2tomas2"));
    }

    @Test
    void getCostumerById_costumerDoesNotExist_throwException(){
        Costumer costumer = new Costumer("tomas", "blondeel", "email", "address", 123456);
        costumerService.createCostumer(costumer);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> costumerService.getCostumerById("blondeel2tomas"));
    }
}