package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C8694a;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dm;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.a0 */
/* loaded from: classes8.dex */
public final class C8620a0<T> extends C8694a<T> {
    public C8620a0(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // kotlinx.coroutines.internal.C8694a, kotlinx.coroutines.AbstractC8619a
    protected void afterResume(@Nullable Object obj) {
        Object a = dm.a(obj, this.uCont);
        CoroutineContext context = this.uCont.getContext();
        Object c = ThreadContextKt.c(context, null);
        try {
            this.uCont.resumeWith(a);
            wt2 wt2Var = wt2.INSTANCE;
        } finally {
            ThreadContextKt.a(context, c);
        }
    }
}
