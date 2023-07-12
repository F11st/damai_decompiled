package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.a.C5945b;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.c.a.EnumC5952e;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.c.h.C5996a;
import com.meizu.cloud.pushsdk.c.h.C5997b;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.e.c */
/* loaded from: classes10.dex */
public final class C5978c {
    public static <T> C5950c<T> a(C5945b c5945b) {
        int g = c5945b.g();
        return g != 0 ? g != 1 ? g != 2 ? new C5950c<>(new C5953a()) : d(c5945b) : c(c5945b) : b(c5945b);
    }

    private static <T> C5950c<T> b(C5945b c5945b) {
        try {
            try {
                C5971k a = C5976a.a(c5945b);
                if (a == null) {
                    C5950c<T> c5950c = new C5950c<>(C5997b.a(new C5953a()));
                    C5996a.a(a, c5945b);
                    return c5950c;
                } else if (c5945b.f() == EnumC5952e.OK_HTTP_RESPONSE) {
                    C5950c<T> c5950c2 = new C5950c<>(a);
                    c5950c2.a(a);
                    C5996a.a(a, c5945b);
                    return c5950c2;
                } else if (a.a() >= 400) {
                    C5950c<T> c5950c3 = new C5950c<>(C5997b.a(new C5953a(a), c5945b, a.a()));
                    c5950c3.a(a);
                    C5996a.a(a, c5945b);
                    return c5950c3;
                } else {
                    C5950c<T> a2 = c5945b.a(a);
                    a2.a(a);
                    C5996a.a(a, c5945b);
                    return a2;
                }
            } catch (C5953a e) {
                C5950c<T> c5950c4 = new C5950c<>(C5997b.a(new C5953a(e)));
                C5996a.a(null, c5945b);
                return c5950c4;
            } catch (Exception e2) {
                C5950c<T> c5950c5 = new C5950c<>(C5997b.a(e2));
                C5996a.a(null, c5945b);
                return c5950c5;
            }
        } catch (Throwable th) {
            C5996a.a(null, c5945b);
            throw th;
        }
    }

    private static <T> C5950c<T> c(C5945b c5945b) {
        try {
            C5971k b = C5976a.b(c5945b);
            if (b == null) {
                return new C5950c<>(C5997b.a(new C5953a()));
            }
            if (b.a() >= 400) {
                C5950c<T> c5950c = new C5950c<>(C5997b.a(new C5953a(b), c5945b, b.a()));
                c5950c.a(b);
                return c5950c;
            }
            C5950c<T> c5950c2 = new C5950c<>("success");
            c5950c2.a(b);
            return c5950c2;
        } catch (C5953a e) {
            return new C5950c<>(C5997b.a(new C5953a(e)));
        } catch (Exception e2) {
            return new C5950c<>(C5997b.a(e2));
        }
    }

    private static <T> C5950c<T> d(C5945b c5945b) {
        try {
            try {
                C5971k c = C5976a.c(c5945b);
                if (c == null) {
                    C5950c<T> c5950c = new C5950c<>(C5997b.a(new C5953a()));
                    C5996a.a(c, c5945b);
                    return c5950c;
                } else if (c5945b.f() == EnumC5952e.OK_HTTP_RESPONSE) {
                    C5950c<T> c5950c2 = new C5950c<>(c);
                    c5950c2.a(c);
                    C5996a.a(c, c5945b);
                    return c5950c2;
                } else if (c.a() >= 400) {
                    C5950c<T> c5950c3 = new C5950c<>(C5997b.a(new C5953a(c), c5945b, c.a()));
                    c5950c3.a(c);
                    C5996a.a(c, c5945b);
                    return c5950c3;
                } else {
                    C5950c<T> a = c5945b.a(c);
                    a.a(c);
                    C5996a.a(c, c5945b);
                    return a;
                }
            } catch (C5953a e) {
                C5950c<T> c5950c4 = new C5950c<>(C5997b.a(e));
                C5996a.a(null, c5945b);
                return c5950c4;
            } catch (Exception e2) {
                C5950c<T> c5950c5 = new C5950c<>(C5997b.a(e2));
                C5996a.a(null, c5945b);
                return c5950c5;
            }
        } catch (Throwable th) {
            C5996a.a(null, c5945b);
            throw th;
        }
    }
}
