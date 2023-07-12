package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7345n;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.ae */
/* loaded from: classes11.dex */
public class C7257ae {
    private static final String b = "ae";
    private static C7257ae c;
    protected ConcurrentHashMap<EnumC7259b, C7260c> a;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$a */
    /* loaded from: classes11.dex */
    public class CallableC7258a<V, T> implements Callable<V> {
        ValueCallback<T> a;
        Callable<V> b;

        public CallableC7258a(Callable<V> callable, ValueCallback<T> valueCallback) {
            this.a = valueCallback;
            this.b = callable;
        }

        @Override // java.util.concurrent.Callable
        public final V call() throws Exception {
            V v;
            UCSetupException uCSetupException = null;
            try {
                v = this.b.call();
            } catch (UCSetupException e) {
                v = null;
                uCSetupException = e;
            } catch (Throwable th) {
                UCSetupException uCSetupException2 = new UCSetupException(3003, th);
                v = null;
                uCSetupException = uCSetupException2;
            }
            if (uCSetupException != null) {
                ValueCallback<T> valueCallback = this.a;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(uCSetupException);
                }
                return (V) Integer.valueOf(C7262e.b);
            }
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$b */
    /* loaded from: classes11.dex */
    public enum EnumC7259b {
        SETUP_GLOBAL,
        CHECK_OLD_KERNEL,
        VERIFY_SDK_SHELL,
        VERIFY_CORE_JAR,
        LOAD_SDK_SHELL,
        CHECK_VERSION,
        CHECK_SO,
        CHECK_PAK,
        INIT_SDK_SETTINGS,
        SETUP_CORE_FACTORY,
        INIT_UCMOBILE_WEBKIT,
        SETUP_PRINT_LOG
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$c */
    /* loaded from: classes11.dex */
    public class C7260c {
        public EnumC7259b a;
        public int b;
        public ValueCallback<Object> f;
        public Future<?> e = null;
        public volatile int c = C7263f.a;
        public volatile Object d = Integer.valueOf(C7262e.a);

        /* JADX WARN: Multi-variable type inference failed */
        public C7260c(int i, UCAsyncTask uCAsyncTask, Future<?> future) {
            this.b = i;
            this.a = uCAsyncTask;
            this.f = future;
        }

        public final String toString() {
            Object[] objArr = new Object[5];
            objArr[0] = this.a.toString();
            objArr[1] = Integer.valueOf(this.b);
            objArr[2] = Integer.valueOf(this.c);
            objArr[3] = this.d;
            Future<?> future = this.e;
            objArr[4] = future != null ? future.toString() : "";
            return String.format("Task name: %s, policy: %d, status: %d, result: %s, future: %s", objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$d */
    /* loaded from: classes11.dex */
    public static class C7261d {
        public static int a = 0;
        public static int b = 1;
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$e */
    /* loaded from: classes11.dex */
    public static class C7262e {
        public static int a = -2;
        public static int b = -1;
        public static int c;
    }

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.ae$f */
    /* loaded from: classes11.dex */
    public static class C7263f {
        public static int a = -1;
        public static int b = 1;
        public static int c = 2;
    }

    private C7257ae() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap<>();
        }
    }

    public static C7257ae a() {
        if (c == null) {
            synchronized (C7257ae.class) {
                if (c == null) {
                    c = new C7257ae();
                }
            }
        }
        return c;
    }

    private C7260c c(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        for (Map.Entry<EnumC7259b, C7260c> entry : this.a.entrySet()) {
            if (entry.getValue().e.equals(runnable)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final void b(Runnable runnable) {
        C7260c c2 = c(runnable);
        if (c2 != null) {
            try {
                c2.c = C7263f.c;
                c2.d = c2.e.get();
                ValueCallback<Object> valueCallback = c2.f;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(c2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(EnumC7259b enumC7259b) {
        this.a.remove(enumC7259b);
    }

    public final Object b(EnumC7259b enumC7259b) {
        C7260c c7260c = this.a.get(enumC7259b);
        if (c7260c != null) {
            Integer num = (Integer) c7260c.d;
            if (num.intValue() == C7262e.a) {
                num = (Integer) a(c7260c);
            }
            if (num.equals(Integer.valueOf(C7262e.c))) {
                return num;
            }
            throw new UCSetupException(4032, String.format("task %s failed. result: %d", enumC7259b.toString(), c7260c.d));
        }
        throw new UCSetupException(4033, String.format("没有找到%s任务", enumC7259b.toString()));
    }

    private static Object a(C7260c c7260c) {
        try {
            return c7260c.e.get();
        } catch (Exception e) {
            throw new UCSetupException(4032, e);
        }
    }

    public final void a(EnumC7259b[] enumC7259bArr) throws UCSetupException {
        for (int i = 0; i <= 0; i++) {
            b(enumC7259bArr[0]);
        }
    }

    public final void a(Runnable runnable) {
        C7260c c2 = c(runnable);
        if (c2 != null) {
            try {
                c2.c = C7263f.b;
                ValueCallback<Object> valueCallback = c2.f;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(c2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final C7260c a(int i, EnumC7259b enumC7259b, Callable<?> callable, ValueCallback<Object> valueCallback) {
        C7302b.a(enumC7259b.ordinal() + 400);
        C7260c c7260c = new C7260c(i, enumC7259b, valueCallback);
        if ((i & C7261d.b) != 0) {
            try {
                c7260c.c = C7263f.b;
                callable.call();
                c7260c.c = C7263f.c;
                valueCallback.onReceiveValue(c7260c);
                return null;
            } catch (Exception e) {
                throw new UCSetupException(e);
            }
        }
        c7260c.e = C7345n.a(callable);
        this.a.put(c7260c.a, c7260c);
        return c7260c;
    }
}
