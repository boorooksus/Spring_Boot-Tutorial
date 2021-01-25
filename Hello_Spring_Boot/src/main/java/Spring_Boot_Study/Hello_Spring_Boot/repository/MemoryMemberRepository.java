package Spring_Boot_Study.Hello_Spring_Boot.repository;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

// 스프링 컨테이너에 Repository로 등록
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null이 리턴될 가능성이 있을땐 Optional사용. 이렇게하면 null 대신 optional이 감싸짐.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // 자바 람다식
        // findAny(): 하나라도 찾는 것
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // repository 비워줌(테스트 할 때 사용)
    public void clearStore(){
        store.clear();
    }
}
