package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.e.C5566c;
import com.huawei.hms.framework.network.grs.f.C5568b;
import com.huawei.hms.framework.network.grs.g.j.C5587a;
import com.huawei.hms.framework.network.grs.g.k.C5590c;
import com.huawei.hms.framework.network.grs.g.k.C5591d;
import com.huawei.hms.framework.network.grs.h.C5595d;
import com.huawei.hms.framework.network.grs.local.model.C5600a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.c */
/* loaded from: classes10.dex */
public class C5576c {
    private static final String n = "c";
    private final GrsBaseInfo a;
    private final Context b;
    private final C5564a c;
    private C5578d d;
    private final C5590c j;
    private C5591d k;
    private final Map<String, Future<C5578d>> e = new ConcurrentHashMap(16);
    private final List<C5578d> f = new CopyOnWriteArrayList();
    private final JSONArray g = new JSONArray();
    private final List<String> h = new CopyOnWriteArrayList();
    private final List<String> i = new CopyOnWriteArrayList();
    private String l = "";
    private long m = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.g.c$a */
    /* loaded from: classes10.dex */
    public class CallableC5577a implements Callable<C5578d> {
        final /* synthetic */ ExecutorService a;
        final /* synthetic */ String b;
        final /* synthetic */ C5566c c;

        CallableC5577a(ExecutorService executorService, String str, C5566c c5566c) {
            this.a = executorService;
            this.b = str;
            this.c = c5566c;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C5578d call() {
            return C5576c.this.b(this.a, this.b, this.c);
        }
    }

