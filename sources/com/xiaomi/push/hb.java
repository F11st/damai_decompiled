package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hb {

    /* renamed from: a  reason: collision with other field name */
    private static ao f445a = new ao(true);
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f444a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f447a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f449a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f448a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f446a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f450a;

        /* renamed from: a  reason: collision with other field name */
        public String f451a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f452b;

        /* renamed from: b  reason: collision with other field name */
        public String f453b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f451a = "";
            this.f450a = 0L;
            this.a = -1;
            this.b = -1;
            this.f453b = "";
            this.f452b = 0L;
            this.f451a = str;
            this.f450a = j;
            this.a = i;
            this.b = i2;
            this.f453b = str2;
            this.f452b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f451a, this.f451a) && TextUtils.equals(aVar.f453b, this.f453b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f450a - this.f450a) <= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        }
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f444a;
            f444a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m946a(Context context) {
        com.xiaomi.push.providers.a aVar = f446a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f446a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m947a(Context context) {
        synchronized (hb.class) {
            if (TextUtils.isEmpty(f448a)) {
                return "";
            }
            return f448a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m949a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f447a) {
            isEmpty = f449a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m947a(context) : "", j));
        }
        if (isEmpty) {
            f445a.a(new hc(context), DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f449a) {
            if (aVar2.a(aVar)) {
                aVar2.f452b += aVar.f452b;
                return;
            }
        }
        f449a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m950a(String str) {
        synchronized (hb.class) {
            if (!m.m1124d() && !TextUtils.isEmpty(str)) {
                f448a = str;
            }
        }
    }

    private static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f815a) {
                SQLiteDatabase writableDatabase = m946a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f451a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f450a));
                    contentValues.put("network_type", Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f452b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f453b);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
