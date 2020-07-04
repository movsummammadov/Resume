package com.mycompany.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.mycompany.service.inter.UserServiceInter.getAllUser())")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : "+joinPoint.getSignature().getName());
        System.out.println("*********");
    }

    @After("execution(* com.mycompany.service.inter.UserServiceInter.getAllUser())")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : "+joinPoint.getSignature().getName());
        System.out.println("*********");
    }

    @AfterReturning(pointcut ="execution(* com.mycompany.service.inter.UserServiceInter.getAllUser())",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : "+joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("*********");
    }

    @AfterThrowing(value = "execution(* com.mycompany.service.inter.UserServiceInter.getAllUser())",
            throwing = "error")
    public void lodAfterThrowing(JoinPoint joinPoint, Throwable error){
        System.out.println("lodAfterThrowing() is running!");
        System.out.println("hijacked : "+joinPoint.getSignature().getName());
        System.out.println("Exception :" + error);
        System.out.println("*********");
    }

    @Around("execution(* com.mycompany.service.inter.UserServiceInter.getAllUser())")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("logAround() is running!");
        System.out.println("hijacked method : "+joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : "+ Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        Object res = joinPoint.proceed();
        System.out.println("Around before is running!");
        System.out.println("*********");
        return res;
    }
}
