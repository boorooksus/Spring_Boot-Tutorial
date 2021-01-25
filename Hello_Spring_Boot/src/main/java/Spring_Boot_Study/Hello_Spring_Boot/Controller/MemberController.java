package Spring_Boot_Study.Hello_Spring_Boot.Controller;

import Spring_Boot_Study.Hello_Spring_Boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // new MemberService()로 안해서 이걸 불러올때마다 생성 안하고 공유해서 사용
    // 스프링 컨테이너에 등록해서 사용(아래 @autowired)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
