package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ParentJob;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: tb.mi */
/* loaded from: classes8.dex */
public final class C9441mi extends b61<JobSupport> implements ChildHandle {
    @JvmField
    @NotNull
    public final ChildJob e;

    public C9441mi(@NotNull JobSupport jobSupport, @NotNull ChildJob childJob) {
        super(jobSupport);
        this.e = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable th) {
        return ((JobSupport) this.d).childCancelled(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        this.e.parentCancelled((ParentJob) this.d);
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "ChildHandle[" + this.e + jn1.ARRAY_END;
    }
}
