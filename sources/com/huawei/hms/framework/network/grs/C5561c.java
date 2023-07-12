package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.e.C5564a;
import com.huawei.hms.framework.network.grs.e.C5566c;
import com.huawei.hms.framework.network.grs.f.C5568b;
import com.huawei.hms.framework.network.grs.g.C5583h;
import com.huawei.hms.framework.network.grs.g.C5586i;
import com.huawei.hms.framework.network.grs.g.k.C5590c;
import com.huawei.hms.framework.network.grs.h.C5592a;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.c */
/* loaded from: classes10.dex */
public class C5561c {
    private static final String i = "c";
    private static final ExecutorService j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    private static AtomicInteger k = new AtomicInteger(0);
    private GrsBaseInfo a;
    private Context b;
    private C5583h c;
    private C5564a d;
    private C5566c e;
    private C5566c f;
    private C5557a g;
    private FutureTask<Boolean> h;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.framework.network.grs.c$a */
    /* loaded from: classes10.dex */
    class CallableC5562a implements Callable<Boolean> {
        final /* synthetic */ Context a;
        final /* synthetic */ GrsBaseInfo b;

        CallableC5562a(Context context, GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            C5561c.this.c = new C5583h();
            C5561c c5561c = C5561c.this;
            Context context = this.a;
            c5561c.e = new C5566c(context, GrsApp.getInstance().getBrand(JSMethod.NOT_SET) + "share_pre_grs_conf_");
            C5561c c5561c2 = C5561c.this;
            Context context2 = this.a;
            c5561c2.f = new C5566c(context2, GrsApp.getInstance().getBrand(JSMethod.NOT_SET) + "share_pre_grs_services_");
            C5561c c5561c3 = C5561c.this;
            c5561c3.d = new C5564a(c5561c3.e, C5561c.this.f, C5561c.this.c);
            C5561c c5561c4 = C5561c.this;
            c5561c4.g = new C5557a(c5561c4.a, C5561c.this.d, C5561c.this.c, C5561c.this.f);
            if (C5561c.k.incrementAndGet() <= 2 || C5568b.a(this.a.getPackageName(), C5561c.this.a) == null) {
                new C5568b(this.a, this.b, true).a(this.b);
            }
            String c = new C5590c(this.b, this.a).c();
            String str = C5561c.i;
            Logger.v(str, "scan serviceSet is:" + c);
            String a = C5561c.this.f.a("services", "");
            String a2 = C5586i.a(a, c);
            if (!TextUtils.isEmpty(a2)) {
                C5561c.this.f.b("services", a2);
                String str2 = C5561c.i;
                Logger.i(str2, "postList is:" + StringUtils.anonymizeMessage(a2));
                String str3 = C5561c.i;
                Logger.i(str3, "currentServices:" + StringUtils.anonymizeMessage(a));
                if (!a2.equals(a)) {
                    C5561c.this.c.a(C5561c.this.a.getGrsParasKey(true, true, this.a));
                    C5561c.this.c.a(new C5590c(this.b, this.a), (String) null, C5561c.this.f);
                }
            }
            C5561c c5561c5 = C5561c.this;
            c5561c5.a(c5561c5.e.a());
            C5561c.this.d.b(this.b, this.a);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5561c(Context context, GrsBaseInfo grsBaseInfo) {
        this.h = null;
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new CallableC5562a(this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", C5592a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5561c(GrsBaseInfo grsBaseInfo) {
        this.h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.a = grsBaseInfo.m574clone();
        } catch (CloneNotSupportedException e) {
            Logger.w(i, "GrsClient catch CloneNotSupportedException", e);
            this.a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(i, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String a = this.e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(a) && a.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(a);
                    } catch (NumberFormatException e) {
                        Logger.w(i, "convert expire time from String to Long catch NumberFormatException.", e);
                    }
                }
                if (!a(j2)) {
                    Logger.i(i, "init interface auto clear some invalid sp's data.");
                    String substring = str.substring(0, str.length() - 4);
                    this.e.a(substring);
                    this.e.a(str);
                    this.e.a(substring + "ETag");
                }
            }
        }
    }

    private boolean a(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e) {
            e = e;
            str = i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            e = e2;
            str = i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(i, "init compute task timed out");
            return false;
        } catch (Exception e3) {
            e = e3;
            str = i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2) {
        if (this.a == null || str == null || str2 == null) {
            Logger.w(i, "invalid para!");
            return null;
        } else if (e()) {
            return this.g.a(str, str2, this.b);
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(String str) {
        if (this.a != null && str != null) {
            return e() ? this.g.a(str, this.b) : new HashMap();
        }
        Logger.w(i, "invalid para!");
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (e()) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            this.e.a(grsParasKey);
            C5566c c5566c = this.e;
            c5566c.a(grsParasKey + "time");
            C5566c c5566c2 = this.e;
            c5566c2.a(grsParasKey + "ETag");
            this.c.a(grsParasKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(i, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, iQueryUrlsCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(i, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, str2, iQueryUrlCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C5561c.class == obj.getClass() && (obj instanceof C5561c)) {
            return this.a.compare(((C5561c) obj).a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.a) == null || (context = this.b) == null) {
            return false;
        }
        this.d.a(grsBaseInfo, context);
        return true;
    }
}
