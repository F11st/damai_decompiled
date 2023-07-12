package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import tb.tq2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class SafeCollectorKt {
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super wt2>, Object> a = (Function3) tq2.e(new SafeCollectorKt$emitFun$1(), 3);

    public static final /* synthetic */ Function3 a() {
        return a;
    }
}
