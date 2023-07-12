package io.reactivex.disposables;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.reactivex.annotations.NonNull;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + AVFSCacheConstants.COMMA_SEP + get() + jn1.BRACKET_END_STR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Runnable runnable) {
        runnable.run();
    }
}
