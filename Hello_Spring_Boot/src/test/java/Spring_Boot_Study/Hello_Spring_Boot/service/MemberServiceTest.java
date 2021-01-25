package Spring_Boot_Study.Hello_Spring_Boot.service;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import Spring_Boot_Study.Hello_Spring_Boot.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //MemberService memberService = new MemberService();
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    // 위 방식은 각자 다른 객체를 생성하므로 좋지 않음.
    // 현재는 store가 static 방식이므로 문제될 건 없지만 아래처럼 하는게 좋음.
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 각 테스트 실행 전에 이거 먼저 실행
    @BeforeEach
    public void beforeEach() {
        // 테스트 실행할 때마다 각각 생성
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 콜백 메소드
    @AfterEach
    public void afterEach() {
        // 테스트 하나 끝나면 memberRepository 지워줌
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //Then

        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

        //assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //Given
        // member1과 member2 이름이 같음.
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);

        // 예외가 제대로 발생하는지 확인

//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // 위 방법 대신 아래 방법 사용
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // 메시지 검증할 때
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}