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
public class AddressControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.AddressService.*(..)) && args(id)")
    public void beforeGettingAddressById(JoinPoint joinPoint, Integer id) {
        log.trace("Before address method:" + joinPoint.getSignature());
        log.trace("Getting address by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.AddressService.*(..))")
    public void afterAddress(JoinPoint joinPoint) {
        log.trace("After address method:" + joinPoint.getSignature());
    }



}
