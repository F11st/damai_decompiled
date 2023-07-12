package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.o1;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
/* loaded from: classes3.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    @NotNull
    public static final C8231b Key = C8231b.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.coroutines.ContinuationInterceptor$a */
    /* loaded from: classes3.dex */
    public static final class C8230a {
        @Nullable
        public static <E extends CoroutineContext.Element> E a(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<E> key) {
            b41.i(key, "key");
            if (key instanceof o1) {
                o1 o1Var = (o1) key;
                if (o1Var.a(continuationInterceptor.getKey())) {
                    E e = (E) o1Var.b(continuationInterceptor);
                    if (e instanceof CoroutineContext.Element) {
                        return e;
                    }
                    return null;
                }
                return null;
            } else if (ContinuationInterceptor.Key == key) {
                b41.g(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            } else {
                return null;
            }
        }

        @NotNull
        public static CoroutineContext b(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<?> key) {
            b41.i(key, "key");
            if (!(key instanceof o1)) {
                return ContinuationInterceptor.Key == key ? EmptyCoroutineContext.INSTANCE : continuationInterceptor;
            }
            o1 o1Var = (o1) key;
            return (!o1Var.a(continuationInterceptor.getKey()) || o1Var.b(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.coroutines.ContinuationInterceptor$b */
    /* loaded from: classes3.dex */
    public static final class C8231b implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ C8231b a = new C8231b();

        private C8231b() {
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key);

    @NotNull
    <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(@NotNull Continuation<?> continuation);
}
