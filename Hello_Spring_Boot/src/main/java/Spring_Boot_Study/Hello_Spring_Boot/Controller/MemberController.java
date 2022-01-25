package Spring_Boot_Study.Hello_Spring_Boot.Controller;

import Spring_Boot_Study.Hello_Spring_Boot.domain.Member;
import Spring_Boot_Study.Hello_Spring_Boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // new MemberService()로 안해서 이걸 불러올때마다 생성 안하고 공유해서 사용
    // 스프링 컨테이너에 등록해서 사용(아래 @autowired)
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("test: " + form.getTest());
        memberService.join(member);

        // 다시 홈화면으로 보냄
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
