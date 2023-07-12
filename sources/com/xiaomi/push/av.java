package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class av implements au, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    private Context f107a;

    /* renamed from: a  reason: collision with other field name */
    private Class f109a = null;
    private Class b = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f111a = null;

    /* renamed from: b  reason: collision with other field name */
    private Method f112b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f110a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private volatile int f105a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile long f106a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f108a = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        Boolean f113a;

        /* renamed from: a  reason: collision with other field name */
        String f114a;
        String b;
        String c;
        String d;

        private a() {
            this.f113a = null;
            this.f114a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f114a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f113a = Boolean.TRUE;
            }
            return this.f113a != null;
        }
    }

    public av(Context context) {
        this.f107a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return v.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t = (T) method.invoke(obj, objArr);
                if (t != null) {
                    return t;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private void a() {
        synchronized (this.f110a) {
            try {
                this.f110a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i);
                cls2 = a4;
                cls = a3;
                break;
            }
            i++;
            cls2 = a4;
            cls = a3;
        }
        this.f109a = a2;
        this.f111a = a(a2, "InitSdk", Context.class, cls);
        this.b = cls;
        this.f112b = a(cls2, "getUDID", new Class[0]);
        this.c = a(cls2, "getOAID", new Class[0]);
        this.d = a(cls2, "getVAID", new Class[0]);
        this.e = a(cls2, "getAAID", new Class[0]);
        this.f = a(cls2, "isSupported", new Class[0]);
        this.g = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.f108a != null) {
            return;
        }
        long j = this.f106a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f105a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f110a) {
                if (this.f106a == j && this.f105a == i) {
                    b("retry, current count is " + i);
                    this.f105a = this.f105a + 1;
                    b(this.f107a);
                    j = this.f106a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f108a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f110a) {
            if (this.f108a == null) {
                try {
                    b(str + " wait...");
                    this.f110a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f111a, this.f109a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f106a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f106a = elapsedRealtime;
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m586a("mdid:" + str);
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public String mo670a() {
        a("getOAID");
        if (this.f108a == null) {
            return null;
        }
        return this.f108a.b;
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public boolean mo671a() {
        a("isSupported");
        return this.f108a != null && Boolean.TRUE.equals(this.f108a.f113a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f106a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.f114a = (String) a(this.f112b, obj2, new Object[0]);
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.c = (String) a(this.d, obj2, new Object[0]);
                    aVar.d = (String) a(this.e, obj2, new Object[0]);
                    aVar.f113a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f108a != null);
                        b(sb.toString());
                        synchronized (av.class) {
                            if (this.f108a == null) {
                                this.f108a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }
}
