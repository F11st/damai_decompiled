package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class b implements Continuation<Object> {
    public static final b INSTANCE = new b();
    @NotNull
    private static final CoroutineContext a = EmptyCoroutineContext.INSTANCE;

    private b() {
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
    }
}
