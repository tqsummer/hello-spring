package com.study.hello.spring.basic.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: fangxiangqian
 * @Date: 2021/11/21
 */
public class JdkProxyDemo {
    public static void main(String[] args) {
        Interceptor interceptor = new HelloInterceptor();
        Set<Interceptor> set = new HashSet<>();
        set.add(interceptor);
        ProxyTargetInterface target = new ProxyTarget();
        ProxyFactory proxyFactory = new ProxyFactory();

        ProxyTargetInterface proxy = (ProxyTargetInterface) proxyFactory.getProxy(target,set);
        proxy.hello("123");
    }

    public static interface ProxyTargetInterface{
        public void hello(String msg);
    }

    public static class ProxyTarget implements ProxyTargetInterface{

        @Override
        public void hello(String msg) {
            System.out.println("hello : "+msg);
        }
    }

    public static class Invocation{
        private final Object target;
        private final Method method;
        private final Object[] args;

        public Invocation(Object target, Method method, Object[] args) {
            this.target = target;
            this.method = method;
            this.args = args;
        }

        public Object getTarget() {
            return target;
        }

        public Method getMethod() {
            return method;
        }

        public Object[] getArgs() {
            return args;
        }
        public Object proceed() throws InvocationTargetException, IllegalAccessException {
            return method.invoke(target, args);
        }

    }

    public static interface Interceptor{
        Object intercept(Invocation invocation) throws Throwable;
    }

    public static class HelloInterceptor implements Interceptor{

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
            System.out.println("Hello intercept :"+invocation.getMethod().getName());
            return invocation.proceed();
        }
    }

    public static class ProxyFactory{
        public Object getProxy(Object target, Set<Interceptor> interceptors){
            if(CollectionUtils.isEmpty(interceptors)){
                return target;
            }
            for(Interceptor interceptor:interceptors){
                target = getProxy(target,interceptor);
            }
            return target;
        }

        private Object getProxy(Object target,Interceptor interceptor){
            Class type = target.getClass();
            Class<?>[] interfaces = getAllInterfaces(type);
            if(interfaces.length ==1){
                //使用JDK动态代理
                    return Proxy.newProxyInstance(
                            type.getClassLoader(),
                            interfaces,
                            new ProxyInvocationHandler(target, interceptor));
            }else{
                //使用Cglib创建动态代理
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(type);
                enhancer.setCallback(new ProxyInvocationHandler(target, interceptor));// 设置回调
                return enhancer.create();
            }
        }

        private static Class<?>[] getAllInterfaces(Class<?> type) {
            Set<Class<?>> interfaces = new HashSet<>();
            while (type != null) {
                for (Class<?> c : type.getInterfaces()) {
                    interfaces.add(c);
                }
                type = type.getSuperclass();
            }
            return interfaces.toArray(new Class<?>[0]);
        }
    }

    public static class ProxyInvocationHandler implements InvocationHandler, MethodInterceptor {
        private final Object target;
        private final Interceptor interceptor;

        public ProxyInvocationHandler(Object target, Interceptor interceptor) {
            this.target = target;
            this.interceptor = interceptor;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(interceptor!=null){
                return interceptor.intercept(new Invocation(target,method,args));
            }
            return method.invoke(target,args);
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            return invoke(o,method,objects);
        }
    }
}
