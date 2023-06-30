package za.co.team02.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import za.co.team02.model.FoodSupply;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.FoodRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

//    @PersistenceContext
//    private EntityManager em;
    public List<FoodSupply> getNoodles(int cohortId)
    {
        List<FoodSupply> food = foodRepository.getAllNoodles(cohortId).stream().collect(Collectors.toList());
        return  food;
    }

    public List<FoodSupply> getOats(int cohortId)
    {
        List<FoodSupply> food = foodRepository.getAllNoodles(cohortId).stream().collect(Collectors.toList());
        return  food;
    }
}
