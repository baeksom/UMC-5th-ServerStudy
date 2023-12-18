package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Review;
import umc.umcspring.domain.mapping.MemberMission;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByMemberMission(MemberMission memberMission);
}
