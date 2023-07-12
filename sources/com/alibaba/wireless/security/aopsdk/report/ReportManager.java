package com.alibaba.wireless.security.aopsdk.report;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.BuildConfig;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.InvocationConfig;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.alibaba.wireless.security.aopsdk.e.f.e;
import com.alibaba.wireless.security.aopsdk.e.f.g;
import com.alibaba.wireless.security.aopsdk.h.a;
import com.alibaba.wireless.security.aopsdk.i.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;
import tb.jn1;

/* loaded from: classes.dex */
public class ReportManager {
    public static final String a = "AOP-ReportManager";
    public static final String c = "cid";
    public static final String d = "sid";
    public static final String e = "rid";
    public static final String f = "stc";
    public static final String g = "ic";
    public static final String h = "bi";
    public static final String i = "pc";
    public static final String j = "ts";
    public static final String k = "fv";
    private static boolean l = true;
    public static final boolean b = ConfigManager.DEBUG;
    private static final ThreadLocal<Boolean> m = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static class a implements Observer {
        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            boolean unused = ReportManager.l = ((g) obj).f.k == 1;
        }
    }

    public static boolean b(Invocation invocation) {
        e eVar;
        int i2;
        InvocationConfig invocationConfig = invocation.invocationConfig;
        if (invocationConfig == null || (eVar = invocationConfig.matchedRule) == null || (i2 = eVar.k) == -1) {
            return l;
        }
        return i2 == 1;
    }

    public static Map<String, String> getReportMessage(Invocation invocation, int i2, int i3, long j2, long j3, long j4) {
        HashMap hashMap = new HashMap();
        a.b bVar = a.b.STACK_TRACE;
        hashMap.put(bVar.a(), com.alibaba.wireless.security.aopsdk.h.a.a(bVar, invocation));
        InvocationConfig invocationConfig = invocation.invocationConfig;
        hashMap.put("flg", Integer.toString(invocationConfig != null ? invocationConfig.matchedAction : 0));
        if (invocation.thiz != null) {
            a.b bVar2 = a.b.THIS;
            hashMap.put(bVar2.a(), com.alibaba.wireless.security.aopsdk.h.a.a(bVar2, invocation));
        }
        a.b[] bVarArr = {a.b.METHOD_PARAM, a.b.PROXY_NAME, a.b.PROCESS_ALIAS, a.b.APP_STATE};
        for (int i4 = 0; i4 < 4; i4++) {
            a.b bVar3 = bVarArr[i4];
            String a2 = com.alibaba.wireless.security.aopsdk.h.a.a(bVar3, invocation);
            if (a2 != null) {
                hashMap.put(bVar3.a(), a2);
            }
        }
        hashMap.put("cid", Integer.toString(ConfigManager.getInstance().getConfigId()));
        hashMap.put(e, Integer.toString(i3));
        hashMap.put("sid", Integer.toString(i2));
        if (b(invocation)) {
            a.b bVar4 = a.b.SNAPSHOT;
            hashMap.put(bVar4.a(), com.alibaba.wireless.security.aopsdk.h.a.a(bVar4, invocation));
        }
        hashMap.put(f, Long.toString(invocation.stackTimeCost));
        hashMap.put(g, Long.toString(j2));
        hashMap.put("bi", Long.toString(j3));
        hashMap.put(i, Long.toString(j4));
        hashMap.put("ts", Long.toString(System.currentTimeMillis()));
        a.b bVar5 = a.b.VERSION_CODE;
        hashMap.put(bVar5.a(), com.alibaba.wireless.security.aopsdk.h.a.a(bVar5, invocation));
        hashMap.put(k, BuildConfig.VERSION_NAME);
        Object obj = invocation.extraInfo;
        if (obj != null) {
            hashMap.put("extra", b.a(obj));
        }
        return hashMap;
    }

    private static String a(Invocation invocation) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        Object[] objArr = invocation.args;
        if (objArr != null) {
            for (Object obj : objArr) {
                sb.append(b.a(obj));
                sb.append("^^");
            }
            if (invocation.args.length > 0 && sb.length() >= 2) {
                sb.delete(sb.length() - 2, sb.length());
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    public static void a(Invocation invocation, int i2, int i3, long j2, long j3, long j4) {
        ThreadLocal<Boolean> threadLocal = m;
        Boolean bool = threadLocal.get();
        if (bool == null || !bool.booleanValue()) {
            threadLocal.set(Boolean.TRUE);
            try {
                Map<String, String> reportMessage = getReportMessage(invocation, i2, i3, j2, j3, j4);
                if (b) {
                    Log.d(a, "UtReport for " + new JSONObject(reportMessage).toString());
                }
                com.alibaba.wireless.security.aopsdk.h.c.a.a("sarpt", BuildConfig.VERSION_NAME, reportMessage);
            } catch (Throwable th) {
                com.alibaba.wireless.security.aopsdk.i.a.a(a, "report unexpect failed", th);
            }
            m.set(Boolean.FALSE);
        }
    }
}
