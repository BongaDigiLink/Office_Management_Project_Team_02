package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.team02.model.AssetLog;
import za.co.team02.model.Facility;

import java.util.Collection;
import java.util.List;

public interface AssetLoggerRepository extends JpaRepository<AssetLog, Integer>
{
    @Query("SELECT a FROM asset_logger a WHERE a.candidateId = ?1 ")
    Collection<AssetLog> getUserLogs(int id);
}
