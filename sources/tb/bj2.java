package tb;

import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class bj2 {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return new aj2(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return a(job);
    }
}
