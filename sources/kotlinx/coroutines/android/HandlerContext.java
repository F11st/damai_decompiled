package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hd0;
import tb.k50;
import tb.kv0;
import tb.ty1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class HandlerContext extends kv0 {
    private volatile HandlerContext _immediate;
    @NotNull
    private final HandlerContext a;
    private final Handler b;
    private final String c;
    private final boolean d;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements DisposableHandle {
        final /* synthetic */ Runnable b;

        a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            HandlerContext.this.b.removeCallbacks(this.b);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.b = handler;
        this.c = str;
        this.d = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
            wt2 wt2Var = wt2.INSTANCE;
        }
        this.a = handlerContext;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // tb.uc1
    @NotNull
    /* renamed from: e */
    public HandlerContext a() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }

    @Override // tb.kv0, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        long e;
        Handler handler = this.b;
        e = ty1.e(j, hd0.MAX_MILLIS);
        handler.postDelayed(runnable, e);
        return new a(runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return !this.d || (b41.d(Looper.myLooper(), this.b.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long j, @NotNull final CancellableContinuation<? super wt2> cancellableContinuation) {
        long e;
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                cancellableContinuation.resumeUndispatched(HandlerContext.this, wt2.INSTANCE);
            }
        };
        Handler handler = this.b;
        e = ty1.e(j, hd0.MAX_MILLIS);
        handler.postDelayed(runnable, e);
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, wt2>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
                invoke2(th);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                HandlerContext.this.b.removeCallbacks(runnable);
            }
        });
    }

    @Override // tb.uc1, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String c = c();
        if (c != null) {
            return c;
        }
        String str = this.c;
        if (str == null) {
            str = this.b.toString();
        }
        if (this.d) {
            return str + ".immediate";
        }
        return str;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, k50 k50Var) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
