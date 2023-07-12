package tb;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class vl extends ul {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static <T extends Comparable<? super T>> T b(@NotNull T t, @NotNull T t2) {
        b41.i(t, "a");
        b41.i(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }
}
