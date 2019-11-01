package com.switchfully.order.api.costumer;

import com.switchfully.order.api.DtoMapper;
import com.switchfully.order.api.costumer.dto.CostumerDto;
import com.switchfully.order.api.costumer.dto.CreateCostumerDto;
import com.switchfully.order.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/costumers")
public class CostumerController {
    private CostumerService costumerService;
    private DtoMapper dtoMapper;

    @Autowired
    public CostumerController(CostumerService costumerService, DtoMapper dtoMapper) {
        this.costumerService = costumerService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CostumerDto addNewCostumer(@RequestBody CreateCostumerDto createCostumerDto){
        var costumer = dtoMapper.createCostumerDtoToCostumer(createCostumerDto);
        costumerService.createCostumer(costumer);
        return dtoMapper.costumerToDto(costumer);
    }

}
