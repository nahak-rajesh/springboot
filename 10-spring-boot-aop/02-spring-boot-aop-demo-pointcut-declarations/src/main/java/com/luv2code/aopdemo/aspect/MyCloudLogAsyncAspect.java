package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-100)
public class MyCloudLogAsyncAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetters()") // reusing the pointcut declaration and applying with another advice
    public void logToCloudAsync() {
        System.out.println("\n=========>>> Logging to Cloud in async fashion : order : 1");
    }
}
