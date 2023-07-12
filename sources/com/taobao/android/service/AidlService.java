package com.taobao.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AidlService<I extends IInterface, Stub extends Binder & IInterface> extends Service {
    private Binder a;

    private Binder a(Class<Stub> cls) {
        try {
            try {
                return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException unused) {
                throw new IllegalArgumentException(cls + " and its empty constructor must be both public.");
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                throw new RuntimeException(targetException);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Stub " + cls + " of service " + getClass() + " cannot be instantiated.", e2);
            }
        } catch (NoSuchMethodException unused2) {
            try {
                return cls.getDeclaredConstructor(getClass()).newInstance(this);
            } catch (NoSuchMethodException unused3) {
                throw new IllegalArgumentException(cls + " must be either standalone class or inner class of " + getClass() + ", and have a empty constructor.");
            }
        }
    }

    private static Type[] b(Class<?> cls) {
        while (cls != null) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (AidlService.class.equals(parameterizedType.getRawType())) {
                    return parameterizedType.getActualTypeArguments();
                }
            }
            cls = cls.getSuperclass();
        }
        throw new IllegalArgumentException();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Binder binder = this.a;
        if (binder != null) {
            return binder;
        }
        throw new IllegalStateException("AidlService is not initialized. Did you forget to call super.onCreate() in onCreate() method of AidlService derived class?");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Type[] b = b(getClass());
        if (b[0] instanceof Class) {
            if (b[1] instanceof Class) {
                Class cls = (Class) b[0];
                Class<Stub> cls2 = (Class) b[1];
                if (cls.isAssignableFrom(cls2)) {
                    this.a = a(cls2);
                    return;
                }
                throw new IllegalArgumentException(cls2 + " is not paired with " + cls);
            }
            throw new IllegalArgumentException(b[1] + " is not an AIDL Stub class");
        }
        throw new IllegalArgumentException(b[0] + " is not an AIDL interface");
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.w("AidlService", "Start operation is not allowed for AIDL service.");
        stopSelf(i2);
        return 2;
    }

    public String toString() {
        if (this.a != null) {
            return "AidlService[" + this.a.getInterfaceDescriptor() + jn1.ARRAY_END_STR;
        }
        return "AidlService[null]";
    }
}
