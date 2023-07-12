package com.taobao.android.service;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.rc1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LocalAidlServices {
    private static final Map<String, ServiceRecord> a = new HashMap();
    private static final HashMap<ServiceConnection, String> b = new HashMap<>();
    private static final Method c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ServiceRecord extends CopyOnWriteArrayList<ServiceConnection> {
        private static final long serialVersionUID = 1;

        /* renamed from: app  reason: collision with root package name */
        final Application f1031app;
        final IBinder binder;
        final Intent intent;
        final Service service;

        ServiceRecord(Application application, Intent intent, IBinder iBinder, Service service) {
            this.f1031app = application;
            this.intent = intent;
            this.binder = iBinder;
            this.service = service;
        }
    }

    static {
        Method method = null;
        try {
            method = Service.class.getDeclaredMethod("attach", Context.class, Class.forName("android.app.ActivityThread"), String.class, IBinder.class, Application.class, Object.class);
            method.setAccessible(true);
        } catch (ClassNotFoundException e) {
            Log.e("LocalSvc", "Incompatible ROM", e);
        } catch (NoSuchMethodException e2) {
            Log.e("LocalSvc", "Incompatible ROM", e2);
        }
        c = method;
    }

    private static void a(Context context, Class<? extends Service> cls, Service service, Application application) {
        Method method = c;
        if (method == null) {
            return;
        }
        try {
            method.invoke(service, context, null, cls.getName(), null, application, null);
        } catch (IllegalAccessException e) {
            rc1.b("LocalSvc", "Unexpected exception when attaching service.", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getTargetException());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, Intent intent, ServiceConnection serviceConnection) throws ClassNotFoundException {
        ComponentName component = intent.getComponent();
        if (component == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null) {
                return false;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            component = new ComponentName(serviceInfo.packageName, serviceInfo.name.intern());
        }
        Map<String, ServiceRecord> map = a;
        ServiceRecord serviceRecord = map.get(component.getClassName());
        if (serviceRecord == null) {
            serviceRecord = c(context, intent, component);
            if (serviceRecord == null) {
                return false;
            }
            map.put(component.getClassName(), serviceRecord);
        }
        serviceRecord.add(serviceConnection);
        b.put(serviceConnection, component.getClassName());
        try {
            long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
            serviceConnection.onServiceConnected(component, serviceRecord.binder);
            f(threadCpuTimeNanos + 2000000, serviceConnection, ".onServiceConnected()");
            return true;
        } catch (RuntimeException e) {
            rc1.d("LocalSvc", serviceConnection + ".onServiceConnected()", e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.taobao.android.service.LocalAidlServices.ServiceRecord c(android.content.Context r13, android.content.Intent r14, android.content.ComponentName r15) throws java.lang.ClassNotFoundException {
        /*
            java.lang.String r0 = ".onDestroy()"
            java.lang.String r1 = ".onBind()"
            java.lang.String r2 = ".onCreate()"
            java.lang.String r3 = "LocalSvc"
            java.lang.String r4 = r15.getClassName()
            java.lang.Class r4 = e(r13, r4)
            r5 = 0
            if (r4 != 0) goto L14
            return r5
        L14:
            java.lang.Class<com.taobao.android.service.AidlService> r6 = com.taobao.android.service.AidlService.class
            boolean r6 = r6.isAssignableFrom(r4)
            if (r6 != 0) goto L1d
            return r5
        L1d:
            long r6 = android.os.Debug.threadCpuTimeNanos()     // Catch: java.lang.IllegalAccessException -> Lc1 java.lang.InstantiationException -> Le0
            java.lang.Object r8 = r4.newInstance()     // Catch: java.lang.IllegalAccessException -> Lc1 java.lang.InstantiationException -> Le0
            android.app.Service r8 = (android.app.Service) r8     // Catch: java.lang.IllegalAccessException -> Lc1 java.lang.InstantiationException -> Le0
            r9 = 2000000(0x1e8480, double:9.881313E-318)
            long r6 = r6 + r9
            java.lang.String r11 = r4.getName()     // Catch: java.lang.IllegalAccessException -> Lc1 java.lang.InstantiationException -> Le0
            java.lang.String r12 = "()"
            f(r6, r11, r12)     // Catch: java.lang.IllegalAccessException -> Lc1 java.lang.InstantiationException -> Le0
            android.app.Application r15 = d(r13)
            a(r13, r4, r8, r15)
            r6 = 5000000(0x4c4b40, double:2.470328E-317)
            long r11 = android.os.Debug.threadCpuTimeNanos()     // Catch: java.lang.RuntimeException -> L4a
            r8.onCreate()     // Catch: java.lang.RuntimeException -> L4a
            long r11 = r11 + r6
            f(r11, r8, r2)     // Catch: java.lang.RuntimeException -> L4a
            goto L5d
        L4a:
            r13 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            tb.rc1.d(r3, r2, r13)
        L5d:
            long r11 = android.os.Debug.threadCpuTimeNanos()     // Catch: java.lang.RuntimeException -> L82
            android.os.IBinder r13 = r8.onBind(r14)     // Catch: java.lang.RuntimeException -> L82
            long r11 = r11 + r9
            f(r11, r8, r1)     // Catch: java.lang.RuntimeException -> L80
            if (r13 != 0) goto L96
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L80
            r2.<init>()     // Catch: java.lang.RuntimeException -> L80
            r2.append(r8)     // Catch: java.lang.RuntimeException -> L80
            java.lang.String r4 = ".onBind() should never return null."
            r2.append(r4)     // Catch: java.lang.RuntimeException -> L80
            java.lang.String r2 = r2.toString()     // Catch: java.lang.RuntimeException -> L80
            android.util.Log.e(r3, r2)     // Catch: java.lang.RuntimeException -> L80
            goto L96
        L80:
            r2 = move-exception
            goto L84
        L82:
            r2 = move-exception
            r13 = r5
        L84:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            tb.rc1.d(r3, r1, r2)
        L96:
            if (r13 != 0) goto Lb8
            long r13 = android.os.Debug.threadCpuTimeNanos()     // Catch: java.lang.RuntimeException -> La4
            r8.onDestroy()     // Catch: java.lang.RuntimeException -> La4
            long r13 = r13 + r6
            f(r13, r8, r0)     // Catch: java.lang.RuntimeException -> La4
            goto Lb7
        La4:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r8)
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            tb.rc1.d(r3, r14, r13)
        Lb7:
            return r5
        Lb8:
            g(r15, r8)
            com.taobao.android.service.LocalAidlServices$ServiceRecord r0 = new com.taobao.android.service.LocalAidlServices$ServiceRecord
            r0.<init>(r15, r14, r13, r8)
            return r0
        Lc1:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Constructor of "
            r14.append(r0)
            java.lang.String r15 = r15.getClassName()
            r14.append(r15)
            java.lang.String r15 = " is inaccessible"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            tb.rc1.d(r3, r14, r13)
            return r5
        Le0:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Failed to instantiate "
            r14.append(r0)
            java.lang.String r15 = r15.getClassName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            tb.rc1.d(r3, r14, r13)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.service.LocalAidlServices.c(android.content.Context, android.content.Intent, android.content.ComponentName):com.taobao.android.service.LocalAidlServices$ServiceRecord");
    }

    private static Application d(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getApplication();
        }
        if (context instanceof Service) {
            return ((Service) context).getApplication();
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        rc1.c("LocalSvc", "Cannot discover application from context " + context);
        return null;
    }

    private static Class<? extends Service> e(Context context, String str) throws ClassNotFoundException {
        try {
            return (Services.c() != null ? Services.c() : context.getClassLoader()).loadClass(str);
        } catch (ClassCastException unused) {
            rc1.a("LocalSvc", "Not a Service derived class: " + str);
            return null;
        }
    }

    private static void f(long j, Object obj, String str) {
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos() - j;
        if (threadCpuTimeNanos <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.toString());
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(" exceed the deadline ");
        sb.append(threadCpuTimeNanos / 1000000);
        sb.append("ms (thread CPU time)");
        Log.w("LocalSvc", sb.toString());
    }

    @TargetApi(14)
    private static void g(Application application, ComponentCallbacks componentCallbacks) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        application.registerComponentCallbacks(componentCallbacks);
    }

    public static boolean h(Context context, ServiceConnection serviceConnection) {
        ServiceRecord serviceRecord;
        String remove = b.remove(serviceConnection);
        if (remove == null || (serviceRecord = a.get(remove)) == null) {
            return false;
        }
        if (!serviceRecord.remove(serviceConnection)) {
            rc1.a("LocalSvc", "Internal inconsistency, please report this to the corresponding dev team: " + serviceConnection + " @ " + remove);
        }
        try {
            serviceConnection.onServiceDisconnected(new ComponentName(context.getPackageName(), serviceRecord.service.getClass().getName()));
        } catch (RuntimeException e) {
            rc1.d("LocalSvc", serviceConnection + ".onServiceDisconnected()", e);
        }
        if (serviceRecord.isEmpty()) {
            a.remove(remove);
            i(serviceRecord.f1031app, serviceRecord.service);
            try {
                serviceRecord.service.onUnbind(serviceRecord.intent);
            } catch (RuntimeException e2) {
                rc1.d("LocalSvc", serviceRecord.service + ".onUnbind()", e2);
            }
            try {
                serviceRecord.service.onDestroy();
                return true;
            } catch (RuntimeException e3) {
                rc1.d("LocalSvc", serviceRecord.service + ".onDestroy()", e3);
                return true;
            }
        }
        return true;
    }

    @TargetApi(14)
    private static void i(Application application, ComponentCallbacks componentCallbacks) {
        if (application == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        application.unregisterComponentCallbacks(componentCallbacks);
    }
}
