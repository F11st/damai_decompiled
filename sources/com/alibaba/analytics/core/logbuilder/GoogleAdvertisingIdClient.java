package com.alibaba.analytics.core.logbuilder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class GoogleAdvertisingIdClient {
    private static C3119b a;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private static final class AdvertisingInterface implements IInterface {
        private IBinder a;

        public AdvertisingInterface(IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        public String d() throws RemoteException {
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

        public boolean e(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.logbuilder.GoogleAdvertisingIdClient$b */
    /* loaded from: classes15.dex */
    public static final class C3119b {
        private final String a;
        private final boolean b;

        C3119b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.logbuilder.GoogleAdvertisingIdClient$c */
    /* loaded from: classes15.dex */
    private static final class ServiceConnectionC3120c implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private ServiceConnectionC3120c() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C3119b a() {
        return a;
    }

    public static synchronized void b(Context context) {
        synchronized (GoogleAdvertisingIdClient.class) {
            if (a != null) {
                return;
            }
            try {
                ServiceConnectionC3120c serviceConnectionC3120c = new ServiceConnectionC3120c();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, serviceConnectionC3120c, 1)) {
                    try {
                        IBinder a2 = serviceConnectionC3120c.a();
                        if (a2 != null) {
                            AdvertisingInterface advertisingInterface = new AdvertisingInterface(a2);
                            a = new C3119b(advertisingInterface.d(), advertisingInterface.e(true));
                        }
                    } catch (Exception e) {
                        Logger.u("GoogleAdvertisingIdClient", e, new Object[0]);
                    }
                    context.unbindService(serviceConnectionC3120c);
                }
            } catch (Throwable unused) {
            }
            if (a == null) {
                a = new C3119b("", true);
            }
        }
    }
}
