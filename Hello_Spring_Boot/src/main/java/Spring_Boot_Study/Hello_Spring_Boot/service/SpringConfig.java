package Spring_Boot_Study.Hello_Spring_Boot.service;

import Spring_Boot_Study.Hello_Spring_Boot.repository.MemberRepository;
import Spring_Boot_Study.Hello_Spring_Boot.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    // 스프링 빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
