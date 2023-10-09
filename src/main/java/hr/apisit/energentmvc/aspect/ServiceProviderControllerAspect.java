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
public class ServiceProviderControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.ServiceProviderService.*(..)) && args(id)")
    public void beforeGettingServiceProviderById(JoinPoint joinPoint, Integer id) {
        log.trace("Before service provider method:" + joinPoint.getSignature());
        log.trace("Getting service provider by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.ServiceProviderService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.trace("After service provider method:" + joinPoint.getSignature());
    }


}
