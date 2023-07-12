package tb;

import javax.annotation.Nullable;
import okhttp3.AbstractC8829r;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ez1 extends AbstractC8829r {
    @Nullable
    private final String a;
    private final long b;
    private final BufferedSource c;

    public ez1(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.a = str;
        this.b = j;
        this.c = bufferedSource;
    }

    @Override // okhttp3.AbstractC8829r
    public long f() {
        return this.b;
    }

    @Override // okhttp3.AbstractC8829r
    public xd1 g() {
        String str = this.a;
        if (str != null) {
            return xd1.d(str);
        }
        return null;
    }

    @Override // okhttp3.AbstractC8829r
    public BufferedSource j() {
        return this.c;
    }
}
