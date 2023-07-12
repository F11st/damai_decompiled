package kotlin.concurrent;

import kotlin.jvm.functions.Function0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ThreadsKt$thread$thread$1 extends Thread {
    final /* synthetic */ Function0<wt2> $block;

    ThreadsKt$thread$thread$1(Function0<wt2> function0) {
        this.$block = function0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.$block.invoke();
    }
}
