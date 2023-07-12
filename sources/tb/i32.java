package tb;

import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i32 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final Object a(@NotNull Throwable th) {
        b41.i(th, "exception");
        return new Result.Failure(th);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void b(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
