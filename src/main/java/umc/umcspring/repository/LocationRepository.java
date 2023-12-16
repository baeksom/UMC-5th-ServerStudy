package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
