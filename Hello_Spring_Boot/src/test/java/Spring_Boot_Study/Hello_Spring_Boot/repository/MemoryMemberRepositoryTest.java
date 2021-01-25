package Spring_Boot_Study.Hello_Spring_Boot.repository;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 콜백 메소드
    @AfterEach
    public void afterEach() {
        // 테스트 하나 끝나면 repository 지워줌
        repository.clearStore();
    }

    //실행 단축키: ctrl + shift + F10
    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        // optional에서 값을 꺼낼 땐 get()이용(사실 get이 좋은 방법은 아닌데 테스트이므로)
        Member result = repository.findById(member.getId()).get();

        // 검증

        // 위에 new 만든 값이랑 메모리에 저장한 값이 같은지 확인
        //성공하면 파란불. 아니면 빨간 메세지
        //Assertions.assertEquals(member, result);

        // 요즘 많이 쓰는 방법
        assertThat(member).isEqualTo(result);
        //Assertions.assertThat(member).isEqualTo(result);
        // alt+enter -> static import하면 'Assertions' 숨기고 앞으로는 assertThat만 써도 됨
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // 팁: 위에 member1 세팅 세줄 복붙하고 shift+f6 누르고 이름을 "member2"로 바꾸면
        // 나머지도 member로 따라 같이 바뀜.
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        // get() 맨뒤에 쓰면 optional 꺼내서 줌.

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
