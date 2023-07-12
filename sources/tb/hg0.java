package tb;

import kotlin.SinceKotlin;
import kotlin.internal.HidesMembers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class hg0 {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable th2) {
        b41.i(th, "<this>");
        b41.i(th2, "exception");
        if (th != th2) {
            ts1.IMPLEMENTATIONS.a(th, th2);
        }
    }
}
