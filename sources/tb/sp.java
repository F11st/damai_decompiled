package tb;

import com.alibaba.analytics.core.selfmonitor.CrashListener;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class sp implements Thread.UncaughtExceptionHandler {
    private static sp c = new sp();
    private Thread.UncaughtExceptionHandler a;
    private List<CrashListener> b = Collections.synchronizedList(new ArrayList());

    public static sp b() {
        return c;
    }

    public void a(CrashListener crashListener) {
        this.b.add(crashListener);
    }

    public void c() {
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        for (int i = 0; i < this.b.size(); i++) {
            try {
                this.b.get(i).onCrash(thread, th);
            } catch (Throwable unused) {
                uncaughtExceptionHandler = this.a;
                if (uncaughtExceptionHandler == null) {
                    return;
                }
            }
        }
        uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
