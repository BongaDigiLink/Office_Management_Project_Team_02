package za.co.team02.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import za.co.team02.model.FoodSupply;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.FoodRepository;

import java.util.ArrayList;
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
    public int getNoodles(String email)
    {
        int noodleCount = foodRepository.getAllNoodles(email);
        return noodleCount;
    }

    public int getOats(String email)
    {
        int oatsCount = foodRepository.getAllOats(email);
        return  oatsCount;
    }

    public List<Integer> getFood(String email)
    {
        List<Integer> foodCount = new ArrayList();
        foodCount.add(getNoodles(email));
        foodCount.add(getOats(email));
        return foodCount;
    }
}
