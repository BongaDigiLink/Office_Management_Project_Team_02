package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.team02.model.FoodSupply;
import java.util.Collection;

@Repository
public interface FoodRepository extends JpaRepository<FoodSupply,Integer> {
//    @Query("SELECT * FROM Food_Supplies f WHERE f.Food_id = 9 ")
//@Query("SELECT * FROM Food_Supplies f WHERE f.id = ? ")
//   Collection<FoodSupply> getFoodByCohort(int cohortId);
@Query("SELECT COUNT(*) FROM Food_Supplies")
int getAllNoodles(String email);

@Query("SELECT COUNT(*) FROM Food_Supplies")
int getAllOats(String email);
}
