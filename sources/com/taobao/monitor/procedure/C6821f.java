package com.taobao.monitor.procedure;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.C9648rc;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.f */
/* loaded from: classes11.dex */
public class C6821f {
    private final String a;
    private final String b;
    private String c;
    private long d = SystemClock.uptimeMillis();
    private List<C6821f> e;
    private List<rf0> f;
    private List<qf2> g;
    private Map<String, Object> h;
    private Map<String, Object> i;
    private List<C9648rc> j;
    private Map<String, C9648rc> k;
    private Map<String, Integer> l;
    private final boolean m;
    private final boolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f(String str, boolean z, boolean z2) {
        int i;
        this.a = str;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1 && str.length() > (i = lastIndexOf + 1)) {
            this.b = str.substring(i);
        } else {
            this.b = str;
        }
        this.m = z;
        this.n = z2;
        l();
    }

    private void l() {
        this.e = new LinkedList();
        this.f = new LinkedList();
        this.g = new LinkedList();
        this.h = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new LinkedList();
        this.k = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f a(String str, Map<String, Object> map) {
        if (str != null) {
            C9648rc c9648rc = this.k.get(str);
            if (c9648rc == null) {
                c9648rc = new C9648rc(str, map);
                this.k.put(str, c9648rc);
                synchronized (this.j) {
                    this.j.add(c9648rc);
                }
            }
            c9648rc.c(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f b(String str, Map<String, Object> map) {
        if (str != null) {
            C9648rc c9648rc = this.k.get(str);
            if (c9648rc == null) {
                c9648rc = new C9648rc(str, null);
                this.k.put(str, c9648rc);
                synchronized (this.j) {
                    this.j.add(c9648rc);
                }
            }
            c9648rc.b(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f c(String str, Map<String, Object> map) {
        if (str != null) {
            C9648rc c9648rc = this.k.get(str);
            if (c9648rc == null) {
                c9648rc = new C9648rc(str, null);
                this.k.put(str, c9648rc);
                synchronized (this.j) {
                    this.j.add(c9648rc);
                }
            }
            c9648rc.d(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f d(String str, Object obj) {
        if (obj != null && str != null) {
            this.i.put(str, obj);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f e(String str) {
        this.c = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f f(String str, Object obj) {
        if (obj != null && str != null) {
            this.h.put(str, obj);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f g(C6821f c6821f) {
        if (c6821f != null) {
            String str = c6821f.b;
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Integer num = this.l.get(str);
            if (num == null) {
                this.l.put(str, 1);
            } else {
                this.l.put(str, Integer.valueOf(num.intValue() + 1));
            }
            if (c6821f.n) {
                for (qf2 qf2Var : c6821f.g) {
                    char[] charArray = qf2Var.a().toCharArray();
                    if (charArray[0] >= 'a') {
                        charArray[0] = (char) (charArray[0] - ' ');
                    }
                    String str2 = str + String.valueOf(charArray);
                    Integer num2 = this.l.get(str2);
                    if (num2 == null) {
                        this.l.put(str2, 1);
                    } else {
                        this.l.put(str2, Integer.valueOf(num2.intValue() + 1));
                    }
                }
            }
            synchronized (this.e) {
                if (!c6821f.m) {
                    this.e.add(c6821f);
                }
            }
        }
        return this;
    }

    public List<C9648rc> h() {
        return this.j;
    }

    public Map<String, Integer> i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f j(rf0 rf0Var) {
        if (rf0Var != null) {
            synchronized (this.f) {
                this.f.add(rf0Var);
            }
        }
        return this;
    }

    public List<rf0> k() {
        return this.f;
    }

    public Map<String, Object> m() {
        return this.i;
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f p(qf2 qf2Var) {
        if (qf2Var != null) {
            synchronized (this.g) {
                this.g.add(qf2Var);
            }
        }
        return this;
    }

    public List<qf2> q() {
        return this.g;
    }

    public Map<String, Object> r() {
        return this.h;
    }

    public List<C6821f> s() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6821f t() {
        C6821f c6821f = new C6821f(this.b, this.m, this.n);
        c6821f.g = this.g;
        c6821f.i = this.i;
        return c6821f;
    }

    public String toString() {
        return this.a;
    }

    public long u() {
        return this.d;
    }

    public String v() {
        return this.a;
    }
}
