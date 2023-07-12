package com.alipay.sdk.m.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.sdk.m.b.InterfaceC4143b;
import com.alipay.sdk.m.k0.InterfaceC4227a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.g */
/* loaded from: classes10.dex */
public class C4160g implements InterfaceC4143b {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.c.g$b */
    /* loaded from: classes12.dex */
    public static final class ServiceConnectionC4162b implements ServiceConnection {
        public boolean a;
        public final LinkedBlockingQueue<IBinder> b;

        public ServiceConnectionC4162b() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (!this.a) {
                this.a = true;
                return this.b.poll(5L, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // com.alipay.sdk.m.b.InterfaceC4143b
    public String a(Context context) {
        ServiceConnectionC4162b serviceConnectionC4162b = new ServiceConnectionC4162b();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, serviceConnectionC4162b, 1)) {
            try {
                return InterfaceC4227a.AbstractBinderC4228a.a(serviceConnectionC4162b.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC4162b);
            }
        }
        return null;
    }
}
