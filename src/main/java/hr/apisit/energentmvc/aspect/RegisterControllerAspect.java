package hr.apisit.energentmvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RegisterControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.RegisterService.*(..))")
    public void beforeGettingUsers(JoinPoint joinPoint) {
        log.trace("Before register method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.RegisterService.*(..))")
    public void afterRegister(JoinPoint joinPoint) {
        log.trace("After register method:" + joinPoint.getSignature());
    }



}
