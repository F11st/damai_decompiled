package com.taobao.monitor.impl.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import tb.e30;
import tb.ho2;
import tb.jd0;
import tb.lu0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class b extends Observable implements InvocationHandler {
    private final Object a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Object obj) {
        this.a = obj;
    }

    private void a() {
        StackTraceElement[] stackTrace;
        try {
            Throwable th = new Throwable();
            Thread currentThread = Thread.currentThread();
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append("\tat " + stackTraceElement);
            }
            e30.a("ActivityManagerProxy", currentThread.getName(), sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().contains("startActivity")) {
            lu0.m = ho2.a();
            if (jd0.m) {
                a();
            }
        }
        try {
            return method.invoke(this.a, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException != null && (targetException instanceof IllegalArgumentException) && method.getName().equals("reportSizeConfigurations") && jd0.h) {
                setChanged();
                notifyObservers(targetException);
                return null;
            } else if (targetException != null && method.getName().equals("isTopOfTask") && (targetException instanceof IllegalArgumentException) && jd0.h) {
                return Boolean.FALSE;
            } else {
                throw targetException;
            }
        }
    }
}
