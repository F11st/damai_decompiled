package tb;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.taobao.weex.common.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class ri1 implements ThreadFactory {
    private final AtomicInteger a;
    private final String b;
    private final int c;

    @JvmOverloads
    public ri1(@NotNull String str, int i) {
        b41.i(str, Constants.Name.PREFIX);
        this.b = str;
        this.c = i;
        this.a = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        b41.i(runnable, UploadQueueMgr.MSGTYPE_REALTIME);
        Thread thread = new Thread(runnable);
        thread.setPriority(this.c);
        thread.setName(this.b + '-' + this.a.incrementAndGet());
        return thread;
    }

    public /* synthetic */ ri1(String str, int i, int i2, k50 k50Var) {
        this(str, (i2 & 2) != 0 ? 5 : i);
    }
}
