package okhttp3;

import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class f {
    final okhttp3.internal.connection.f a;

    public f() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public f(int i, long j, TimeUnit timeUnit) {
        this.a = new okhttp3.internal.connection.f(i, j, timeUnit);
    }
}
