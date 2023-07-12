package tb;

import com.taobao.rxm.common.Releasable;
import com.taobao.tcommon.core.Pool;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l60<OUT, NEXT_OUT extends Releasable, CONTEXT extends a22> implements Pool<gh<OUT, NEXT_OUT, CONTEXT>> {
    private final Queue<gh<OUT, NEXT_OUT, CONTEXT>> a;
    private final int b;

    public l60() {
        this(15);
    }

    @Override // com.taobao.tcommon.core.Pool
    /* renamed from: a */
    public gh<OUT, NEXT_OUT, CONTEXT> offer() {
        if (j42.c()) {
            return this.a.poll();
        }
        return null;
    }

    @Override // com.taobao.tcommon.core.Pool
    /* renamed from: b */
    public boolean recycle(gh<OUT, NEXT_OUT, CONTEXT> ghVar) {
        if (ghVar != null) {
            ghVar.c();
        }
        return j42.c() && this.a.size() < this.b && this.a.offer(ghVar);
    }

    public l60(int i) {
        this.b = i;
        this.a = new ConcurrentLinkedQueue();
    }
}
