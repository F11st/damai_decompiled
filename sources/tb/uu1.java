package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uu1 {
    private Context a;
    private final Handler b;
    private final HandlerThread c;
    @SuppressLint({"StaticFieldLeak"})
    private static final uu1 d = new uu1();
    public static final dq1 PROCEDURE_MANAGER = new dq1();
    public static final com.taobao.monitor.procedure.e PROCEDURE_FACTORY = new com.taobao.monitor.procedure.e();

    private uu1() {
        HandlerThread handlerThread = new HandlerThread("APM-Procedure");
        this.c = handlerThread;
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
    }

    public static uu1 d() {
        return d;
    }

    public Context a() {
        return this.a;
    }

    public Handler b() {
        return this.b;
    }

    public HandlerThread c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public uu1 e(Context context) {
        this.a = context;
        return this;
    }
}
