package Spring_Boot_Study.Hello_Spring_Boot.Controller;

public class MemberForm {
    // 여기 name과 createMemberFrom.html에서 form의 name이 매칭되어 들어옴
    private String name;

//    private String test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getTest() {
//        return test;
//    }
//
//    public void setTest(String test) {
//        this.test = test;
//    }

}
