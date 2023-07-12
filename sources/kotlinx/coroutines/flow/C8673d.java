package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.d */
/* loaded from: classes11.dex */
public final /* synthetic */ class C8673d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.flow.d$a */
    /* loaded from: classes11.dex */
    public static final class C8674a<T> implements Flow<T> {
        final /* synthetic */ Object a;

        public C8674a(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.Flow
        @Nullable
        public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
            Object d;
            Object emit = flowCollector.emit(this.a, continuation);
            d = C8234b.d();
            return emit == d ? emit : wt2.INSTANCE;
        }
    }

    @NotNull
    public static final <T> Flow<T> a(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        return new C8679i(function2);
    }

    @NotNull
    public static final <T> Flow<T> b(T t) {
        return new C8674a(t);
    }
}
