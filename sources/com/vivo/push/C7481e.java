package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.taobao.android.dinamicx.C6368e;
import com.vivo.push.b.C7413a;
import com.vivo.push.b.C7414b;
import com.vivo.push.b.C7415c;
import com.vivo.push.b.C7419g;
import com.vivo.push.b.C7426n;
import com.vivo.push.b.C7438z;
import com.vivo.push.d.AbstractC7480z;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.C7509b;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import com.vivo.push.util.C7530w;
import com.vivo.push.util.C7533z;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.e */
/* loaded from: classes11.dex */
public final class C7481e {
    private static volatile C7481e a;
    private Context h;
    private C7509b j;
    private String k;
    private String l;
    private Boolean o;
    private Long p;
    private boolean q;
    private int s;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private boolean i = true;
    private SparseArray<C7482a> m = new SparseArray<>();
    private int n = 0;
    private IPushClientFactory r = new C7450d();

    private C7481e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l = null;
        this.j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = Boolean.valueOf(l() >= 1230 && C7533z.d(this.h));
        }
        return this.o.booleanValue();
    }

    public final boolean d() {
        if (this.h == null) {
            C7523p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        C7509b c7509b = this.j;
        String b = c7509b != null ? c7509b.b("APP_TOKEN", (String) null) : "";
        c(b);
        return b;
    }

    public final boolean g() {
        return this.i;
    }

    public final Context h() {
        return this.h;
    }

    public final void i() {
        this.j.a();
    }

    public final String j() {
        return this.l;
    }

    public final int k() {
        return this.s;
    }

    public final long l() {
        Context context = this.h;
        if (context == null) {
            return -1L;
        }
        if (this.p == null) {
            this.p = Long.valueOf(C7533z.a(context));
        }
        return this.p.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        C7492m.a(new RunnableC7490k(this, str));
    }

    public static synchronized C7481e a() {
        C7481e c7481e;
        synchronized (C7481e.class) {
            if (a == null) {
                a = new C7481e();
            }
            c7481e = a;
        }
        return c7481e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() throws VivoPushException {
        Context context = this.h;
        if (context != null) {
            C7533z.b(context);
        }
    }

    public final List<String> c() {
        String b = this.j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.j.b("APP_TAGS");
            arrayList.clear();
            C7523p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.e$a */
    /* loaded from: classes11.dex */
    public static class C7482a {
        private IPushActionListener a;
        private C7415c b;
        private IPushActionListener c;
        private Runnable d;
        private Object[] e;

        public C7482a(C7415c c7415c, IPushActionListener iPushActionListener) {
            this.b = c7415c;
            this.a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            IPushActionListener iPushActionListener = this.c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final Object[] b() {
            return this.e;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final void a() {
            Runnable runnable = this.d;
            if (runnable == null) {
                C7523p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized C7482a d(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                C7482a c7482a = this.m.get(parseInt);
                this.m.delete(parseInt);
                return c7482a;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b);
            }
            for (String str : list) {
                jSONObject.remove(str);
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.h == null) {
            this.h = ContextDelegate.getContext(context);
            this.q = C7527t.c(context, context.getPackageName());
            C7530w.b().a(this.h);
            a(new C7419g());
            C7509b c7509b = new C7509b();
            this.j = c7509b;
            c7509b.a(this.h, "com.vivo.push_preferences.appconfig_v1");
            this.k = f();
            this.l = this.j.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.l)) {
            m();
        }
    }

    private void c(String str) {
        C7492m.c(new RunnableC7485f(this, str));
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b = this.j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b);
            }
            for (String str : list) {
                jSONObject.put(str, System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.k)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.c = SystemClock.elapsedRealtime();
            String packageName = this.h.getPackageName();
            C7482a c7482a = null;
            if (this.h != null) {
                C7414b c7414b = new C7414b(false, packageName);
                c7414b.d();
                c7414b.e();
                c7414b.g();
                c7414b.a(100);
                if (this.q) {
                    if (n()) {
                        c7482a = new C7482a(c7414b, iPushActionListener);
                        String a2 = a(c7482a);
                        c7414b.b(a2);
                        c7482a.a(new RunnableC7489j(this, c7414b, a2));
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else if (c7414b.a(this.h) == 2) {
                    c7482a = a(c7414b, iPushActionListener);
                } else {
                    a(c7414b);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (c7482a == null) {
                return;
            }
            c7482a.a(new C7488i(this));
            c7482a.a();
        }
    }

    public final void a(String str) {
        this.k = str;
        this.j.a("APP_TOKEN", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f = f();
        this.k = f;
        if (!TextUtils.isEmpty(f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.b = SystemClock.elapsedRealtime();
            String packageName = this.h.getPackageName();
            C7482a c7482a = null;
            if (this.h != null) {
                C7414b c7414b = new C7414b(true, packageName);
                c7414b.g();
                c7414b.d();
                c7414b.e();
                c7414b.a(100);
                if (this.q) {
                    if (n()) {
                        c7482a = a(c7414b, iPushActionListener);
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else if (c7414b.a(this.h) == 2) {
                    c7482a = a(c7414b, iPushActionListener);
                } else {
                    a(c7414b);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (c7482a == null) {
                return;
            }
            c7482a.a(new C7486g(this, c7482a));
            c7482a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (TextUtils.isEmpty(this.l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            C7413a c7413a = new C7413a(false, this.h.getPackageName(), arrayList);
            c7413a.a(100);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.e)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.e = SystemClock.elapsedRealtime();
                    String a2 = a(new C7482a(c7413a, iPushActionListener));
                    c7413a.b(a2);
                    if (TextUtils.isEmpty(this.k)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, C6368e.DXError_EngineInitException);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, C6368e.DXError_EngineSizeException);
                        return;
                    } else {
                        a(c7413a);
                        e(a2);
                        return;
                    }
                }
            }
            a(c7413a);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    private C7482a a(C7414b c7414b, IPushActionListener iPushActionListener) {
        C7482a c7482a = new C7482a(c7414b, iPushActionListener);
        String a2 = a(c7482a);
        c7414b.b(a2);
        c7482a.a(new RunnableC7487h(this, c7414b, a2));
        return c7482a;
    }

    public final void a(String str, int i, Object... objArr) {
        C7482a d = d(str);
        if (d != null) {
            d.a(i, objArr);
        } else {
            C7523p.d("PushClientManager", "notifyApp token is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.l) && this.l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            C7413a c7413a = new C7413a(true, this.h.getPackageName(), arrayList);
            c7413a.a(100);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.d)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.d = SystemClock.elapsedRealtime();
                    String a2 = a(new C7482a(c7413a, iPushActionListener));
                    c7413a.b(a2);
                    if (TextUtils.isEmpty(this.k)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, C6368e.DXError_EngineInitException);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, C6368e.DXError_EngineSizeException);
                        return;
                    } else {
                        a(c7413a);
                        e(a2);
                        return;
                    }
                }
            }
            a(c7413a);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void b(String str) {
        this.l = str;
        this.j.a("APP_ALIAS", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        C7438z c7438z = new C7438z(false, context.getPackageName(), arrayList);
        c7438z.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.g = SystemClock.elapsedRealtime();
                String a2 = a(new C7482a(c7438z, iPushActionListener));
                c7438z.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, BaseBioNavigatorActivity.n);
                    return;
                } else if (arrayList.size() > 500) {
                    a(a2, BaseBioNavigatorActivity.p);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, BaseBioNavigatorActivity.o);
                            return;
                        }
                    }
                    a(c7438z);
                    e(a2);
                    return;
                }
            }
        }
        a(c7438z);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    public final void a(String str, int i) {
        C7482a d = d(str);
        if (d != null) {
            d.a(i, new Object[0]);
        } else {
            C7523p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(C7482a c7482a) {
        int i;
        this.m.put(this.n, c7482a);
        i = this.n;
        this.n = i + 1;
        return Integer.toString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        C7438z c7438z = new C7438z(true, context.getPackageName(), arrayList);
        c7438z.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.f)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f = SystemClock.elapsedRealtime();
                String a2 = a(new C7482a(c7438z, iPushActionListener));
                c7438z.b(a2);
                if (TextUtils.isEmpty(this.k)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, BaseBioNavigatorActivity.n);
                    return;
                } else {
                    if (arrayList.size() + c().size() > 500) {
                        a(a2, BaseBioNavigatorActivity.p);
                        return;
                    }
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, BaseBioNavigatorActivity.o);
                            return;
                        }
                    }
                    a(c7438z);
                    e(a2);
                    return;
                }
            }
        }
        a(c7438z);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        AbstractC7496o createReceiverCommand = this.r.createReceiverCommand(intent);
        Context context = a().h;
        if (createReceiverCommand == null) {
            C7523p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                C7523p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        AbstractC7480z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            C7523p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context != null) {
                C7523p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof C7426n)) {
            C7523p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        C7492m.a((AbstractRunnableC7491l) createReceiveTask);
    }

    public final void a(AbstractC7496o abstractC7496o) {
        Context context = a().h;
        if (abstractC7496o == null) {
            C7523p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                C7523p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        AbstractRunnableC7491l createTask = this.r.createTask(abstractC7496o);
        if (createTask == null) {
            C7523p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(abstractC7496o)));
            if (context != null) {
                C7523p.c(context, "[执行指令失败]指令" + abstractC7496o + "任务空！");
                return;
            }
            return;
        }
        C7523p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(abstractC7496o)));
        C7492m.a(createTask);
    }
}
