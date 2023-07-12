package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class b {
    private Object[] a;
    private int b;
    @NotNull
    private final CoroutineContext c;

    public b(@NotNull CoroutineContext coroutineContext, int i) {
        this.c = coroutineContext;
        this.a = new Object[i];
    }

    public final void a(@Nullable Object obj) {
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    @NotNull
    public final CoroutineContext b() {
        return this.c;
    }

    public final void c() {
        this.b = 0;
    }

    @Nullable
    public final Object d() {
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return objArr[i];
    }
}
