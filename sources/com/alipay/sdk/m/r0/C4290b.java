package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.q0.InterfaceC4284a;
import java.util.Objects;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.r0.b */
/* loaded from: classes12.dex */
public class C4290b {
    public static String e = "OpenDeviceId library";
    public static boolean f;
    public InterfaceC4284a b;
    public ServiceConnection c;
    public Context a = null;
    public InterfaceC4292b d = null;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.r0.b$a */
    /* loaded from: classes12.dex */
    public class ServiceConnectionC4291a implements ServiceConnection {
        public ServiceConnectionC4291a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C4290b.this.b = InterfaceC4284a.AbstractBinderC4285a.a(iBinder);
            if (C4290b.this.d != null) {
                C4290b.this.d.a("Deviceid Service Connected", C4290b.this);
            }
            C4290b.this.c("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C4290b.this.b = null;
            C4290b.this.c("Service onServiceDisconnected");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.r0.b$b */
    /* loaded from: classes12.dex */
    public interface InterfaceC4292b<T> {
        void a(T t, C4290b c4290b);
    }

    public String b() {
        if (this.a != null) {
            try {
                InterfaceC4284a interfaceC4284a = this.b;
                if (interfaceC4284a != null) {
                    return interfaceC4284a.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public String c() {
        if (this.a != null) {
            try {
                InterfaceC4284a interfaceC4284a = this.b;
                if (interfaceC4284a != null) {
                    return interfaceC4284a.b();
                }
                return null;
            } catch (RemoteException e2) {
                b("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                b("getUDID error, Exception!");
                e3.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public String d() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            c("liufeng, getVAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    InterfaceC4284a interfaceC4284a = this.b;
                    if (interfaceC4284a != null) {
                        return interfaceC4284a.b(packageName);
                    }
                    return null;
                } catch (RemoteException e2) {
                    b("getVAID error, RemoteException!");
                    e2.printStackTrace();
                    return null;
                }
            }
            c("input package is null!");
            return null;
        }
        c("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public boolean e() {
        try {
            if (this.b != null) {
                c("Device support opendeviceid");
                return this.b.c();
            }
            return false;
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.c);
            c("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.b = null;
    }

    public int a(Context context, InterfaceC4292b<String> interfaceC4292b) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.a = context;
        this.d = interfaceC4292b;
        this.c = new ServiceConnectionC4291a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            c("bindService Successful!");
            return 1;
        }
        c("bindService Failed!");
        return -1;
    }

    private void b(String str) {
        if (f) {
            Log.e(e, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (f) {
            Log.i(e, str);
        }
    }

    public String a() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            c("liufeng, getAAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    InterfaceC4284a interfaceC4284a = this.b;
                    if (interfaceC4284a != null) {
                        String a = interfaceC4284a.a(packageName);
                        return ((a == null || "".equals(a)) && this.b.c(packageName)) ? this.b.a(packageName) : a;
                    }
                    return null;
                } catch (RemoteException unused) {
                    b("getAAID error, RemoteException!");
                    return null;
                }
            }
            c("input package is null!");
            return null;
        }
        c("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f = z;
    }
}
