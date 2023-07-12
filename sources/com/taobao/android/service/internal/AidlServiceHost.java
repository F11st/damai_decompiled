package com.taobao.android.service.internal;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.util.Log;
import com.taobao.android.service.AidlService;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AidlServiceHost extends Service {
    private static final Field b;
    private final Map<String, AidlService<?, ?>> a;

    static {
        Field field;
        try {
            field = Service.class.getDeclaredField("mApplication");
            field.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        b = field;
    }

    public AidlServiceHost() {
        new HashMap();
        this.a = new HashMap();
    }

    private void a(Service service) {
        Field field = b;
        if (field != null) {
            try {
                field.set(service, getApplication());
            } catch (IllegalAccessException | IllegalArgumentException unused) {
            }
        }
    }

    private AidlService<?, ?> b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                return (AidlService) cls.newInstance();
            } catch (Exception e) {
                try {
                    Log.e("SvcHost", "Failed to instantiate service " + cls, e);
                    return null;
                } catch (ClassCastException unused) {
                    Log.e("SvcHost", "Resolved service class is not derived from Service: " + str);
                    return null;
                }
            }
        } catch (ClassNotFoundException unused2) {
            Log.e("SvcHost", "Resolved service class cannot be found: " + str);
            return null;
        }
    }

    private ComponentName c(Intent intent) {
        ResolveInfo resolveService = getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            return null;
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName c = c(intent);
        if (c == null) {
            Log.e("SvcHost", "No declared service found for " + intent);
            return false;
        }
        String className = c.getClassName();
        this.a.get(className);
        AidlService<?, ?> b2 = b(className);
        a(b2);
        try {
            b2.onCreate();
            try {
                serviceConnection.onServiceConnected(c, b2.onBind(intent));
                return true;
            } catch (RuntimeException e) {
                Log.w("SvcHost", "Failure sending service " + className + " to connection " + serviceConnection, e);
                return false;
            }
        } catch (RuntimeException e2) {
            Log.e("SvcHost", "Failure creating or binding service " + className, e2);
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
