package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import com.vivo.push.util.C7533z;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.b */
/* loaded from: classes11.dex */
public final class ServiceConnectionC7412b implements ServiceConnection {
    private static final Object a = new Object();
    private static Map<String, ServiceConnectionC7412b> b = new HashMap();
    private boolean c;
    private String d;
    private Context e;
    private volatile IPCInvoke g;
    private String i;
    private Handler j;
    private Object h = new Object();
    private AtomicInteger f = new AtomicInteger(1);

    private ServiceConnectionC7412b(Context context, String str) {
        this.d = null;
        this.j = null;
        this.e = context;
        this.i = str;
        this.j = new Handler(Looper.getMainLooper(), new C7439c(this));
        String b2 = C7527t.b(context);
        this.d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.i)) {
            this.c = C7533z.a(context, this.d) >= 1260;
            b();
            return;
        }
        Context context2 = this.e;
        C7523p.c(context2, "init error : push pkgname is " + this.d + " ; action is " + this.i);
        this.c = false;
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.e.unbindService(this);
        } catch (Exception e) {
            C7523p.a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        C7523p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            C7523p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            f();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.g = null;
        a(1);
    }

    public static ServiceConnectionC7412b a(Context context, String str) {
        ServiceConnectionC7412b serviceConnectionC7412b = b.get(str);
        if (serviceConnectionC7412b == null) {
            synchronized (a) {
                serviceConnectionC7412b = b.get(str);
                if (serviceConnectionC7412b == null) {
                    serviceConnectionC7412b = new ServiceConnectionC7412b(context, str);
                    b.put(str, serviceConnectionC7412b);
                }
            }
        }
        return serviceConnectionC7412b;
    }

    private void b() {
        int i = this.f.get();
        C7523p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i)));
        if (i == 4 || i == 2 || i == 3 || i == 5 || !this.c) {
            return;
        }
        a(2);
        if (!c()) {
            a(1);
            C7523p.a("AidlManager", "bind core service fail");
            return;
        }
        d();
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.d);
        try {
            return this.e.bindService(intent, this, 1);
        } catch (Exception e) {
            C7523p.a("AidlManager", "bind core error", e);
            return false;
        }
    }

    public final boolean a() {
        String b2 = C7527t.b(this.e);
        this.d = b2;
        if (TextUtils.isEmpty(b2)) {
            C7523p.c(this.e, "push pkgname is null");
            return false;
        }
        boolean z = C7533z.a(this.e, this.d) >= 1260;
        this.c = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f.set(i);
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            int i = this.f.get();
            if (i == 4) {
                this.j.removeMessages(2);
                this.j.sendEmptyMessageDelayed(2, 30000L);
                this.g.asyncCall(bundle, null);
                return true;
            }
            C7523p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i)));
            return false;
        } catch (Exception e2) {
            C7523p.a("AidlManager", "invoke error ", e2);
            int i2 = this.f.get();
            C7523p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i2)));
            if (i2 == 2) {
                e();
                a(1);
                return false;
            } else if (i2 == 3) {
                a(1);
                return false;
            } else if (i2 != 4) {
                return false;
            } else {
                a(1);
                f();
                return false;
            }
        }
    }
}
