package kotlin;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(@NotNull String str) {
        super(str);
        b41.i(str, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, k50 k50Var) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
