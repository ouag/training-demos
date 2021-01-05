package com.ouag.poc.aopparentdemo.aop;

import com.ouag.poc.aopparentdemo.advices.DemoAdvice;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Configuration
public class LoggingAspect {

    @Autowired
    private ApplicationContext context;

    @After(value = "execution(* com.ouag.poc.aopparentdemo.services.IRegularService.*(..))")
    public void loggingBeforeBusinessAction(JoinPoint jp) {
        log.info("tracked with execution");
        String notif = exractNotification(jp);
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        //Stream.of(method.getAnnotation(TrackThat.class).advices()).map(beanName -> (DemoAdvice) context.getBean(beanName))
         //       .forEach(a -> a.process(notif));
    }

    @Around(value = "@annotation(com.ouag.poc.aopparentdemo.aop.TrackThat)")
    public void loggingWithAnnotation(JoinPoint jp) {
        log.info("tracked with annotation");
        String notif = exractNotification(jp);
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        Stream.of(method.getAnnotation(TrackThat.class).advices()).map(beanName -> (DemoAdvice) context.getBean(beanName))
                .forEach(a -> a.process(notif));
    }

    private String exractNotification(JoinPoint jp) {
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class[] parameterTypes = method.getParameterTypes();
        Object[] args = jp.getArgs();

        int i = 0;
        for (Annotation[] annotations : parameterAnnotations) {
            Class parameterType = parameterTypes[i];
            Object parameterValue = args[i];
            i++;

            for (Annotation annotation : annotations) {
                if (annotation instanceof NotificationField) {
                    //NotificationField myAnnotation = (NotificationField) annotation;
                    //log.info("param: {}" , parameterType.getName());
                    //log.info("value: {}" , parameterValue);`
                    return (String) parameterValue;
                }
            }
        }
      throw new RuntimeException("Notification not found ");
    }


}
