package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.internal.b */
/* loaded from: classes11.dex */
final class C8683b implements Continuation<Object> {
    public static final C8683b INSTANCE = new C8683b();
    @NotNull
    private static final CoroutineContext a = EmptyCoroutineContext.INSTANCE;

    private C8683b() {
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
