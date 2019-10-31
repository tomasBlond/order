import costumer.Costumer;
import costumer.CostumerRepository;

import java.util.List;

public class CostumerService {
    private CostumerRepository costumerRepository;

    public CostumerService(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public List<Costumer> getAll(){
        return costumerRepository.getAllCostumers();
    }

    public Costumer createCostumer(Costumer costumer){
        costumerRepository.save(costumer);
        return costumer;
    }
}
