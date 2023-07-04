package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.team02.model.AssetLog;
import za.co.team02.model.Facility;

import java.util.Collection;

public interface AssetLoggerRepository extends JpaRepository<AssetLog, Integer>
{
    @Query("SELECT a FROM asset_logger a WHERE a.candidate_id = ?1 ")
    Collection<AssetLog> getUserLogs(int id);
}
