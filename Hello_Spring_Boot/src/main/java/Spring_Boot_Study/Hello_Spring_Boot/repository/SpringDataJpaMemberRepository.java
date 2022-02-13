package Spring_Boot_Study.Hello_Spring_Boot.repository;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // select m from Member where m.name = ? 과 같은 기능함.
    @Override
    Optional<Member> findByName(String name);
}
