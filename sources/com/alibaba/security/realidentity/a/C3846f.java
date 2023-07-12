package com.alibaba.security.realidentity.a;

import android.content.Context;
import android.util.Base64;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.http.RpcInvoker;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.a.f */
/* loaded from: classes8.dex */
public class C3846f extends AbstractC3841b {
    private static final String g = "f";
    private static final int h = 10000;
    private static final int i = 1024;
    private static final String j = "|:|";
    private static final boolean k = false;
    private static final StringBuffer l = new StringBuffer();
    private static final String n = "UTF-8";
    private final ThreadPoolExecutor m = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.a.f.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "tbrpsdk-easyTrack");
        }
    });
    private final Runnable o = new Runnable() { // from class: com.alibaba.security.realidentity.a.f.2
        @Override // java.lang.Runnable
        public final void run() {
            C3846f.this.b();
        }
    };

    @Override // com.alibaba.security.realidentity.a.AbstractC3841b
    public final void a(String str, String str2, Object obj, Object obj2, Object obj3, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (obj != null) {
            hashMap2.put("arg1", obj);
        }
        if (obj2 != null) {
            hashMap2.put("arg2", obj2);
        }
        if (obj3 != null) {
            hashMap2.put(UTDataCollectorNodeColumn.ARG3, obj3);
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        a(0, str, str2, hashMap2);
    }

    @Override // com.alibaba.security.realidentity.a.AbstractC3841b
    public final void b() {
        this.f.removeCallbacks(this.o);
        StringBuffer stringBuffer = l;
        if (stringBuffer.length() == 0) {
            return;
        }
        final HashMap hashMap = new HashMap();
        String str = null;
        try {
            str = new String(stringBuffer.toString().getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            C3800a.e(g, e.getLocalizedMessage());
        }
        String encodeToString = Base64.encodeToString(str.getBytes(), 0);
        if (encodeToString != null) {
            hashMap.put("content", encodeToString);
        }
        l.setLength(0);
        this.m.allowCoreThreadTimeOut(true);
        this.m.execute(new Runnable() { // from class: com.alibaba.security.realidentity.a.f.3
            @Override // java.lang.Runnable
            public final void run() {
                Context context = C3847g.C3848a.a.c;
                if (context != null) {
                    RpcInvoker.callMtopSync(context, "mtop.verifycenter.rp.rphit", "1.0", true, (Map<String, String>) hashMap);
                }
            }
        });
    }

    @Override // com.alibaba.security.realidentity.a.AbstractC3841b
    public final void a(String str, String str2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        a(1, str, str2, hashMap2);
    }

    @Override // com.alibaba.security.realidentity.a.AbstractC3841b
    public final void a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        a(2, null, null, hashMap);
    }

    private static String b(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        for (String str : map.keySet()) {
            String a = a(map.get(str));
            String a2 = a(str);
            if (a != null && a2 != null) {
                if (z) {
                    stringBuffer.append(a2 + "=" + a);
                    z = false;
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(a2 + "=" + a);
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.alibaba.security.realidentity.a.AbstractC3841b
    public final void a(int i2, String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("__verifyToken", C3847g.C3848a.a.d);
        hashMap.put("__ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("source", Integer.valueOf(i2));
        if (str != null) {
            hashMap.put("pageName", str);
        }
        if (str2 != null) {
            hashMap.put("eventId", str2);
        }
        hashMap.putAll(map);
        String b = b(hashMap);
        StringBuffer stringBuffer = l;
        if (stringBuffer.length() > 0) {
            stringBuffer.append(j);
        }
        stringBuffer.append(b);
        if (stringBuffer.length() > 1024) {
            b();
        } else {
            this.f.postDelayed(this.o, 10000L);
        }
    }

    private static String a(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Integer) {
                StringBuilder sb = new StringBuilder();
                sb.append(((Integer) obj).intValue());
                return sb.toString();
            } else if (obj instanceof Long) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(((Long) obj).longValue());
                return sb2.toString();
            } else if (obj instanceof Double) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(((Double) obj).doubleValue());
                return sb3.toString();
            } else if (obj instanceof Float) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(((Float) obj).floatValue());
                return sb4.toString();
            } else if (obj instanceof Short) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append((int) ((Short) obj).shortValue());
                return sb5.toString();
            } else if (obj instanceof Byte) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append((int) ((Byte) obj).byteValue());
                return sb6.toString();
            } else if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            } else {
                return obj instanceof Character ? ((Character) obj).toString() : obj.toString();
            }
        }
        return "";
    }
}
