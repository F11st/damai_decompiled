package tb;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes8.dex */
public final class zk1 implements ChildHandle, DisposableHandle {
    public static final zk1 INSTANCE = new zk1();

    private zk1() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(@NotNull Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
