package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.Map;
import tb.aa2;
import tb.zh2;

/* compiled from: Taobao */
/* renamed from: anet.channel.a */
/* loaded from: classes.dex */
public final class C0159a {
    private String a;
    private String b;
    private ENV c = ENV.ONLINE;
    private ISecurity d;
    private static Map<String, C0159a> e = new HashMap();
    public static final C0159a DEFAULT_CONFIG = new C0160a().f("[default]").c("[default]").e(ENV.ONLINE).a();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.a$a */
    /* loaded from: classes.dex */
    public static class C0160a {
        private String a;
        private String b;
        private ENV c = ENV.ONLINE;
        private String d;
        private String e;

        public C0159a a() {
            if (!TextUtils.isEmpty(this.b)) {
                synchronized (C0159a.e) {
                    for (C0159a c0159a : C0159a.e.values()) {
                        if (c0159a.c == this.c && c0159a.b.equals(this.b)) {
                            ALog.k("awcn.Config", "duplicated config exist!", null, "appkey", this.b, "env", this.c);
                            if (!TextUtils.isEmpty(this.a)) {
                                C0159a.e.put(this.a, c0159a);
                            }
                            return c0159a;
                        }
                    }
                    C0159a c0159a2 = new C0159a();
                    c0159a2.b = this.b;
                    c0159a2.c = this.c;
                    if (TextUtils.isEmpty(this.a)) {
                        c0159a2.a = zh2.e(this.b, "$", this.c.toString());
                    } else {
                        c0159a2.a = this.a;
                    }
                    if (!TextUtils.isEmpty(this.e)) {
                        c0159a2.d = aa2.a().createNonSecurity(this.e);
                    } else {
                        c0159a2.d = aa2.a().createSecurity(this.d);
                    }
                    synchronized (C0159a.e) {
                        C0159a.e.put(c0159a2.a, c0159a2);
                    }
                    return c0159a2;
                }
            }
            throw new RuntimeException("appkey can not be null or empty!");
        }

        public C0160a b(String str) {
            this.e = str;
            return this;
        }

        public C0160a c(String str) {
            this.b = str;
            return this;
        }

        public C0160a d(String str) {
            this.d = str;
            return this;
        }

        public C0160a e(ENV env) {
            this.c = env;
            return this;
        }

        public C0160a f(String str) {
            this.a = str;
            return this;
        }
    }

    protected C0159a() {
    }

    public static C0159a j(String str, ENV env) {
        synchronized (e) {
            for (C0159a c0159a : e.values()) {
                if (c0159a.c == env && c0159a.b.equals(str)) {
                    return c0159a;
                }
            }
            return null;
        }
    }

    public static C0159a k(String str) {
        C0159a c0159a;
        synchronized (e) {
            c0159a = e.get(str);
        }
        return c0159a;
    }

    public String i() {
        return this.b;
    }

    public ENV l() {
        return this.c;
    }

    public ISecurity m() {
        return this.d;
    }

    public String toString() {
        return this.a;
    }
}
