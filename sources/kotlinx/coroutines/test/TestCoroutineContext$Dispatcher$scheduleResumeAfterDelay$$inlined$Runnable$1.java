package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/wt2;", "run", "()V", "kotlinx/coroutines/RunnableKt$Runnable$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public final class TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $continuation$inlined;
    final /* synthetic */ C8718a this$0;

    public TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(C8718a c8718a, CancellableContinuation cancellableContinuation) {
        this.$continuation$inlined = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$continuation$inlined.resumeUndispatched(this.this$0, wt2.INSTANCE);
    }
}
