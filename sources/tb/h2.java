package tb;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.C8688m;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class h2<S extends j2<?>> {
    @Nullable
    private S[] a;
    private int b;
    private int c;
    private MutableStateFlow<Integer> d;

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final S a() {
        S s;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] sArr = this.a;
            if (sArr == null) {
                sArr = c(2);
                this.a = sArr;
            } else if (this.b >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                b41.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.a = (S[]) ((j2[]) copyOf);
                sArr = (S[]) ((j2[]) copyOf);
            }
            int i = this.c;
            do {
                s = sArr[i];
                if (s == null) {
                    s = b();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                if (s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s.a(this));
            this.c = i;
            this.b++;
            mutableStateFlow = this.d;
        }
        if (mutableStateFlow != null) {
            C8688m.e(mutableStateFlow, 1);
        }
        return s;
    }

    @NotNull
    protected abstract S b();

    @NotNull
    protected abstract S[] c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(@NotNull S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i;
        Continuation<Unit>[] b;
        synchronized (this) {
            int i2 = this.b - 1;
            this.b = i2;
            mutableStateFlow = this.d;
            if (i2 == 0) {
                this.c = 0;
            }
            if (s != null) {
                b = s.b(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (Continuation<Unit> continuation : b) {
            if (continuation != null) {
                wt2 wt2Var = wt2.INSTANCE;
                Result.C8174a c8174a = Result.Companion;
                continuation.resumeWith(Result.m1271constructorimpl(wt2Var));
            }
        }
        if (mutableStateFlow != null) {
            C8688m.e(mutableStateFlow, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final S[] e() {
        return this.a;
    }

    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            mutableStateFlow = this.d;
            if (mutableStateFlow == null) {
                mutableStateFlow = C8688m.a(Integer.valueOf(this.b));
                this.d = mutableStateFlow;
            }
        }
        return mutableStateFlow;
    }
}
