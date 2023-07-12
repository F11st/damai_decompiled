package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hg0;
import tb.no;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class OnUndeliveredElementKt {
    @NotNull
    public static final <E> Function1<Throwable, wt2> a(@NotNull final Function1<? super E, wt2> function1, final E e, @NotNull final CoroutineContext coroutineContext) {
        return new Function1<Throwable, wt2>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
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
            public final void invoke2(@NotNull Throwable th) {
                OnUndeliveredElementKt.b(Function1.this, e, coroutineContext);
            }
        };
    }

    public static final <E> void b(@NotNull Function1<? super E, wt2> function1, E e, @NotNull CoroutineContext coroutineContext) {
        UndeliveredElementException c = c(function1, e, null);
        if (c != null) {
            no.a(coroutineContext, c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E> UndeliveredElementException c(@NotNull Function1<? super E, wt2> function1, E e, @Nullable UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                hg0.a(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e, th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return c(function1, obj, undeliveredElementException);
    }
}
