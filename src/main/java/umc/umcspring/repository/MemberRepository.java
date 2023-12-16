package umc.umcspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umcspring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
