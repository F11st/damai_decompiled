package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.eg;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.t */
/* loaded from: classes8.dex */
public final class C8717t extends C8723y {
    private final Continuation<wt2> a;

    public C8717t(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super wt2>, ? extends Object> function2) {
        super(coroutineContext, false);
        Continuation<wt2> b;
        b = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
        this.a = b;
    }

    @Override // kotlinx.coroutines.AbstractC8619a
    protected void onStart() {
        eg.a(this.a, this);
    }
}
