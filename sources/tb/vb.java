package tb;

import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.ut.mini.module.plugin.UTPluginMgr;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class vb {
    private static jp2 a = new jp2();
    private static tp b = new tp();
    private static vb c = new vb();

    private vb() {
    }

    public static vb c() {
        return c;
    }

    public void a(String str, Object obj) {
        b.a(str, obj);
    }

    public void b(String str, String str2) {
        a.a(str, str2);
    }

    public void d() {
        UTPluginMgr.getInstance().registerPlugin(a);
        MotuCrashReporter.getInstance().setCrashCaughtListener(b);
    }
}
