package com.nansha.multisourcedemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
public class SimpleReadAspect {

    @Autowired
    ManagementCentre managementCentre;

    @Around("@annotation(SimpleReadAnnotation)")
    public List<Map<String, Object>> readAnnotationMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("getting to the simpleReadAnnotation");
        Object[] argv = joinPoint.getArgs();
        argv[0] = managementCentre.getSlaveDataSource();
        return (List<Map<String, Object>>) joinPoint.proceed(argv);
    }
}
