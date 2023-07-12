package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.threadpool.PriorityFutureTask;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class mu1 implements Comparator<Runnable> {
    private int b(@NonNull PriorityFutureTask priorityFutureTask, @NonNull PriorityFutureTask priorityFutureTask2) {
        Priority priority = priorityFutureTask.getPriority();
        Priority priority2 = priorityFutureTask2.getPriority();
        long prioritySequence = priorityFutureTask.getPrioritySequence();
        long prioritySequence2 = priorityFutureTask2.getPrioritySequence();
        if (priority != null || priority2 != null) {
            if (priority == null) {
                return -1;
            }
            if (priority2 == null) {
                return 1;
            }
            int compareTo = priority.compareTo(priority2) * (-1);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return (int) (prioritySequence - prioritySequence2);
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Runnable runnable, Runnable runnable2) {
        if ((runnable instanceof PriorityFutureTask) && (runnable2 instanceof PriorityFutureTask)) {
            PriorityFutureTask priorityFutureTask = (PriorityFutureTask) runnable;
            Priority goupPriority = priorityFutureTask.getGoupPriority();
            PriorityFutureTask priorityFutureTask2 = (PriorityFutureTask) runnable2;
            Priority goupPriority2 = priorityFutureTask2.getGoupPriority();
            if (goupPriority == null && goupPriority2 == null) {
                return b(priorityFutureTask, priorityFutureTask2);
            }
            if (goupPriority == null) {
                return -1;
            }
            if (goupPriority2 == null) {
                return 1;
            }
            int compareTo = goupPriority.compareTo(goupPriority2) * (-1);
            return compareTo == 0 ? b(priorityFutureTask, priorityFutureTask2) : compareTo;
        }
        throw new RuntimeException("Runnable is not CustomFutureTask");
    }
}
