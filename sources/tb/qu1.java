package tb;

import com.taobao.update.datasource.PatchRunnable;
import com.taobao.update.datasource.Task;
import com.taobao.update.types.PatchType;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qu1 implements Comparable<qu1>, Task {
    private final a a;
    private PatchType b;
    private boolean c;
    private String d;
    private PatchRunnable e;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements ThreadFactory {
        private AtomicInteger a = new AtomicInteger();
        private PatchType b;

        public a(PatchType patchType) {
            this.b = patchType;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.b.getKey() + "-thread-" + this.a.incrementAndGet());
        }
    }

    public qu1(PatchType patchType, PatchRunnable patchRunnable, String str, boolean z) {
        this.e = patchRunnable;
        this.b = patchType;
        this.d = str;
        this.c = z;
        this.a = new a(patchType);
    }

    @Override // com.taobao.update.datasource.Task
    public void asyncRun() {
        this.a.newThread(this.e).start();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof qu1) && this.b == ((qu1) obj).b;
    }

    public String from() {
        return this.d;
    }

    public PatchType getPatchType() {
        return this.b;
    }

    public PatchRunnable getRunnable() {
        return this.e;
    }

    public int hashCode() {
        PatchType patchType = this.b;
        if (patchType != null) {
            return patchType.hashCode();
        }
        return 0;
    }

    public boolean isBackground() {
        return this.c;
    }

    @Override // com.taobao.update.datasource.Task
    public void syncRun() {
        Thread newThread = this.a.newThread(this.e);
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(qu1 qu1Var) {
        return this.b.getPriority() - qu1Var.b.getPriority();
    }
}
