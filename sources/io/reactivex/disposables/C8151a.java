package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;

/* compiled from: Taobao */
/* renamed from: io.reactivex.disposables.a */
/* loaded from: classes3.dex */
public final class C8151a {
    @NonNull
    public static Disposable a() {
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    public static Disposable b() {
        return c(Functions.EMPTY_RUNNABLE);
    }

    @NonNull
    public static Disposable c(@NonNull Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
