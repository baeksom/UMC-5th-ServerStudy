package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
