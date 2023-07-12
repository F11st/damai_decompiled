package tb;

import com.alibaba.appmonitor.pool.Reusable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class k32<T extends Reusable> {
    private static AtomicLong e = new AtomicLong(0);
    private static AtomicLong f = new AtomicLong(0);
    private AtomicLong a = new AtomicLong(0);
    private AtomicLong b = new AtomicLong(0);
    private ConcurrentLinkedQueue<T> c = new ConcurrentLinkedQueue<>();
    private Set<Integer> d = new HashSet();

    public void a(T t) {
        t.clean();
        if (this.c.size() < 20) {
            synchronized (this.d) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.d.contains(Integer.valueOf(identityHashCode))) {
                    this.d.add(Integer.valueOf(identityHashCode));
                    this.c.offer(t);
                }
            }
        }
    }

    public T b() {
        e.getAndIncrement();
        this.a.getAndIncrement();
        T poll = this.c.poll();
        if (poll != null) {
            this.d.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.b.getAndIncrement();
            f.getAndIncrement();
        }
        return poll;
    }
}
