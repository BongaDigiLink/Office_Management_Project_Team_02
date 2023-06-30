package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.FoodSupply;

public interface FoodRepository extends JpaRepository<FoodSupply,Integer> {
}
