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
/* loaded from: classes8.dex */
public final /* synthetic */ class f {
    public static final <T> T a(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        m a;
        CoroutineContext c;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            a = pm2.INSTANCE.b();
            c = lo.c(ku0.INSTANCE, coroutineContext.plus(a));
        } else {
            if (!(continuationInterceptor instanceof m)) {
                continuationInterceptor = null;
            }
            m mVar = (m) continuationInterceptor;
            if (mVar != null) {
                m mVar2 = mVar.shouldBeProcessedFromContext() ? mVar : null;
                if (mVar2 != null) {
                    a = mVar2;
                    c = lo.c(ku0.INSTANCE, coroutineContext);
                }
            }
            a = pm2.INSTANCE.a();
            c = lo.c(ku0.INSTANCE, coroutineContext);
        }
        d dVar = new d(c, currentThread, a);
        dVar.start(CoroutineStart.DEFAULT, dVar, function2);
        return (T) dVar.a();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return e.c(coroutineContext, function2);
    }
}
