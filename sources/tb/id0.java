package tb;

import kotlin.SinceKotlin;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class id0 {
    @SinceKotlin(version = "1.5")
    public static final long a(long j, @NotNull DurationUnit durationUnit, @NotNull DurationUnit durationUnit2) {
        b41.i(durationUnit, "sourceUnit");
        b41.i(durationUnit2, "targetUnit");
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j, durationUnit.getTimeUnit$kotlin_stdlib());
    }
}
