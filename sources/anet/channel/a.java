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
/* loaded from: classes.dex */
public final class a {
    private String a;
    private String b;
    private ENV c = ENV.ONLINE;
    private ISecurity d;
    private static Map<String, a> e = new HashMap();
    public static final a DEFAULT_CONFIG = new C0009a().f("[default]").c("[default]").e(ENV.ONLINE).a();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009a {
        private String a;
        private String b;
        private ENV c = ENV.ONLINE;
        private String d;
        private String e;

        public a a() {
            if (!TextUtils.isEmpty(this.b)) {
                synchronized (a.e) {
                    for (a aVar : a.e.values()) {
                        if (aVar.c == this.c && aVar.b.equals(this.b)) {
                            ALog.k("awcn.Config", "duplicated config exist!", null, "appkey", this.b, "env", this.c);
                            if (!TextUtils.isEmpty(this.a)) {
                                a.e.put(this.a, aVar);
                            }
                            return aVar;
                        }
                    }
                    a aVar2 = new a();
                    aVar2.b = this.b;
                    aVar2.c = this.c;
                    if (TextUtils.isEmpty(this.a)) {
                        aVar2.a = zh2.e(this.b, "$", this.c.toString());
                    } else {
                        aVar2.a = this.a;
                    }
                    if (!TextUtils.isEmpty(this.e)) {
                        aVar2.d = aa2.a().createNonSecurity(this.e);
                    } else {
                        aVar2.d = aa2.a().createSecurity(this.d);
                    }
                    synchronized (a.e) {
                        a.e.put(aVar2.a, aVar2);
                    }
                    return aVar2;
                }
            }
            throw new RuntimeException("appkey can not be null or empty!");
        }

        public C0009a b(String str) {
            this.e = str;
            return this;
        }

        public C0009a c(String str) {
            this.b = str;
            return this;
        }

        public C0009a d(String str) {
            this.d = str;
            return this;
        }

        public C0009a e(ENV env) {
            this.c = env;
            return this;
        }

        public C0009a f(String str) {
            this.a = str;
            return this;
        }
    }

    protected a() {
    }

    public static a j(String str, ENV env) {
        synchronized (e) {
            for (a aVar : e.values()) {
                if (aVar.c == env && aVar.b.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public static a k(String str) {
        a aVar;
        synchronized (e) {
            aVar = e.get(str);
        }
        return aVar;
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
