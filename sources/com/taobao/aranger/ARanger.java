package com.taobao.aranger;

import android.app.ActivityThread;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.invoc.MethodInvocationHandler;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ServiceWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IProxyRecover;
import com.taobao.aranger.intf.ProcessStateListener;
import com.taobao.aranger.utils.CallbackManager;
import com.taobao.aranger.utils.IPCRecycle;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ReflectUtils;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.a;
import java.lang.reflect.Proxy;
import tb.go2;
import tb.qh;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ARanger {
    private static final String TAG = "ARanger";
    private static volatile Application sApplication;

    public static void connect(ComponentName componentName) throws IPCException {
        TypeUtils.validateComponentName(componentName);
        qh.b(IPCUtils.queryContentAuthorityFromProvider(componentName)).b();
    }

    @SafeVarargs
    public static <T> T create(@NonNull ComponentName componentName, @NonNull Class<T> cls, Pair<Class<?>, Object>... pairArr) throws IPCException {
        return (T) create(componentName, "", cls, pairArr);
    }

    @SafeVarargs
    private static <T> T createProxy(ComponentName componentName, String str, Class<T> cls, String str2, Pair<Class<?>, Object>... pairArr) throws IPCException {
        Uri queryContentAuthorityFromProvider = IPCUtils.queryContentAuthorityFromProvider(componentName);
        ServiceName serviceName = (ServiceName) cls.getAnnotation(ServiceName.class);
        ServiceWrapper serviceInterfaceClass = ServiceWrapper.obtain().setTimeStamp(go2.a()).setServiceInterfaceClass(cls);
        if (TextUtils.isEmpty(str)) {
            str = serviceName.value();
        }
        Call remoteProviderUri = Call.obtain().setVoid(true).setIsSameApp(sApplication.getPackageName().equals(componentName.getPackageName())).setServiceWrapper(serviceInterfaceClass.setServiceName(str).setType(!TextUtils.isEmpty(str2) ? 1 : 0)).setMethodWrapper(TextUtils.isEmpty(str2) ? MethodWrapper.obtain() : MethodWrapper.obtain().setMethodName(str2)).setParameterWrappers(a.c(pairArr)).setRemoteProviderUri(queryContentAuthorityFromProvider);
        qh.b(queryContentAuthorityFromProvider).f(remoteProviderUri);
        return (T) getProxy(remoteProviderUri);
    }

    @SafeVarargs
    private static <T> T createProxyByMethodName(ComponentName componentName, String str, Class<T> cls, String str2, Pair<Class<?>, Object>... pairArr) throws IPCException {
        validate(componentName, str, cls);
        return (T) createProxy(componentName, str, cls, str2, pairArr);
    }

    @SafeVarargs
    public static <T> T createSingleton(@NonNull ComponentName componentName, @NonNull Class<T> cls, Pair<Class<?>, Object>... pairArr) throws IPCException {
        return (T) createProxyByMethodName(componentName, "", cls, "getInstance", pairArr);
    }

    public static void debug(boolean z) {
        z01.f(!z);
    }

    public static Context getContext() {
        if (sApplication == null) {
            synchronized (ARanger.class) {
                if (sApplication == null) {
                    try {
                        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
                        if (currentActivityThread != null) {
                            sApplication = currentActivityThread.getApplication();
                        }
                    } catch (Exception e) {
                        z01.c(TAG, "[getContext][currentActivityThread]", e, new Object[0]);
                    }
                    if (sApplication == null) {
                        try {
                            sApplication = (Application) ReflectUtils.getHideMethod(ActivityThread.class, "getApplication", new Class[0]).invoke(ReflectUtils.getHideMethod(ActivityThread.class, "currentActivityThread", new Class[0]).invoke(ActivityThread.class, new Object[0]), new Object[0]);
                        } catch (Exception e2) {
                            z01.c(TAG, "[getContext][invoke]", e2, new Object[0]);
                        }
                    }
                    debug((sApplication.getApplicationInfo().flags & 2) != 0);
                }
            }
        }
        return sApplication;
    }

    private static <T> T getProxy(Call call) {
        ServiceWrapper serviceWrapper = call.getServiceWrapper();
        Uri remoteProviderUri = call.getRemoteProviderUri();
        T t = (T) Proxy.newProxyInstance(serviceWrapper.getServiceInterfaceClass().getClassLoader(), new Class[]{serviceWrapper.getServiceInterfaceClass()}, new MethodInvocationHandler(serviceWrapper, remoteProviderUri, call.isSameApp()));
        IPCRecycle.b().d(remoteProviderUri, t, serviceWrapper.getTimeStamp());
        return t;
    }

    public static void init(@NonNull Application application) {
        if (sApplication != null) {
            return;
        }
        sApplication = application;
        debug((sApplication.getApplicationInfo().flags & 2) != 0);
    }

    public static boolean isConnect(ComponentName componentName) {
        try {
            TypeUtils.validateComponentName(componentName);
            return IPCUtils.isProcessAlive(componentName);
        } catch (IPCException unused) {
            return false;
        }
    }

    public static void registerProcessStateListener(@NonNull ProcessStateListener processStateListener) {
        CallbackManager.e().f(processStateListener);
    }

    public static void removeProxyRecover() {
        CallbackManager.e().h();
    }

    public static void setProxyRecover(@NonNull IProxyRecover iProxyRecover) {
        CallbackManager.e().i(iProxyRecover);
    }

    public static void unRegisterProcessStateListener(@NonNull ProcessStateListener processStateListener) {
        CallbackManager.e().j(processStateListener);
    }

    private static void validate(ComponentName componentName, String str, Class cls) throws IPCException {
        TypeUtils.validateServiceInterface(str, cls);
        TypeUtils.validateComponentName(componentName);
    }

    @SafeVarargs
    public static <T> T create(@NonNull ComponentName componentName, @NonNull String str, @NonNull Class<T> cls, Pair<Class<?>, Object>... pairArr) throws IPCException {
        validate(componentName, str, cls);
        return (T) createProxy(componentName, str, cls, "", pairArr);
    }

    @SafeVarargs
    public static <T> T createSingleton(@NonNull ComponentName componentName, @NonNull String str, @NonNull Class<T> cls, Pair<Class<?>, Object>... pairArr) throws IPCException {
        return (T) createProxyByMethodName(componentName, str, cls, "getInstance", pairArr);
    }

    @SafeVarargs
    public static <T> T createSingleton(@NonNull ComponentName componentName, @NonNull Class<T> cls, @NonNull String str, Pair<Class<?>, Object>... pairArr) throws IPCException {
        return (T) createProxyByMethodName(componentName, "", cls, str, pairArr);
    }

    @SafeVarargs
    public static <T> T createSingleton(@NonNull ComponentName componentName, @NonNull String str, @NonNull Class<T> cls, @NonNull String str2, Pair<Class<?>, Object>... pairArr) throws IPCException {
        return (T) createProxyByMethodName(componentName, str, cls, str2, pairArr);
    }
}
