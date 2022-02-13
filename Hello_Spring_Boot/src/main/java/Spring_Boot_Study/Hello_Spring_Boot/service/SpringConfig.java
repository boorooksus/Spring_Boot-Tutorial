package Spring_Boot_Study.Hello_Spring_Boot.service;

import Spring_Boot_Study.Hello_Spring_Boot.repository.JpaMemberRepository;
import Spring_Boot_Study.Hello_Spring_Boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    private final DataSource dataSource;
//    private final EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.em = em;
//        this.dataSource = dataSource;
//    }

    // 스프링 빈에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // spring 데이터 jpa 이용하면 아래 설정 안해도 됨
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
