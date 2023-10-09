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
public class UserControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.UserService.*(..)) && args(id)")
    public void beforeGettingUserById(JoinPoint joinPoint, Integer id) {
        log.trace("Before user method:" + joinPoint.getSignature());
        log.trace("Getting user by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.UserService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.trace("After user method:" + joinPoint.getSignature());
    }

}
