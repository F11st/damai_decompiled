package tb;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class lv0 {
    @JvmField
    @Nullable
    public static final kv0 Main;
    private static volatile Choreographer choreographer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements Choreographer.FrameCallback {
        final /* synthetic */ CancellableContinuation a;

        a(CancellableContinuation cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            this.a.resumeUndispatched(da0.c(), Long.valueOf(j));
        }
    }

    static {
        Object m1271constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(new HandlerContext(b(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        Main = Result.m1277isFailureimpl(m1271constructorimpl) ? null : m1271constructorimpl;
    }

    @VisibleForTesting
    @NotNull
    public static final Handler b(@NotNull Looper looper, boolean z) {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    private static final void c(Choreographer choreographer2, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new a(cancellableContinuation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            b41.f(choreographer2);
            choreographer = choreographer2;
        }
        c(choreographer2, cancellableContinuation);
    }
}
