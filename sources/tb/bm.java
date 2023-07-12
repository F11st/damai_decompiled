package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class bm {
    @JvmField
    @Nullable
    public final Object a;
    @JvmField
    @NotNull
    public final Function1<Throwable, wt2> b;

    /* JADX WARN: Multi-variable type inference failed */
    public bm(@Nullable Object obj, @NotNull Function1<? super Throwable, wt2> function1) {
        this.a = obj;
        this.b = function1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof bm) {
                bm bmVar = (bm) obj;
                return b41.d(this.a, bmVar.a) && b41.d(this.b, bmVar.b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Function1<Throwable, wt2> function1 = this.b;
        return hashCode + (function1 != null ? function1.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + jn1.BRACKET_END_STR;
    }
}
