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
public class ServiceSPControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.ServiceSPService.*(..)) && args(id)")
    public void beforeGettingServiceSPById(JoinPoint joinPoint, Integer id) {
        log.trace("Before service method:" + joinPoint.getSignature());
        log.trace("Getting service by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.ServiceSPService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.trace("After service method:" + joinPoint.getSignature());
    }
}
