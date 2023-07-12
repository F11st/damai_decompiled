package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.g.i;
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
/* loaded from: classes10.dex */
public class c {
    private static final String i = "c";
    private static final ExecutorService j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    private static AtomicInteger k = new AtomicInteger(0);
    private GrsBaseInfo a;
    private Context b;
    private h c;
    private com.huawei.hms.framework.network.grs.e.a d;
    private com.huawei.hms.framework.network.grs.e.c e;
    private com.huawei.hms.framework.network.grs.e.c f;
    private com.huawei.hms.framework.network.grs.a g;
    private FutureTask<Boolean> h;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Callable<Boolean> {
        final /* synthetic */ Context a;
        final /* synthetic */ GrsBaseInfo b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.c = new h();
            c cVar = c.this;
            Context context = this.a;
            cVar.e = new com.huawei.hms.framework.network.grs.e.c(context, GrsApp.getInstance().getBrand(JSMethod.NOT_SET) + "share_pre_grs_conf_");
            c cVar2 = c.this;
            Context context2 = this.a;
            cVar2.f = new com.huawei.hms.framework.network.grs.e.c(context2, GrsApp.getInstance().getBrand(JSMethod.NOT_SET) + "share_pre_grs_services_");
            c cVar3 = c.this;
            cVar3.d = new com.huawei.hms.framework.network.grs.e.a(cVar3.e, c.this.f, c.this.c);
            c cVar4 = c.this;
            cVar4.g = new com.huawei.hms.framework.network.grs.a(cVar4.a, c.this.d, c.this.c, c.this.f);
            if (c.k.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.a(this.a.getPackageName(), c.this.a) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.a, this.b, true).a(this.b);
            }
            String c = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a).c();
            String str = c.i;
            Logger.v(str, "scan serviceSet is:" + c);
            String a = c.this.f.a("services", "");
            String a2 = i.a(a, c);
            if (!TextUtils.isEmpty(a2)) {
                c.this.f.b("services", a2);
                String str2 = c.i;
                Logger.i(str2, "postList is:" + StringUtils.anonymizeMessage(a2));
                String str3 = c.i;
                Logger.i(str3, "currentServices:" + StringUtils.anonymizeMessage(a));
                if (!a2.equals(a)) {
                    c.this.c.a(c.this.a.getGrsParasKey(true, true, this.a));
                    c.this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a), (String) null, c.this.f);
                }
            }
            c cVar5 = c.this;
            cVar5.a(cVar5.e.a());
            c.this.d.b(this.b, this.a);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.h = null;
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GrsBaseInfo grsBaseInfo) {
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
                String a2 = this.e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(a2);
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
            com.huawei.hms.framework.network.grs.e.c cVar = this.e;
            cVar.a(grsParasKey + "time");
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.e;
            cVar2.a(grsParasKey + "ETag");
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
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.a.compare(((c) obj).a);
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
