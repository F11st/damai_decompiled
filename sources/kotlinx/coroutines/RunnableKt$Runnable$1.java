package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public final class RunnableKt$Runnable$1 implements Runnable {
    final /* synthetic */ Function0 $block;

    public RunnableKt$Runnable$1(Function0 function0) {
        this.$block = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$block.invoke();
    }
}
