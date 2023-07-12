package tb;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c61 extends JobSupport implements CompletableJob {
    private final boolean a;

    public c61(@Nullable Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
        this.a = a();
    }

    private final boolean a() {
        JobSupport jobSupport;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (!(parentHandle$kotlinx_coroutines_core instanceof C9441mi)) {
            parentHandle$kotlinx_coroutines_core = null;
        }
        C9441mi c9441mi = (C9441mi) parentHandle$kotlinx_coroutines_core;
        if (c9441mi != null && (jobSupport = (JobSupport) c9441mi.d) != null) {
            while (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle parentHandle$kotlinx_coroutines_core2 = jobSupport.getParentHandle$kotlinx_coroutines_core();
                if (!(parentHandle$kotlinx_coroutines_core2 instanceof C9441mi)) {
                    parentHandle$kotlinx_coroutines_core2 = null;
                }
                C9441mi c9441mi2 = (C9441mi) parentHandle$kotlinx_coroutines_core2;
                if (c9441mi2 != null) {
                    jobSupport = (JobSupport) c9441mi2.d;
                    if (jobSupport == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(wt2.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(@NotNull Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new am(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.a;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
