package tb;

import java.util.Objects;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class f61<J extends Job> extends cm implements DisposableHandle, Incomplete {
    @JvmField
    @NotNull
    public final J d;

    public f61(@NotNull J j) {
        this.d = j;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        J j = this.d;
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        ((JobSupport) j).removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.Incomplete
    @Nullable
    public xk1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }
}
