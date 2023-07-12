package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.pa2;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Sequence<T> {
        final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<T> iterator() {
            return e.a(this.a);
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Iterator<T> a(@BuilderInference @NotNull Function2<? super pa2<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        Continuation<wt2> b;
        b41.i(function2, "block");
        c cVar = new c();
        b = IntrinsicsKt__IntrinsicsJvmKt.b(function2, cVar, cVar);
        cVar.f(b);
        return cVar;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Sequence<T> b(@BuilderInference @NotNull Function2<? super pa2<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        b41.i(function2, "block");
        return new a(function2);
    }
}
