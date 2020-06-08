package com.william.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 用于记录了日志的工具类，提供了记录日志的公共方法
 */
@Component("logger")
@Aspect //表示当前类为一个切面类
public class Logger {

    @Pointcut("execution(* com.william.service.impl.*.*(..))")
    public void ptl(){}
    /**
     *  前置通知
     */
    @Before("ptl()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法执行了。。。");

    }

    /**
     *  后置通知
     */
    @AfterReturning("ptl()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法执行了。。。");

    }



    /**
     *  异常通知
     */
    @AfterThrowing("ptl()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法执行了。。。");

    }


    /**
     *  最终通知
     */
    @After("ptl()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法执行了。。。");

    }

    /**
     * 环绕通知
     *问题：
     *      当我们配置了环绕通知以后，切入点方法没有执行，而环绕通知方法执行了
     *分析：
     *      通过对比动态代理中的环绕通知代码，发现这个动态代理中的环绕通知有明确的切入点方法调用，而我们的代码中没有
     *解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该接口的实现类供我们使用。
     *
     *Spring中的环绕通知：
     *      它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     *
     */
    @Around("ptl()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){

        Object returnValue = null;
        Object[] args = pjp.getArgs();//得到方法执行时所需的参数
        try {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法执行了。。。前置");

            returnValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("环绕通知Logger类中的aroundPrintLog方法执行了。。。后置");

            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法执行了。。。异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知Logger类中的aroundPrintLog方法执行了。。。最终");
        }
    }
}
