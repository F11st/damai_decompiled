package com.efs.sdk.base.a.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.newsharedpreferences.C3236a;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.d.C4786a;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;
import tb.n73;
import tb.q33;
import tb.r33;
import tb.v43;
import tb.w63;
import tb.z43;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.e.b */
/* loaded from: classes10.dex */
public class HandlerC4790b extends Handler {
    private static final Map<String, Long> f = new HashMap<String, Long>() { // from class: com.efs.sdk.base.a.e.b.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", Long.valueOf((long) DateUtils.MILLIS_PER_HOUR));
            put("flow_day", 86400000L);
        }
    };
    private static final Map<String, Long> g = new HashMap<String, Long>() { // from class: com.efs.sdk.base.a.e.b.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE));
        }
    };
    private Map<String, AtomicInteger> a;
    private volatile SharedPreferences b;
    private volatile SharedPreferences.Editor c;
    private Context d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.e.b$a */
    /* loaded from: classes10.dex */
    public static class C4791a {
        private static final HandlerC4790b a = new HandlerC4790b((byte) 0);
    }

    private HandlerC4790b() {
        super(r33.a.getLooper());
        this.a = new ConcurrentHashMap(5);
        this.d = C4786a.a().c;
        this.e = C4786a.a().a;
        g();
        File d = q33.d(C4786a.a().c, C4786a.a().a);
        if (d.exists()) {
            z43.i(d);
        }
    }

    /* synthetic */ HandlerC4790b(byte b) {
        this();
    }

    private static long a(Map<String, String> map, @NonNull String str, @NonNull String str2) {
        long longValue = g.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return longValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            w63.b("efs.flow", "get max flow error", th);
            return longValue;
        }
    }

    public static HandlerC4790b b() {
        return C4791a.a;
    }

    private static List<String> c(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + JSMethod.NOT_SET + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + JSMethod.NOT_SET + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3);
        }
        return arrayList;
    }

    private void d(String str) {
        n73 n73Var;
        n73 n73Var2;
        if (!this.a.containsKey(str) || this.a.get(str) == null || this.a.get(str).get() <= 10) {
            n73Var = n73.C9462a.a;
            n73Var.c(C4783c.a().e.a, str);
            if (str.equals("flow_day")) {
                n73Var2 = n73.C9462a.a;
                n73Var2.b(C4783c.a().e.a);
            }
            if (!this.a.containsKey(str)) {
                this.a.put(str, new AtomicInteger());
            }
            this.a.get(str).incrementAndGet();
        }
    }

    private boolean f(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        g();
        if (this.b == null) {
            w63.b("efs.flow", "sharedpreferences is null, cann't get last flow stat", null);
            return false;
        }
        List<String> c = c(str, str2, str3);
        Map<String, String> i = C4783c.a().i();
        for (String str4 : c) {
            if (Math.abs(System.currentTimeMillis() - this.b.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                obtain.arg1 = Long.valueOf(j).intValue();
                sendMessage(obtain);
            }
            long a = a(i, str, str4);
            long j3 = this.b.getLong(str4, 0L);
            if (j3 + j2 > a) {
                w63.a("efs.flow", "flow limit, key: " + str4 + ", max: " + a + ", now: " + j3 + ", size: " + j2);
                d(str4);
                return false;
            }
        }
        return true;
    }

    private void g() {
        try {
            h();
        } catch (Throwable th) {
            w63.c("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void h() {
        if (this.b == null) {
            synchronized (HandlerC4790b.class) {
                if (this.b == null) {
                    this.b = C3236a.c(this.d, this.e.toLowerCase() + "_flow");
                }
            }
        }
        if (this.c == null) {
            synchronized (HandlerC4790b.class) {
                if (this.c == null) {
                    this.c = this.b.edit();
                }
            }
        }
    }

    public final boolean e(@NonNull String str, long j) {
        v43 v43Var;
        v43Var = v43.C9807a.a;
        String a = v43Var.a();
        boolean z = true;
        for (Map.Entry<String, Long> entry : f.entrySet()) {
            z = f(entry.getKey(), entry.getValue().longValue(), str, a, j);
            if (!z) {
                break;
            }
        }
        return z;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        v43 v43Var;
        super.handleMessage(message);
        int i = message.what;
        if (i == 0) {
            g();
            if (this.b == null) {
                w63.b("efs.flow", "sharedpreferences is null, cann't get last flow stat", null);
            } else if (this.c == null) {
                w63.b("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat", null);
            } else {
                String valueOf = String.valueOf(message.obj);
                long j = message.arg1;
                v43Var = v43.C9807a.a;
                String a = v43Var.a();
                for (String str : f.keySet()) {
                    String concat = "curr_time_".concat(String.valueOf(str));
                    if (!this.b.contains(concat)) {
                        this.c.putLong(concat, System.currentTimeMillis());
                    }
                    for (String str2 : c(str, valueOf, a)) {
                        this.c.putLong(str2, this.b.getLong(str2, 0L) + j);
                    }
                }
                this.c.apply();
            }
        } else if (i != 1) {
            w63.b("efs.flow", "flow stat listener not support action '" + message.what + "'", null);
        } else {
            String valueOf2 = String.valueOf(message.obj);
            long j2 = message.arg1;
            g();
            if (this.b == null) {
                w63.b("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp", null);
            } else if (this.c == null) {
                w63.b("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp", null);
            } else {
                String concat2 = "curr_time_".concat(valueOf2);
                if (Math.abs(System.currentTimeMillis() - this.b.getLong(concat2, System.currentTimeMillis())) >= j2) {
                    for (String str3 : this.b.getAll().keySet()) {
                        if (str3.startsWith(valueOf2)) {
                            this.c.putLong(str3, 0L);
                        }
                    }
                    this.c.putLong(concat2, System.currentTimeMillis());
                    this.c.apply();
                    this.a.clear();
                }
            }
        }
    }
}
