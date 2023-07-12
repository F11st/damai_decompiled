package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.q0.a;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    public static String e = "OpenDeviceId library";
    public static boolean f;
    public com.alipay.sdk.m.q0.a b;
    public ServiceConnection c;
    public Context a = null;
    public InterfaceC0199b d = null;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.b = a.AbstractBinderC0197a.a(iBinder);
            if (b.this.d != null) {
                b.this.d.a("Deviceid Service Connected", b.this);
            }
            b.this.c("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.b = null;
            b.this.c("Service onServiceDisconnected");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.r0.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0199b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.a != null) {
            try {
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar != null) {
                    return aVar.a();
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
                com.alipay.sdk.m.q0.a aVar = this.b;
                if (aVar != null) {
                    return aVar.b();
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
                    com.alipay.sdk.m.q0.a aVar = this.b;
                    if (aVar != null) {
                        return aVar.b(packageName);
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

    public int a(Context context, InterfaceC0199b<String> interfaceC0199b) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.a = context;
        this.d = interfaceC0199b;
        this.c = new a();
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
                    com.alipay.sdk.m.q0.a aVar = this.b;
                    if (aVar != null) {
                        String a2 = aVar.a(packageName);
                        return ((a2 == null || "".equals(a2)) && this.b.c(packageName)) ? this.b.a(packageName) : a2;
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
