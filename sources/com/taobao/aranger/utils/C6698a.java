package com.taobao.aranger.utils;

import android.content.Context;
import android.util.Pair;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.annotation.parameter.WeakRef;
import com.taobao.aranger.annotation.parameter.inout;
import com.taobao.aranger.annotation.parameter.out;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.core.handler.invoc.CallbackInvocationHandler;
import com.taobao.aranger.core.ipc.provider.ClientServiceProvider;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import tb.go2;

/* compiled from: Taobao */
/* renamed from: com.taobao.aranger.utils.a */
/* loaded from: classes11.dex */
public class C6698a {
    public static Object[] a(ParameterWrapper[] parameterWrapperArr, List<Integer> list) throws IPCException {
        if (parameterWrapperArr == null) {
            return new Object[0];
        }
        int length = parameterWrapperArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            ParameterWrapper parameterWrapper = parameterWrapperArr[i];
            if (parameterWrapper == null) {
                objArr[i] = null;
            } else {
                Class<?> a = C6702d.e().a(parameterWrapper);
                if (a != null && a.isInterface() && a.getAnnotation(Callback.class) != null) {
                    String[] split = parameterWrapper.getTimeStamp().split(";");
                    String str = split[0];
                    objArr[i] = Proxy.newProxyInstance(a.getClassLoader(), new Class[]{a}, new CallbackInvocationHandler(parameterWrapper.getClientServiceBinder(), str, Integer.parseInt(split[1])));
                    IPCRecycle.b().d(parameterWrapper.getClientServiceBinder(), objArr[i], str);
                } else if (a != null && Context.class.isAssignableFrom(a)) {
                    objArr[i] = ARanger.getContext();
                } else {
                    if (parameterWrapper.getFlowFlag() != 0) {
                        list.add(Integer.valueOf(i));
                    }
                    objArr[i] = a != null ? parameterWrapper.getData() : null;
                }
            }
        }
        return objArr;
    }

    public static ParameterWrapper[] b(Method method, Object[] objArr) {
        if (objArr == null) {
            return new ParameterWrapper[0];
        }
        ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[objArr.length];
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < objArr.length; i++) {
            if (parameterTypes[i] != null && parameterTypes[i].isInterface() && parameterTypes[i].getAnnotation(Callback.class) != null) {
                Object obj = objArr[i];
                String a = go2.a();
                if (obj != null) {
                    ParameterWrapper clientServiceBinder = ParameterWrapper.obtain().setParameterName(parameterTypes[i].getName()).setClientServiceBinder(ClientServiceProvider.getClientService());
                    parameterWrapperArr[i] = clientServiceBinder.setTimeStamp(a + ";" + obj.hashCode());
                    CallbackManager.e().c(a, obj, TypeUtils.arrayContainsAnnotation(parameterAnnotations[i], WeakRef.class));
                } else {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(parameterTypes[i].getName());
                }
            } else if (objArr[i] instanceof Context) {
                parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(Context.class.getName());
            } else {
                boolean arrayContainsAnnotation = TypeUtils.arrayContainsAnnotation(parameterAnnotations[i], out.class);
                boolean arrayContainsAnnotation2 = TypeUtils.arrayContainsAnnotation(parameterAnnotations[i], inout.class);
                if (!arrayContainsAnnotation && !arrayContainsAnnotation2) {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(parameterTypes[i].getName()).setData(objArr[i]);
                } else if (arrayContainsAnnotation2) {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(parameterTypes[i].getName()).setFlowFlag(2).setData(objArr[i]);
                } else {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(parameterTypes[i].getName()).setFlowFlag(1).setData(objArr[i]);
                }
            }
        }
        return parameterWrapperArr;
    }

    public static ParameterWrapper[] c(Pair<Class<?>, Object>[] pairArr) throws IPCException {
        if (pairArr == null) {
            return new ParameterWrapper[0];
        }
        ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[pairArr.length];
        for (int i = 0; i < pairArr.length; i++) {
            if (pairArr[i] != null && pairArr[i].first != null) {
                Class cls = (Class) pairArr[i].first;
                Object obj = pairArr[i].second;
                if (obj != null && !cls.isAssignableFrom(obj.getClass())) {
                    throw new IPCException(41, "the parameter object " + obj.getClass().getName() + " is not the instance of the " + cls.getName() + ", please check if you Pair's value are correct!");
                }
                if (cls.isInterface() && cls.getAnnotation(Callback.class) != null) {
                    String a = go2.a();
                    if (obj != null) {
                        ParameterWrapper clientServiceBinder = ParameterWrapper.obtain().setParameterName(cls.getName()).setClientServiceBinder(ClientServiceProvider.getClientService());
                        parameterWrapperArr[i] = clientServiceBinder.setTimeStamp(a + ";" + obj.hashCode());
                        CallbackManager.e().c(a, obj, false);
                    } else {
                        parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(cls.getName());
                    }
                } else if (Context.class.isAssignableFrom(cls)) {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(Context.class.getName());
                } else if (obj != null) {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(cls.getName()).setData(obj);
                } else {
                    parameterWrapperArr[i] = ParameterWrapper.obtain().setParameterName(cls.getName());
                }
            } else {
                throw new IPCException(36, "the Pair and parameter class can't not be null!");
            }
        }
        return parameterWrapperArr;
    }
}
