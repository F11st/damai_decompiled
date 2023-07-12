package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bb implements au {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private Context f123a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f124a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f122a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f125a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f126a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        String f127a;
        String b;
        String c;
        String d;

        private a() {
            this.f127a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (bb.this.f125a != null) {
                return;
            }
            new Thread(new bd(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class c {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public bb(Context context) {
        this.f123a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f124a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f123a.bindService(intent, this.f124a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f122a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f122a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f126a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m586a("oppo's " + str + " wait...");
                this.f126a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f123a.getPackageManager().getPackageInfo(this.f123a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b  reason: collision with other method in class */
    public void m691b() {
        ServiceConnection serviceConnection = this.f124a;
        if (serviceConnection != null) {
            try {
                this.f123a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public String mo670a() {
        a("getOAID");
        if (this.f125a == null) {
            return null;
        }
        return this.f125a.b;
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public boolean mo671a() {
        return a;
    }
}
