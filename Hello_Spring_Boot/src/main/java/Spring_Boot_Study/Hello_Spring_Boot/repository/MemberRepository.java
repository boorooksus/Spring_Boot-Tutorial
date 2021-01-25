package Spring_Boot_Study.Hello_Spring_Boot.repository;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // 회원 정보 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
