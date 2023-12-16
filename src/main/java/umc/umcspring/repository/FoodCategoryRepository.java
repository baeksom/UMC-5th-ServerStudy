package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
