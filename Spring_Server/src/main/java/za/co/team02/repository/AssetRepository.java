package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
