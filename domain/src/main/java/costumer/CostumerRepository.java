package costumer;

import java.util.ArrayList;
import java.util.List;

public class CostumerRepository {
    private List<Costumer> costumerRepository = new ArrayList<>();

    public List<Costumer> getAllCostumers() {
        return costumerRepository;
    }

    public void save(Costumer costumer) {
        costumerRepository.add(costumer);
    }
}
