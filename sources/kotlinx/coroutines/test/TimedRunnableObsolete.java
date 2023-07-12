package kotlinx.coroutines.test;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;
import tb.sm2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R(\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/coroutines/test/TimedRunnableObsolete;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "Ltb/wt2;", "run", "other", "", "compareTo", "", "toString", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Ljava/lang/Runnable;", "", AdUtConstants.XAD_UT_ARG_COUNT, "J", "time", "Ltb/sm2;", "heap", "Ltb/sm2;", "getHeap", "()Ltb/sm2;", "setHeap", "(Ltb/sm2;)V", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes11.dex */
final class TimedRunnableObsolete implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode {
    private final long count;
    @Nullable
    private sm2<?> heap;
    private int index;
    private final Runnable run;
    @JvmField
    public final long time;

    public TimedRunnableObsolete(@NotNull Runnable runnable, long j, long j2) {
        this.run = runnable;
        this.count = j;
        this.time = j2;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    @Nullable
    public sm2<?> getHeap() {
        return this.heap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.run.run();
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(@Nullable sm2<?> sm2Var) {
        this.heap = sm2Var;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    @NotNull
    public String toString() {
        return "TimedRunnable(time=" + this.time + ", run=" + this.run + ')';
    }

    public /* synthetic */ TimedRunnableObsolete(Runnable runnable, long j, long j2, int i, k50 k50Var) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull TimedRunnableObsolete timedRunnableObsolete) {
        long j = this.time;
        long j2 = timedRunnableObsolete.time;
        if (j == j2) {
            j = this.count;
            j2 = timedRunnableObsolete.count;
        }
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }
}
