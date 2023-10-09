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
public class ContractControllerAspect {

    @Before(value = "execution(* hr.apisit.energentmvc.service.ContractService.*(..)) && args(id)")
    public void beforeGettingContractById(JoinPoint joinPoint, Integer id) {
        log.trace("Before contract method:" + joinPoint.getSignature());
        log.trace("Getting contract by id " + id);
    }

    @After(value = "execution(* hr.apisit.energentmvc.service.ContractService.*(..))")
    public void afterContract(JoinPoint joinPoint) {
        log.trace("After contract method:" + joinPoint.getSignature());
    }



}
