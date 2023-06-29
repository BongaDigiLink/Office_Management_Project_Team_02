package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.Asset;

import java.util.Optional;

public interface AssetRepository extends JpaRepository<Asset, Integer> {


}
