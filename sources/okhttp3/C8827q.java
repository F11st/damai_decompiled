package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.C8816l;
import okhttp3.internal.connection.C8766c;
import tb.ue;

/* compiled from: Taobao */
/* renamed from: okhttp3.q */
/* loaded from: classes2.dex */
public final class C8827q implements Closeable {
    final C8823o a;
    final Protocol b;
    final int c;
    final String d;
    @Nullable
    final C8815k e;
    final C8816l f;
    @Nullable
    final AbstractC8829r g;
    @Nullable
    final C8827q h;
    @Nullable
    final C8827q i;
    @Nullable
    final C8827q j;
    final long k;
    final long l;
    @Nullable
    final C8766c m;
    @Nullable
    private volatile ue n;

    C8827q(C8828a c8828a) {
        this.a = c8828a.a;
        this.b = c8828a.b;
        this.c = c8828a.c;
        this.d = c8828a.d;
        this.e = c8828a.e;
        this.f = c8828a.f.e();
        this.g = c8828a.g;
        this.h = c8828a.h;
        this.i = c8828a.i;
        this.j = c8828a.j;
        this.k = c8828a.k;
        this.l = c8828a.l;
        this.m = c8828a.m;
    }

    @Nullable
    public AbstractC8829r a() {
        return this.g;
    }

    public ue c() {
        ue ueVar = this.n;
        if (ueVar != null) {
            return ueVar;
        }
        ue k = ue.k(this.f);
        this.n = k;
        return k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC8829r abstractC8829r = this.g;
        if (abstractC8829r != null) {
            abstractC8829r.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int e() {
        return this.c;
    }

    @Nullable
    public C8815k f() {
        return this.e;
    }

    @Nullable
    public String g(String str) {
        return h(str, null);
    }

    @Nullable
    public String h(String str, @Nullable String str2) {
        String c = this.f.c(str);
        return c != null ? c : str2;
    }

    public boolean isSuccessful() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public C8816l j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    @Nullable
    public C8827q l() {
        return this.h;
    }

    public C8828a m() {
        return new C8828a(this);
    }

    @Nullable
    public C8827q n() {
        return this.j;
    }

    public Protocol o() {
        return this.b;
    }

    public long p() {
        return this.l;
    }

    public C8823o q() {
        return this.a;
    }

    public long r() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.i() + '}';
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.q$a */
    /* loaded from: classes2.dex */
    public static class C8828a {
        @Nullable
        C8823o a;
        @Nullable
        Protocol b;
        int c;
        String d;
        @Nullable
        C8815k e;
        C8816l.C8817a f;
        @Nullable
        AbstractC8829r g;
        @Nullable
        C8827q h;
        @Nullable
        C8827q i;
        @Nullable
        C8827q j;
        long k;
        long l;
        @Nullable
        C8766c m;

        public C8828a() {
            this.c = -1;
            this.f = new C8816l.C8817a();
        }

        private void e(C8827q c8827q) {
            if (c8827q.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, C8827q c8827q) {
            if (c8827q.g == null) {
                if (c8827q.h == null) {
                    if (c8827q.i == null) {
                        if (c8827q.j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public C8828a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public C8828a b(@Nullable AbstractC8829r abstractC8829r) {
            this.g = abstractC8829r;
            return this;
        }

        public C8827q c() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.d != null) {
                            return new C8827q(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public C8828a d(@Nullable C8827q c8827q) {
            if (c8827q != null) {
                f("cacheResponse", c8827q);
            }
            this.i = c8827q;
            return this;
        }

        public C8828a g(int i) {
            this.c = i;
            return this;
        }

        public C8828a h(@Nullable C8815k c8815k) {
            this.e = c8815k;
            return this;
        }

        public C8828a i(String str, String str2) {
            this.f.h(str, str2);
            return this;
        }

        public C8828a j(C8816l c8816l) {
            this.f = c8816l.f();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k(C8766c c8766c) {
            this.m = c8766c;
        }

        public C8828a l(String str) {
            this.d = str;
            return this;
        }

        public C8828a m(@Nullable C8827q c8827q) {
            if (c8827q != null) {
                f("networkResponse", c8827q);
            }
            this.h = c8827q;
            return this;
        }

        public C8828a n(@Nullable C8827q c8827q) {
            if (c8827q != null) {
                e(c8827q);
            }
            this.j = c8827q;
            return this;
        }

        public C8828a o(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public C8828a p(long j) {
            this.l = j;
            return this;
        }

        public C8828a q(C8823o c8823o) {
            this.a = c8823o;
            return this;
        }

        public C8828a r(long j) {
            this.k = j;
            return this;
        }

        C8828a(C8827q c8827q) {
            this.c = -1;
            this.a = c8827q.a;
            this.b = c8827q.b;
            this.c = c8827q.c;
            this.d = c8827q.d;
            this.e = c8827q.e;
            this.f = c8827q.f.f();
            this.g = c8827q.g;
            this.h = c8827q.h;
            this.i = c8827q.i;
            this.j = c8827q.j;
            this.k = c8827q.k;
            this.l = c8827q.l;
            this.m = c8827q.m;
        }
    }
}
