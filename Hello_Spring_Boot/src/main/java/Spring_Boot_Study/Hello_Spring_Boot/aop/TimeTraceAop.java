package Spring_Boot_Study.Hello_Spring_Boot.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


// aop 사용하기 위해서는 aspect 적어야함
@Aspect
@Component
public class TimeTraceAop {

    // 어디에 적용할지 타겟팅
    // 'Hello_Spring_Boot' 패키지 내에 모두 적용하도록 설정
    @Around("execution(* Spring_Boot_Study.Hello_Spring_Boot..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs +
                    "ms");
        }
    }

}
