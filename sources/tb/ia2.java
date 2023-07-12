package tb;

import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ma1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ia2<E> extends ha2 {
    private final E d;
    @JvmField
    @NotNull
    public final CancellableContinuation<wt2> e;

    /* JADX WARN: Multi-variable type inference failed */
    public ia2(E e, @NotNull CancellableContinuation<? super wt2> cancellableContinuation) {
        this.d = e;
        this.e = cancellableContinuation;
    }

    @Override // tb.ha2
    public void t() {
        this.e.completeResume(cg.RESUME_TOKEN);
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return o40.a(this) + '@' + o40.b(this) + '(' + u() + ')';
    }

    @Override // tb.ha2
    public E u() {
        return this.d;
    }

    @Override // tb.ha2
    public void v(@NotNull zj<?> zjVar) {
        CancellableContinuation<wt2> cancellableContinuation = this.e;
        Throwable B = zjVar.B();
        Result.C8174a c8174a = Result.Companion;
        cancellableContinuation.resumeWith(Result.m1271constructorimpl(i32.a(B)));
    }

    @Override // tb.ha2
    @Nullable
    public kj2 w(@Nullable ma1.C9437d c9437d) {
        Object tryResume = this.e.tryResume(wt2.INSTANCE, c9437d != null ? c9437d.c : null);
        if (tryResume != null) {
            if (k40.a()) {
                if (!(tryResume == cg.RESUME_TOKEN)) {
                    throw new AssertionError();
                }
            }
            if (c9437d != null) {
                c9437d.d();
            }
            return cg.RESUME_TOKEN;
        }
        return null;
    }
}
