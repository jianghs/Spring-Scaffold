package me.jianghs.springscaffold.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @className: LogAspect
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/18 14:52
 * @version: 1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * me.jianghs.springscaffold.api..*Controller.*(..))")
    public void requestLog(){};

    @Before("requestLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //打印当前的请求路径
        log.info("RequestMapping:[{}]",request.getRequestURI());
        //打印请求参数，如果需要打印其他的信息可以到request中去拿
        log.info("RequestParam:{}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "response", pointcut = "requestLog()")
    public void doAfterRunning(Object response) {
        //打印返回值信息
        log.info("Response:[{}]",response );
        //打印请求耗时
        log.info("Request spend times : [{}ms]",System.currentTimeMillis()-startTime.get());
    }
}
