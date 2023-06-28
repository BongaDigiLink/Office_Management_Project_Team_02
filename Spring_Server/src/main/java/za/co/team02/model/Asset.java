package za.co.team02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="assets")
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int candidateId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "equipment_status")
    private String equipmentStatus;

    @Column(name = "equipment_condition")
    private String equipmentCondition;
}
