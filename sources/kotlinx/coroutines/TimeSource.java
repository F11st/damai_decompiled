package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/TimeSource;", "", "", "currentTimeMillis", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "wrapTask", "Ltb/wt2;", "trackTask", "unTrackTask", "registerTimeLoopThread", "unregisterTimeLoopThread", "blocker", "nanos", "parkNanos", "Ljava/lang/Thread;", "thread", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public interface TimeSource {
    long currentTimeMillis();

    long nanoTime();

    void parkNanos(@NotNull Object obj, long j);

    void registerTimeLoopThread();

    void trackTask();

    void unTrackTask();

    void unpark(@NotNull Thread thread);

    void unregisterTimeLoopThread();

    @NotNull
    Runnable wrapTask(@NotNull Runnable runnable);
}
