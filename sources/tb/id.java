package tb;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "Boxing")
/* loaded from: classes3.dex */
public final class id {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Boolean a(boolean z) {
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Double b(double d) {
        return new Double(d);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Integer c(int i) {
        return new Integer(i);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Long d(long j) {
        return new Long(j);
    }
}
