package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: tb.rc */
/* loaded from: classes11.dex */
public class C9648rc {
    private final String a;
    private Map<String, Object> b;
    private Map<String, Object> c;
    private Map<String, Object> d;

    public C9648rc(String str, Map<String, Object> map) {
        this.a = str;
        this.b = map;
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public C9648rc b(Map<String, Object> map) {
        if (map == null) {
            return this;
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.putAll(map);
        return this;
    }

    public C9648rc c(Map<String, Object> map) {
        if (map == null) {
            return this;
        }
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.putAll(map);
        return this;
    }

    public C9648rc d(Map<String, Object> map) {
        if (map == null) {
            return this;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.putAll(map);
        return this;
    }

    public String e() {
        return this.a;
    }

    public Map<String, Object> f() {
        return this.b;
    }

    public Map<String, Object> g() {
        return this.d;
    }

    public String toString() {
        return this.a;
    }
}
