package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.m;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class b {
    private static int a = 2;

    /* renamed from: a  reason: collision with other field name */
    private static Context f1a;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f7a;

    /* renamed from: b  reason: collision with other field name */
    private static boolean f8b;

    /* renamed from: a  reason: collision with other field name */
    private static String f4a = "XMPush-" + Process.myPid();

    /* renamed from: a  reason: collision with other field name */
    private static LoggerInterface f2a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final HashMap<Integer, Long> f5a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Integer f3a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicInteger f6a = new AtomicInteger(1);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements LoggerInterface {
        private String a = b.f4a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }
    }

    public static int a() {
        return a;
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f6a.incrementAndGet());
            f5a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            LoggerInterface loggerInterface = f2a;
            loggerInterface.log(str + " starts");
            return valueOf;
        }
        return f3a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m585a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return jn1.ARRAY_START_STR + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f2a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f2a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f2a.log("", th);
        }
    }

    public static void a(Context context) {
        f1a = context;
        if (m.m1119a(context)) {
            f7a = true;
        }
        if (m.m1118a()) {
            f8b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f2a = loggerInterface;
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> hashMap = f5a;
            if (hashMap.containsKey(num)) {
                long currentTimeMillis = System.currentTimeMillis() - hashMap.remove(num).longValue();
                LoggerInterface loggerInterface = f2a;
                loggerInterface.log(b.remove(num) + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m586a(String str) {
        a(2, m585a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m587a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, m585a(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    public static void b(String str) {
        a(0, m585a(str));
    }

    public static void c(String str) {
        a(1, m585a(str));
    }

    public static void d(String str) {
        a(4, m585a(str));
    }

    public static void e(String str) {
        if (!f7a) {
            Log.w(f4a, m585a(str));
            if (f8b) {
                return;
            }
        }
        m586a(str);
    }
}
