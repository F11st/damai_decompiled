package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C8772f;

/* compiled from: Taobao */
/* renamed from: okhttp3.f */
/* loaded from: classes2.dex */
public final class C8748f {
    final C8772f a;

    public C8748f() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public C8748f(int i, long j, TimeUnit timeUnit) {
        this.a = new C8772f(i, j, timeUnit);
    }
}
