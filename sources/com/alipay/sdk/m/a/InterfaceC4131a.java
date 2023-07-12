package com.alipay.sdk.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.a.a */
/* loaded from: classes12.dex */
public interface InterfaceC4131a extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.a.a$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractBinderC4132a extends Binder implements InterfaceC4131a {

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.a.a$a$a */
        /* loaded from: classes10.dex */
        public static class C4133a implements InterfaceC4131a {
            public IBinder a;

            public C4133a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
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

        public static InterfaceC4131a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC4131a)) {
                return (InterfaceC4131a) queryLocalInterface;
            }
            return new C4133a(iBinder);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.a.a$b */
    /* loaded from: classes12.dex */
    public class C4134b {
        public static boolean a;
        public static boolean b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.a.a$c */
    /* loaded from: classes12.dex */
    public class C4135c {
        public InterfaceC4131a a = null;
        public String b = null;
        public String c = null;
        public final Object d = new Object();
        public ServiceConnection e = new ServiceConnectionC4136a();

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.a.a$c$a */
        /* loaded from: classes12.dex */
        public class ServiceConnectionC4136a implements ServiceConnection {
            public ServiceConnectionC4136a() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C4135c.this.a = AbstractBinderC4132a.a(iBinder);
                synchronized (C4135c.this.d) {
                    C4135c.this.d.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C4135c.this.a = null;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.a.a$c$b */
        /* loaded from: classes12.dex */
        public static class C4137b {
            public static final C4135c a = new C4135c(null);
        }

        public /* synthetic */ C4135c(ServiceConnectionC4136a serviceConnectionC4136a) {
        }

        public boolean a(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }

        public final String b(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.c = str2;
            }
            String a = ((AbstractBinderC4132a.C4133a) this.a).a(this.b, this.c, str);
            return TextUtils.isEmpty(a) ? "" : a;
        }

        public synchronized String a(Context context, String str) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (this.a == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                    if (context.bindService(intent, this.e, 1)) {
                        synchronized (this.d) {
                            try {
                                this.d.wait(3000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (this.a == null) {
                        return "";
                    }
                    try {
                        return b(context, str);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return "";
                    }
                }
                try {
                    return b(context, str);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
            throw new IllegalStateException("Cannot run on MainThread");
        }
    }
}
