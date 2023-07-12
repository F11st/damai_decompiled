package com.taobao.weex.bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Invoker {
    Type[] getParameterTypes();

    Object invoke(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException;

    boolean isRunOnUIThread();
}
