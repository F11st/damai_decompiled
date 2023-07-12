package tb;

import com.taobao.orange.OConstant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class g60 implements SimpleLock {
    @NotNull
    private final Lock a;

    public g60(@NotNull Lock lock) {
        b41.i(lock, OConstant.DIMEN_FILE_LOCK);
        this.a = lock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Lock a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        this.a.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        this.a.unlock();
    }

    public /* synthetic */ g60(Lock lock, int i, k50 k50Var) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
