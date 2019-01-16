package com.itheima.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect //表名此类是一个切面类
public class Logger {


    //定义切入点,方法名称就是切入点id
    @Pointcut("execution(* com.itheima.accountService.impl.AccountServiceImpl.transfer(..))")
    public void logPointCut(){};

    //.使用spring  aop完成日志记录的功能
    //	如果转账成功:xxxx年-xx月--xx日 xxx给xxx转账xxx元,转账成功 后置通知
    //	如果转账成功:xxxx年-xx月--xx日 xxx给xxx转账xxx元,转账失败  异常通知

    // 后置通知
//    @Around("logPointCut()")

    public void afterReturningPrintLog(JoinPoint joinPoint) {
        System.out.println("后置=========");

        Object[] args = joinPoint.getArgs();
        String s = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
        System.out.println(s + args[0] + "给" + args[1] + "转账" + args[2] + "元,转账成功");
    }


    //异常通知
//    @Around("logPointCut()")

    public void afterThrowingPrintLog(JoinPoint joinPoint) {
        System.out.println("异常=========");


        String s = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
        System.out.println(s + joinPoint.getArgs()[0] + "给" + joinPoint.getArgs()[1] + "转账" + joinPoint.getArgs()[2] + "元,转账失败");

    }


    //使用环绕通知
    @Around("logPointCut()")
    public Object printLog(ProceedingJoinPoint pjp) {
        Object[] args = null;
        Object value = null;
        try {
            args = pjp.getArgs();
            value = pjp.proceed();
            String s = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
            System.out.println(s + args[0] + "给" + args[1] + "转账" + args[2] + "元,转账成功");

        } catch (Throwable throwable) {

            throwable.printStackTrace();
            String s = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
            System.out.println(s + args[0] + "给" + args[1] + "转账" + args[2] + "元,转账失败");

            //此步骤很重要......
            throw new RuntimeException(throwable);

        }
        return value;
    }


}
