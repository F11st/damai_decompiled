package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fu0 {
    @SuppressLint({"StaticFieldLeak"})
    private static final fu0 d = new fu0();
    private Context a;
    private Handler b;
    private String c;

    private fu0() {
    }

    public static fu0 e() {
        return d;
    }

    public Context a() {
        return this.a;
    }

    public Handler b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Handler d() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("APM-Monitor-Biz");
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
        }
        return this.b;
    }

    public fu0 f(Context context) {
        this.a = context;
        return this;
    }

    public void g(Handler handler) {
        this.b = handler;
    }

    public fu0 h(String str) {
        this.c = str;
        return this;
    }
}
