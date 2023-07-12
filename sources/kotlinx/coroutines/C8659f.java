package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.ku0;
import tb.lo;
import tb.pm2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.f */
/* loaded from: classes8.dex */
public final /* synthetic */ class C8659f {
    public static final <T> T a(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        AbstractC8699m a;
        CoroutineContext c;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            a = pm2.INSTANCE.b();
            c = lo.c(ku0.INSTANCE, coroutineContext.plus(a));
        } else {
            if (!(continuationInterceptor instanceof AbstractC8699m)) {
                continuationInterceptor = null;
            }
            AbstractC8699m abstractC8699m = (AbstractC8699m) continuationInterceptor;
            if (abstractC8699m != null) {
                AbstractC8699m abstractC8699m2 = abstractC8699m.shouldBeProcessedFromContext() ? abstractC8699m : null;
                if (abstractC8699m2 != null) {
                    a = abstractC8699m2;
                    c = lo.c(ku0.INSTANCE, coroutineContext);
                }
            }
            a = pm2.INSTANCE.a();
            c = lo.c(ku0.INSTANCE, coroutineContext);
        }
        C8649d c8649d = new C8649d(c, currentThread, a);
        c8649d.start(CoroutineStart.DEFAULT, c8649d, function2);
        return (T) c8649d.a();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return C8658e.c(coroutineContext, function2);
    }
}
