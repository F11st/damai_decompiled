package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.threadpool.IExecutorServiceFactory;
import com.google.common.util.concurrent.ListeningExecutorService;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class qg0 {
    private IExecutorServiceFactory a;
    private ListeningExecutorService b;
    private ListeningExecutorService c;
    private ListeningExecutorService d;
    private ListeningExecutorService e;

    /* compiled from: Taobao */
    /* renamed from: tb.qg0$b */
    /* loaded from: classes5.dex */
    private static class C9604b {
        private static final qg0 a = new qg0();
    }

    @NonNull
    public static qg0 c() {
        return C9604b.a;
    }

    public ListeningExecutorService a() {
        if (this.b == null) {
            this.b = this.a.createCpuExecutorService(og0.c().a());
        }
        return this.b;
    }

    public ListeningExecutorService b() {
        if (this.c == null) {
            this.c = this.a.createIOExecutorService(og0.c().b());
        }
        return this.c;
    }

    public ListeningExecutorService d() {
        if (this.d == null) {
            this.d = this.a.createNormalExecutorService(og0.c().d());
        }
        return this.d;
    }

    public ListeningExecutorService e() {
        if (this.e == null) {
            this.e = this.a.createRpcExecutorService(og0.c().e());
        }
        return this.e;
    }

    private qg0() {
        this.a = new pg0();
    }
}
