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
public class OwnerControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.OwnerService.*(..)) && args(id)")
    public void beforeGettingFilmById(JoinPoint joinPoint, Integer id) {
        log.trace("Before owner method:" + joinPoint.getSignature());
        log.trace("Getting owner by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.OwnerService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.trace("After owner method:" + joinPoint.getSignature());
    }



}
