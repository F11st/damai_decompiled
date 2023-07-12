package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import tb.no;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class y extends a<wt2> {
    public y(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean handleJobException(@NotNull Throwable th) {
        no.a(getContext(), th);
        return true;
    }
}
