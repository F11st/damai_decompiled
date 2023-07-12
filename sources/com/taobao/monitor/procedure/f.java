package com.taobao.monitor.procedure;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.qf2;
import tb.rc;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f {
    private final String a;
    private final String b;
    private String c;
    private long d = SystemClock.uptimeMillis();
    private List<f> e;
    private List<rf0> f;
    private List<qf2> g;
    private Map<String, Object> h;
    private Map<String, Object> i;
    private List<rc> j;
    private Map<String, rc> k;
    private Map<String, Integer> l;
    private final boolean m;
    private final boolean n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, boolean z, boolean z2) {
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
    public f a(String str, Map<String, Object> map) {
        if (str != null) {
            rc rcVar = this.k.get(str);
            if (rcVar == null) {
                rcVar = new rc(str, map);
                this.k.put(str, rcVar);
                synchronized (this.j) {
                    this.j.add(rcVar);
                }
            }
            rcVar.c(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(String str, Map<String, Object> map) {
        if (str != null) {
            rc rcVar = this.k.get(str);
            if (rcVar == null) {
                rcVar = new rc(str, null);
                this.k.put(str, rcVar);
                synchronized (this.j) {
                    this.j.add(rcVar);
                }
            }
            rcVar.b(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f c(String str, Map<String, Object> map) {
        if (str != null) {
            rc rcVar = this.k.get(str);
            if (rcVar == null) {
                rcVar = new rc(str, null);
                this.k.put(str, rcVar);
                synchronized (this.j) {
                    this.j.add(rcVar);
                }
            }
            rcVar.d(map);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d(String str, Object obj) {
        if (obj != null && str != null) {
            this.i.put(str, obj);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f e(String str) {
        this.c = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f f(String str, Object obj) {
        if (obj != null && str != null) {
            this.h.put(str, obj);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g(f fVar) {
        if (fVar != null) {
            String str = fVar.b;
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Integer num = this.l.get(str);
            if (num == null) {
                this.l.put(str, 1);
            } else {
                this.l.put(str, Integer.valueOf(num.intValue() + 1));
            }
            if (fVar.n) {
                for (qf2 qf2Var : fVar.g) {
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
                if (!fVar.m) {
                    this.e.add(fVar);
                }
            }
        }
        return this;
    }

    public List<rc> h() {
        return this.j;
    }

    public Map<String, Integer> i() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f j(rf0 rf0Var) {
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
    public f p(qf2 qf2Var) {
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

    public List<f> s() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f t() {
        f fVar = new f(this.b, this.m, this.n);
        fVar.g = this.g;
        fVar.i = this.i;
        return fVar;
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