    public C5576c(C5590c c5590c, C5564a c5564a) {
        this.j = c5590c;
        this.a = c5590c.b();
        this.b = c5590c.a();
        this.c = c5564a;
        c();
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[LOOP:0: B:3:0x0006->B:33:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.g.C5578d a(java.util.concurrent.ExecutorService r17, java.util.List<java.lang.String> r18, java.lang.String r19, com.huawei.hms.framework.network.grs.e.C5566c r20) {
        /*
            r16 = this;
            r9 = r16
            r10 = 0
            r0 = 0
            r11 = r0
            r12 = 0
        L6:
            int r0 = r18.size()
            if (r12 >= r0) goto L9d
            r13 = r18
            java.lang.Object r0 = r13.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r14 = 1
            if (r1 != 0) goto L8c
            com.huawei.hms.framework.network.grs.g.a r15 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.a
            r1 = r15
            r2 = r0
            r3 = r12
            r4 = r16
            r6 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r15.g()
            r2 = r17
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.e
            r3.put(r0, r1)
            long r3 = r9.m     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            java.lang.Object r0 = r1.get(r3, r0)     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.C5578d) r1     // Catch: java.util.concurrent.TimeoutException -> L6a java.lang.InterruptedException -> L72 java.util.concurrent.ExecutionException -> L7b java.util.concurrent.CancellationException -> L84
            if (r1 == 0) goto L68
            boolean r0 = r1.o()     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            if (r0 != 0) goto L55
            boolean r0 = r1.m()     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            if (r0 == 0) goto L68
        L55:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.C5576c.n     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L5e java.lang.InterruptedException -> L60 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.CancellationException -> L66
            r11 = r1
            goto L8f
        L5e:
            r11 = r1
            goto L6a
        L60:
            r0 = move-exception
            r11 = r1
            goto L73
        L63:
            r0 = move-exception
            r11 = r1
            goto L7c
        L66:
            r11 = r1
            goto L84
        L68:
            r11 = r1
            goto L8e
        L6a:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.C5576c.n
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            goto L8e
        L72:
            r0 = move-exception
        L73:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.C5576c.n
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w(r1, r3, r0)
            goto L8f
        L7b:
            r0 = move-exception
        L7c:
            java.lang.String r1 = com.huawei.hms.framework.network.grs.g.C5576c.n
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w(r1, r3, r0)
            goto L8e
        L84:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.C5576c.n
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            goto L8f
        L8c:
            r2 = r17
        L8e:
            r14 = 0
        L8f:
            if (r14 == 0) goto L99
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.C5576c.n
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L9d
        L99:
            int r12 = r12 + 1
            goto L6
        L9d:
            com.huawei.hms.framework.network.grs.g.d r0 = r9.b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.C5576c.a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, e(), this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.i.add(sb.toString());
    }

    private C5578d b(C5578d c5578d) {
        String str;
        String str2;
        for (Map.Entry<String, Future<C5578d>> entry : this.e.entrySet()) {
            if (c5578d != null && (c5578d.o() || c5578d.m())) {
                break;
            }
            try {
                c5578d = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                str = n;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(n, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e2) {
                e = e2;
                str = n;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return c5578d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C5578d b(ExecutorService executorService, String str, C5566c c5566c) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C5578d a = a(executorService, this.i, str, c5566c);
        int b = a == null ? 0 : a.b();
        String str2 = n;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b));
        if (b == 404 || b == 401) {
            if (TextUtils.isEmpty(e()) && TextUtils.isEmpty(this.a.getAppName())) {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.e.clear();
            Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            a = a(executorService, this.h, str, c5566c);
        }
        C5579e.a(new ArrayList(this.f), SystemClock.elapsedRealtime() - elapsedRealtime, this.g, this.b);
        this.f.clear();
        return a;
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(this.a.getAppName()) && TextUtils.isEmpty(e())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(e()) ? this.a.getAppName() : e();
        sb.append(String.format(locale, str, objArr));
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, "1.0", this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.h.add(sb.toString());
    }

    private void c() {
        C5591d a = C5587a.a(this.b);
        if (a == null) {
            Logger.w(n, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a);
        List<String> a2 = a.a();
        if (a2 == null || a2.size() <= 0) {
            Logger.v(n, "maybe grs_base_url config with [],please check.");
        } else if (a2.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        } else {
            String c = a.c();
            String b = a.b();
            if (a2.size() > 0) {
                for (String str : a2) {
                    if (str.startsWith("https://")) {
                        b(c, str);
                        a(b, str);
                    } else {
                        Logger.w(n, "grs server just support https scheme url,please check.");
                    }
                }
            }
            Logger.v(n, "request to GRS server url is{%s} and {%s}", this.h, this.i);
        }
    }

    private void d() {
        String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
        C5566c a = this.c.a();
        this.l = a.a(grsParasKey + "ETag", "");
    }

    private String e() {
        C5568b a = C5568b.a(this.b.getPackageName(), this.a);
        C5600a a2 = a != null ? a.a() : null;
        if (a2 != null) {
            String b = a2.b();
            Logger.v(n, "get appName from local assets is{%s}", b);
            return b;
        }
        return "";
    }

    public C5578d a(ExecutorService executorService, String str, C5566c c5566c) {
        String str2;
        String str3;
        if (this.h.isEmpty() && this.i.isEmpty()) {
            return null;
        }
        try {
            C5591d b = b();
            return (C5578d) executorService.submit(new CallableC5577a(executorService, str, c5566c)).get(b != null ? b.d() : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e);
            return null;
        } catch (CancellationException unused) {
            Logger.i(n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(n, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e3) {
            e = e3;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e);
            return null;
        }
    }

    public String a() {
        return this.l;
    }

    public synchronized void a(C5578d c5578d) {
        this.f.add(c5578d);
        C5578d c5578d2 = this.d;
        if (c5578d2 != null && (c5578d2.o() || this.d.m())) {
            Logger.v(n, "grsResponseResult is ok");
        } else if (c5578d.n()) {
            Logger.i(n, "GRS server open 503 limiting strategy.");
            C5595d.a(this.a.getGrsParasKey(true, true, this.b), new C5595d.C5596a(c5578d.k(), SystemClock.elapsedRealtime()));
        } else {
            if (c5578d.m()) {
                Logger.i(n, "GRS server open 304 Not Modified.");
            }
            if (!c5578d.o() && !c5578d.m()) {
                Logger.v(n, "grsResponseResult has exception so need return");
                return;
            }
            this.d = c5578d;
            this.c.a(this.a, c5578d, this.b, this.j);
            for (Map.Entry<String, Future<C5578d>> entry : this.e.entrySet()) {
                if (!entry.getKey().equals(c5578d.l()) && !entry.getValue().isCancelled()) {
                    Logger.i(n, "future cancel");
                    entry.getValue().cancel(true);
                }
            }
        }
    }

    public void a(C5591d c5591d) {
        this.k = c5591d;
    }

    public C5591d b() {
        return this.k;
    }
}
