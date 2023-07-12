package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.l;
import tb.ue;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class q implements Closeable {
    final o a;
    final Protocol b;
    final int c;
    final String d;
    @Nullable
    final k e;
    final l f;
    @Nullable
    final r g;
    @Nullable
    final q h;
    @Nullable
    final q i;
    @Nullable
    final q j;
    final long k;
    final long l;
    @Nullable
    final okhttp3.internal.connection.c m;
    @Nullable
    private volatile ue n;

    q(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.e();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    @Nullable
    public r a() {
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
        r rVar = this.g;
        if (rVar != null) {
            rVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int e() {
        return this.c;
    }

    @Nullable
    public k f() {
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

    public l j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    @Nullable
    public q l() {
        return this.h;
    }

    public a m() {
        return new a(this);
    }

    @Nullable
    public q n() {
        return this.j;
    }

    public Protocol o() {
        return this.b;
    }

    public long p() {
        return this.l;
    }

    public o q() {
        return this.a;
    }

    public long r() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.i() + '}';
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        o a;
        @Nullable
        Protocol b;
        int c;
        String d;
        @Nullable
        k e;
        l.a f;
        @Nullable
        r g;
        @Nullable
        q h;
        @Nullable
        q i;
        @Nullable
        q j;
        long k;
        long l;
        @Nullable
        okhttp3.internal.connection.c m;

        public a() {
            this.c = -1;
            this.f = new l.a();
        }

        private void e(q qVar) {
            if (qVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, q qVar) {
            if (qVar.g == null) {
                if (qVar.h == null) {
                    if (qVar.i == null) {
                        if (qVar.j == null) {
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

        public a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a b(@Nullable r rVar) {
            this.g = rVar;
            return this;
        }

        public q c() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.c >= 0) {
                        if (this.d != null) {
                            return new q(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public a d(@Nullable q qVar) {
            if (qVar != null) {
                f("cacheResponse", qVar);
            }
            this.i = qVar;
            return this;
        }

        public a g(int i) {
            this.c = i;
            return this;
        }

        public a h(@Nullable k kVar) {
            this.e = kVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f.h(str, str2);
            return this;
        }

        public a j(l lVar) {
            this.f = lVar.f();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k(okhttp3.internal.connection.c cVar) {
            this.m = cVar;
        }

        public a l(String str) {
            this.d = str;
            return this;
        }

        public a m(@Nullable q qVar) {
            if (qVar != null) {
                f("networkResponse", qVar);
            }
            this.h = qVar;
            return this;
        }

        public a n(@Nullable q qVar) {
            if (qVar != null) {
                e(qVar);
            }
            this.j = qVar;
            return this;
        }

        public a o(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public a p(long j) {
            this.l = j;
            return this;
        }

        public a q(o oVar) {
            this.a = oVar;
            return this;
        }

        public a r(long j) {
            this.k = j;
            return this;
        }

        a(q qVar) {
            this.c = -1;
            this.a = qVar.a;
            this.b = qVar.b;
            this.c = qVar.c;
            this.d = qVar.d;
            this.e = qVar.e;
            this.f = qVar.f.f();
            this.g = qVar.g;
            this.h = qVar.h;
            this.i = qVar.i;
            this.j = qVar.j;
            this.k = qVar.k;
            this.l = qVar.l;
            this.m = qVar.m;
        }
    }
}
