package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.C8816l;
import okhttp3.internal.C8753a;
import tb.j01;
import tb.ue;

/* compiled from: Taobao */
/* renamed from: okhttp3.o */
/* loaded from: classes2.dex */
public final class C8823o {
    final C8818m a;
    final String b;
    final C8816l c;
    @Nullable
    final AbstractC8825p d;
    final Map<Class<?>, Object> e;
    @Nullable
    private volatile ue f;

    C8823o(C8824a c8824a) {
        this.a = c8824a.a;
        this.b = c8824a.b;
        this.c = c8824a.c.e();
        this.d = c8824a.d;
        this.e = C8753a.v(c8824a.e);
    }

    @Nullable
    public AbstractC8825p a() {
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

    public C8816l e() {
        return this.c;
    }

    public boolean f() {
        return this.a.n();
    }

    public String g() {
        return this.b;
    }

    public C8824a h() {
        return new C8824a(this);
    }

    public C8818m i() {
        return this.a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.o$a */
    /* loaded from: classes2.dex */
    public static class C8824a {
        @Nullable
        C8818m a;
        String b;
        C8816l.C8817a c;
        @Nullable
        AbstractC8825p d;
        Map<Class<?>, Object> e;

        public C8824a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new C8816l.C8817a();
        }

        public C8824a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public C8823o b() {
            if (this.a != null) {
                return new C8823o(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C8824a c() {
            return f("GET", null);
        }

        public C8824a d(String str, String str2) {
            this.c.h(str, str2);
            return this;
        }

        public C8824a e(C8816l c8816l) {
            this.c = c8816l.f();
            return this;
        }

        public C8824a f(String str, @Nullable AbstractC8825p abstractC8825p) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() != 0) {
                if (abstractC8825p != null && !j01.b(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                } else if (abstractC8825p == null && j01.e(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                } else {
                    this.b = str;
                    this.d = abstractC8825p;
                    return this;
                }
            }
            throw new IllegalArgumentException("method.length() == 0");
        }

        public C8824a g(AbstractC8825p abstractC8825p) {
            return f("POST", abstractC8825p);
        }

        public C8824a h(String str) {
            this.c.g(str);
            return this;
        }

        public <T> C8824a i(Class<? super T> cls, @Nullable T t) {
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

        public C8824a j(@Nullable Object obj) {
            return i(Object.class, obj);
        }

        public C8824a k(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return l(C8818m.l(str));
        }

        public C8824a l(C8818m c8818m) {
            Objects.requireNonNull(c8818m, "url == null");
            this.a = c8818m;
            return this;
        }

        C8824a(C8823o c8823o) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.a = c8823o.a;
            this.b = c8823o.b;
            this.d = c8823o.d;
            if (c8823o.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c8823o.e);
            }
            this.e = linkedHashMap;
            this.c = c8823o.c.f();
        }
    }
}
