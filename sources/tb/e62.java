package tb;

import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.tcommon.core.Pool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e62 implements Pool<ScheduledAction> {
    private final Queue<ScheduledAction> a;
    private final int b;

    public e62() {
        this(50);
    }

    @Override // com.taobao.tcommon.core.Pool
    /* renamed from: a */
    public ScheduledAction offer() {
        if (j42.c()) {
            return this.a.poll();
        }
        return null;
    }

    @Override // com.taobao.tcommon.core.Pool
    /* renamed from: b */
    public boolean recycle(ScheduledAction scheduledAction) {
        if (scheduledAction != null) {
            scheduledAction.reset();
        }
        return j42.c() && this.a.size() < this.b && this.a.offer(scheduledAction);
    }

    public e62(int i) {
        this.b = i;
        this.a = new ConcurrentLinkedQueue();
    }
}
