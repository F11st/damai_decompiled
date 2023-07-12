package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class z31 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T b(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        try {
            tm2 tm2Var = new tm2(d61.h(coroutineContext));
            tm2Var.d();
            T invoke = function0.invoke();
            tm2Var.a();
            return invoke;
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
