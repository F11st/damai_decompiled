package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.k */
/* loaded from: classes11.dex */
final class C7683k {

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.k$a */
    /* loaded from: classes11.dex */
    static final class C7684a {
        private final String a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f808a;

        C7684a(String str, boolean z) {
            this.a = str;
            this.f808a = z;
        }

        public String a() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.k$b */
    /* loaded from: classes11.dex */
    private static final class ServiceConnectionC7685b implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> a;

        /* renamed from: a  reason: collision with other field name */
        boolean f809a;

        private ServiceConnectionC7685b() {
            this.f809a = false;
            this.a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f809a) {
                throw new IllegalStateException();
            }
            this.f809a = true;
            return this.a.poll(30000L, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.k$c */
    /* loaded from: classes11.dex */
    private static final class C7686c implements IInterface {
        private IBinder a;

        public C7686c(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }
    }

    public static C7684a a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                ServiceConnectionC7685b serviceConnectionC7685b = new ServiceConnectionC7685b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, serviceConnectionC7685b, 1)) {
                    try {
                        try {
                            IBinder a = serviceConnectionC7685b.a();
                            if (a != null) {
                                return new C7684a(new C7686c(a).a(), false);
                            }
                        } finally {
                            context.unbindService(serviceConnectionC7685b);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }
}
