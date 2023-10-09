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
public class HouseholdControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.HouseholdService.*(..)) && args(id)")
    public void beforeGettingHouseholdById(JoinPoint joinPoint, Integer id) {
        log.trace("Before household method:" + joinPoint.getSignature());
        log.trace("Getting household by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.HouseholdService.*(..))")
    public void afterHousehold(JoinPoint joinPoint) {
        log.trace("After household method:" + joinPoint.getSignature());
    }



}
