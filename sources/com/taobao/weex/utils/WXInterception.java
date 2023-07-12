package com.taobao.weex.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXInterception {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private interface Intercepted {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class InterceptionHandler<T> implements InvocationHandler {
        private T a;

        protected T a() {
            return this.a;
        }

        void b(T t) {
            this.a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return method.invoke(a(), objArr);
            } catch (IllegalAccessException e) {
                WXLogUtils.e("", e);
                return null;
            } catch (IllegalArgumentException e2) {
                WXLogUtils.e("", e2);
                return null;
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        }
    }

    private WXInterception() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T proxy(Object obj, Class<T> cls, InterceptionHandler<T> interceptionHandler) throws IllegalArgumentException {
        if (obj instanceof Intercepted) {
            return obj;
        }
        interceptionHandler.b(obj);
        return (T) Proxy.newProxyInstance(WXInterception.class.getClassLoader(), new Class[]{cls, Intercepted.class}, interceptionHandler);
    }

    public static <T> T proxy(Object obj, InterceptionHandler<T> interceptionHandler, Class<?>... clsArr) throws IllegalArgumentException {
        interceptionHandler.b(obj);
        return (T) Proxy.newProxyInstance(WXInterception.class.getClassLoader(), clsArr, interceptionHandler);
    }
}
