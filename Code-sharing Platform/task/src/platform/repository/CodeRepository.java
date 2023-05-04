package platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import platform.entity.Code;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CodeRepository extends JpaRepository<Code, UUID> {
    @Query(value =
            "SELECT c FROM Code c " +
            "WHERE c.id = :id " +
            "AND ((c.timeAvailable > CURRENT_TIMESTAMP OR c.timeAvailable IS NULL) " +
            "AND (c.viewsAvailable > 0 OR c.viewsAvailable IS NULL))")
    Optional<Code> findAvailableById(@Param("id") UUID id);

    List<Code> findTop10ByOrderByCreatedAtDesc();

@Query(value =
        "SELECT c FROM Code c " +
        "WHERE c.timeAvailable IS NULL " +
        "AND c.viewsAvailable IS NULL " +
        "ORDER BY c.createdAt DESC " +
        "LIMIT 10")
    List<Code> findNotRestrictedTop10ByOrderByCreatedAtDesc();
}
