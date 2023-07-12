package tb;

import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.text.C8590b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "UnsignedKt")
/* loaded from: classes3.dex */
public final class du2 {
    @PublishedApi
    public static final int a(int i, int i2) {
        return b41.k(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int b(long j, long j2) {
        return b41.l(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @NotNull
    public static final String c(long j) {
        return d(j, 10);
    }

    @NotNull
    public static final String d(long j, int i) {
        int a;
        int a2;
        int a3;
        if (j >= 0) {
            a3 = C8590b.a(i);
            String l = Long.toString(j, a3);
            b41.h(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        a = C8590b.a(i);
        String l2 = Long.toString(j3, a);
        b41.h(l2, "toString(this, checkRadix(radix))");
        sb.append(l2);
        a2 = C8590b.a(i);
        String l3 = Long.toString(j4, a2);
        b41.h(l3, "toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
