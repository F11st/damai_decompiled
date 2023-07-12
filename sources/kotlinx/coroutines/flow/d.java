package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a<T> implements Flow<T> {
        final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.Flow
        @Nullable
        public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
            Object d;
            Object emit = flowCollector.emit(this.a, continuation);
            d = kotlin.coroutines.intrinsics.b.d();
            return emit == d ? emit : wt2.INSTANCE;
        }
    }

    @NotNull
    public static final <T> Flow<T> a(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        return new i(function2);
    }

    @NotNull
    public static final <T> Flow<T> b(T t) {
        return new a(t);
    }
}
