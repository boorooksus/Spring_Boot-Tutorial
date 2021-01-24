package Spring_Boot_Study.Hello_Spring_Boot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data", "hello!!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
    // ResponseBody: Http에서 Body에 Data를 직접 넣겠다는 뜻(html 아님 http임)

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello; // 객체를 리턴
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
