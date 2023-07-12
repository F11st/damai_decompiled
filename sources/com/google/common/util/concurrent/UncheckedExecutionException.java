package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    protected UncheckedExecutionException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedExecutionException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@NullableDecl Throwable th) {
        super(th);
    }
}
