package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kj2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ThreadContextKt {
    private static final kj2 a = new kj2("ZERO");
    private static final Function2<Object, CoroutineContext.Element, Object> b = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@Nullable Object obj, @NotNull CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? element : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    };
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> c = new Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final ThreadContextElement<?> invoke(@Nullable ThreadContextElement<?> threadContextElement, @NotNull CoroutineContext.Element element) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (!(element instanceof ThreadContextElement)) {
                element = null;
            }
            return (ThreadContextElement) element;
        }
    };
    private static final Function2<C8695b, CoroutineContext.Element, C8695b> d = new Function2<C8695b, CoroutineContext.Element, C8695b>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final C8695b invoke(@NotNull C8695b c8695b, @NotNull CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                c8695b.a(((ThreadContextElement) element).updateThreadContext(c8695b.b()));
            }
            return c8695b;
        }
    };
    private static final Function2<C8695b, CoroutineContext.Element, C8695b> e = new Function2<C8695b, CoroutineContext.Element, C8695b>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$restoreState$1
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final C8695b invoke(@NotNull C8695b c8695b, @NotNull CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                ((ThreadContextElement) element).restoreThreadContext(c8695b.b(), c8695b.d());
            }
            return c8695b;
        }
    };

    public static final void a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof C8695b) {
            ((C8695b) obj).c();
            coroutineContext.fold(obj, e);
            return;
        }
        Object fold = coroutineContext.fold(null, c);
        Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
    }

    @NotNull
    public static final Object b(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        b41.f(fold);
        return fold;
    }

    @Nullable
    public static final Object c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new C8695b(coroutineContext, ((Number) obj).intValue()), d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
