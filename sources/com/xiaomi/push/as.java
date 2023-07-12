package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.alipay.sdk.m.c.C4152b;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class as implements au {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private Context f100a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f101a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f99a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile String f103a = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f104b = false;
    private volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f102a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.as$a */
    /* loaded from: classes11.dex */
    public class ServiceConnectionC7602a implements ServiceConnection {
        private ServiceConnectionC7602a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                as.this.f103a = C7603b.a(iBinder);
                as.this.f104b = C7603b.m672a(iBinder);
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    try {
                        as.this.f102a.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    try {
                        as.this.f102a.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    try {
                        as.this.f102a.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.as$b */
    /* loaded from: classes11.dex */
    private static class C7603b {
        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C4152b.a);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        static boolean m672a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C4152b.a);
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public as(Context context) {
        this.f100a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f101a = new ServiceConnectionC7602a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f100a.bindService(intent, this.f101a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f99a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f99a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f102a) {
            try {
                AbstractC7535b.m586a("huawei's " + str + " wait...");
                this.f102a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f101a;
        if (serviceConnection != null) {
            try {
                this.f100a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public String mo670a() {
        a("getOAID");
        return this.f103a;
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo671a() {
        return a;
    }
}
