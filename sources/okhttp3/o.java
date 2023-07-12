package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.l;
import tb.j01;
import tb.ue;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class o {
    final m a;
    final String b;
    final l c;
    @Nullable
    final p d;
    final Map<Class<?>, Object> e;
    @Nullable
    private volatile ue f;

    o(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.e();
        this.d = aVar.d;
        this.e = okhttp3.internal.a.v(aVar.e);
    }

    @Nullable
    public p a() {
        return this.d;
    }

    public ue b() {
        ue ueVar = this.f;
        if (ueVar != null) {
            return ueVar;
        }
        ue k = ue.k(this.c);
        this.f = k;
        return k;
    }

    @Nullable
    public String c(String str) {
        return this.c.c(str);
    }

    public List<String> d(String str) {
        return this.c.k(str);
    }

    public l e() {
        return this.c;
    }

    public boolean f() {
        return this.a.n();
    }

    public String g() {
        return this.b;
    }

    public a h() {
        return new a(this);
    }

    public m i() {
        return this.a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        m a;
        String b;
        l.a c;
        @Nullable
        p d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new l.a();
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public o b() {
            if (this.a != null) {
                return new o(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a c() {
            return f("GET", null);
        }

        public a d(String str, String str2) {
            this.c.h(str, str2);
            return this;
        }

        public a e(l lVar) {
            this.c = lVar.f();
            return this;
        }

        public a f(String str, @Nullable p pVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() != 0) {
                if (pVar != null && !j01.b(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                } else if (pVar == null && j01.e(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                } else {
                    this.b = str;
                    this.d = pVar;
                    return this;
                }
            }
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a g(p pVar) {
            return f("POST", pVar);
        }

        public a h(String str) {
            this.c.g(str);
            return this;
        }

        public <T> a i(Class<? super T> cls, @Nullable T t) {
            Objects.requireNonNull(cls, "type == null");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public a j(@Nullable Object obj) {
            return i(Object.class, obj);
        }

        public a k(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return l(m.l(str));
        }

        public a l(m mVar) {
            Objects.requireNonNull(mVar, "url == null");
            this.a = mVar;
            return this;
        }

        a(o oVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.a = oVar.a;
            this.b = oVar.b;
            this.d = oVar.d;
            if (oVar.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(oVar.e);
            }
            this.e = linkedHashMap;
            this.c = oVar.c.f();
        }
    }
}
