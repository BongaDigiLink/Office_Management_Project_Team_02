package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Food_Supplies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodSupply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int foodId;
    @Column(name = "noodle_total")
    private int noodleTotal;
    @Column(name = "oats_total")
    private int oatsTotal;
}
