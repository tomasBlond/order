package com.switchfully.order.domain.costumer;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CostumerRepository {
    private List<Costumer> costumerRepository = new ArrayList<>();

    public List<Costumer> getAllCostumers() {
        return costumerRepository;
    }

    public void save(Costumer costumer) {
        costumerRepository.add(costumer);
    }
}
