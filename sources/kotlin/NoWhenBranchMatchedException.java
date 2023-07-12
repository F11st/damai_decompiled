package kotlin;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NoWhenBranchMatchedException extends RuntimeException {
    public NoWhenBranchMatchedException() {
    }

    public NoWhenBranchMatchedException(@Nullable String str) {
        super(str);
    }

    public NoWhenBranchMatchedException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public NoWhenBranchMatchedException(@Nullable Throwable th) {
        super(th);
    }
}
