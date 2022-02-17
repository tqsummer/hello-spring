package com.study.hello.spring.basic.demo.aop;

import com.study.hello.spring.basic.demo.annotation.Hello;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: fangxiangqian
 * @Date: 2021/12/2
 */
@Component
public class HelloBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {
    private final Set<Class<? extends Annotation>> helloAnnotationTypes = new LinkedHashSet<>(4);

    private AopProxyFactory aopProxyFactory;

    private BeanFactory beanFactory;

    public HelloBeanPostProcessor() {
        this.helloAnnotationTypes.add(Hello.class);
        this.aopProxyFactory = new DefaultAopProxyFactory();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!"helloAopService".equals(beanName)) {
            return bean;
        }
        // 遍历targetClass中的所有Field
        ReflectionUtils.doWithLocalFields(bean.getClass(), field -> {
            // field上是否存在@Hello
            MergedAnnotation<?> ann = findHelloAnnotation(field);
            if (ann != null) {
                Object target = beanFactory.getBean(field.getName());
                if (target == null) {
                    return;
                }
                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setTarget(target);
                advisedSupport.addAdvice(new MethodBeforeAdvice() {

                    @Override
                    public void before(Method method, Object[] args, Object target) throws Throwable {
                        System.out.println("before");
                    }
                });
                advisedSupport.addAdvice(new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        System.out.println("invoke before");
                        Object object = invocation.proceed();
                        System.out.println("invoke after");
                        return object;
                    }
                });
                AopProxy aopProxy = aopProxyFactory.createAopProxy(advisedSupport);
                ReflectionUtils.makeAccessible(field);
                field.set(bean, aopProxy.getProxy());
            }
        });

        return bean;
    }

    @Nullable
    private MergedAnnotation<?> findHelloAnnotation(AccessibleObject ao) {
        MergedAnnotations annotations = MergedAnnotations.from(ao);
        for (Class<? extends Annotation> type : this.helloAnnotationTypes) {
            MergedAnnotation<?> annotation = annotations.get(type);
            if (annotation.isPresent()) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
