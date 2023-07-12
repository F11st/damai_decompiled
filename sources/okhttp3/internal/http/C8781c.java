package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.internal.C8753a;
import okhttp3.internal.connection.C8766c;
import okhttp3.internal.connection.C8776i;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.c */
/* loaded from: classes2.dex */
public final class C8781c implements Interceptor.Chain {
    private final List<Interceptor> a;
    private final C8776i b;
    @Nullable
    private final C8766c c;
    private final int d;
    private final C8823o e;
    private final Call f;
    private final int g;
    private final int h;
    private final int i;
    private int j;

    public C8781c(List<Interceptor> list, C8776i c8776i, @Nullable C8766c c8766c, int i, C8823o c8823o, Call call, int i2, int i3, int i4) {
        this.a = list;
        this.b = c8776i;
        this.c = c8766c;
        this.d = i;
        this.e = c8823o;
        this.f = call;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public C8766c a() {
        C8766c c8766c = this.c;
        if (c8766c != null) {
            return c8766c;
        }
        throw new IllegalStateException();
    }

    public C8827q b(C8823o c8823o, C8776i c8776i, @Nullable C8766c c8766c) throws IOException {
        if (this.d < this.a.size()) {
            this.j++;
            C8766c c8766c2 = this.c;
            if (c8766c2 != null && !c8766c2.c().s(c8823o.i())) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must retain the same host and port");
            } else if (this.c != null && this.j > 1) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must call proceed() exactly once");
            } else {
                C8781c c8781c = new C8781c(this.a, c8776i, c8766c, this.d + 1, c8823o, this.f, this.g, this.h, this.i);
                Interceptor interceptor = this.a.get(this.d);
                C8827q intercept = interceptor.intercept(c8781c);
                if (c8766c != null && this.d + 1 < this.a.size() && c8781c.j != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    if (intercept.a() != null) {
                        return intercept;
                    }
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                } else {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                }
            }
        }
        throw new AssertionError();
    }

    public C8776i c() {
        return this.b;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.f;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.g;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        C8766c c8766c = this.c;
        if (c8766c != null) {
            return c8766c.c();
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public C8827q proceed(C8823o c8823o) throws IOException {
        return b(c8823o, this.b, this.c);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.h;
    }

    @Override // okhttp3.Interceptor.Chain
    public C8823o request() {
        return this.e;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new C8781c(this.a, this.b, this.c, this.d, this.e, this.f, C8753a.e("timeout", i, timeUnit), this.h, this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new C8781c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, C8753a.e("timeout", i, timeUnit), this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new C8781c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, C8753a.e("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.i;
    }
}
