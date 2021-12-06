package com.codegym.bookloanapp.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    //aspect ->advice -> pointcut -> joinpoint
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private static int action;

    //    Thực hiện ghi log tất cả các hành động khiến trạng thái sách của thư viện bị thay đổi.
    @AfterReturning("execution(* com.codegym.bookloanapp.service.BookService.save(..))")
    public void getBookLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        //String className= joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
        logger.info("[Log 1] -- Trạng thái sách thay đổi lúc " + LocalDateTime.now());
    }

    //Thực hiện ghi log số lượng người đã ghé thăm thư viện sách (tất cả các thao tác)
    @AfterReturning("execution(* com.codegym.bookloanapp.service.*.*(..))")
    public void getLibraryLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        action++;
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
        logger.info("[Log 2] -- Số lượng truy cập thư viện: " + action);
    }
}
