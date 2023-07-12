package cn.damai.homepage.util.window.handle;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "cn.damai.homepage.util.window.handle.TopPriortyHandle", f = "TopPriortyHandle.kt", i = {0, 1, 2, 3, 4, 5, 6}, l = {68, 69, 77, 79, 82, 84, 89, 90}, m = "popHandle", n = {"this", "this", "this", "this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes5.dex */
public final class TopPriortyHandle$popHandle$1<T, K> extends ContinuationImpl {
    private static transient /* synthetic */ IpChange $ipChange;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TopPriortyHandle this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopPriortyHandle$popHandle$1(TopPriortyHandle topPriortyHandle, Continuation<? super TopPriortyHandle$popHandle$1> continuation) {
        super(continuation);
        this.this$0 = topPriortyHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090777120")) {
            return ipChange.ipc$dispatch("-1090777120", new Object[]{this, obj});
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.popHandle(null, null, this);
    }
}
