package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ag;
import tb.b41;
import tb.jn1;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class i {
    @JvmField
    @Nullable
    public final Object a;
    @JvmField
    @Nullable
    public final ag b;
    @JvmField
    @Nullable
    public final Function1<Throwable, wt2> c;
    @JvmField
    @Nullable
    public final Object d;
    @JvmField
    @Nullable
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@Nullable Object obj, @Nullable ag agVar, @Nullable Function1<? super Throwable, wt2> function1, @Nullable Object obj2, @Nullable Throwable th) {
        this.a = obj;
        this.b = agVar;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    public static /* synthetic */ i b(i iVar, Object obj, ag agVar, Function1 function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = iVar.a;
        }
        if ((i & 2) != 0) {
            agVar = iVar.b;
        }
        ag agVar2 = agVar;
        Function1<Throwable, wt2> function12 = function1;
        if ((i & 4) != 0) {
            function12 = iVar.c;
        }
        Function1 function13 = function12;
        if ((i & 8) != 0) {
            obj2 = iVar.d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = iVar.e;
        }
        return iVar.a(obj, agVar2, function13, obj4, th);
    }

    @NotNull
    public final i a(@Nullable Object obj, @Nullable ag agVar, @Nullable Function1<? super Throwable, wt2> function1, @Nullable Object obj2, @Nullable Throwable th) {
        return new i(obj, agVar, function1, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl, @NotNull Throwable th) {
        ag agVar = this.b;
        if (agVar != null) {
            cancellableContinuationImpl.callCancelHandler(agVar, th);
        }
        Function1<Throwable, wt2> function1 = this.c;
        if (function1 != null) {
            cancellableContinuationImpl.callOnCancellation(function1, th);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                return b41.d(this.a, iVar.a) && b41.d(this.b, iVar.b) && b41.d(this.c, iVar.c) && b41.d(this.d, iVar.d) && b41.d(this.e, iVar.e);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        ag agVar = this.b;
        int hashCode2 = (hashCode + (agVar != null ? agVar.hashCode() : 0)) * 31;
        Function1<Throwable, wt2> function1 = this.c;
        int hashCode3 = (hashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Throwable th = this.e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + jn1.BRACKET_END_STR;
    }

    public /* synthetic */ i(Object obj, ag agVar, Function1 function1, Object obj2, Throwable th, int i, k50 k50Var) {
        this(obj, (i & 2) != 0 ? null : agVar, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
