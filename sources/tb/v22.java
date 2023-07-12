package tb;

import com.alibaba.responsive.IConfig;
import com.alibaba.responsive.IDisableOritationActivity;
import com.alibaba.responsive.ISpanCountProcess;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class v22 {
    private static volatile v22 d;
    private ISpanCountProcess a;
    private IDisableOritationActivity b;
    private IConfig c;

    public static v22 c() {
        if (d == null) {
            synchronized (v22.class) {
                if (d == null) {
                    d = new v22();
                }
            }
        }
        return d;
    }

    public IConfig a() {
        return this.c;
    }

    public IDisableOritationActivity b() {
        return this.b;
    }

    public ISpanCountProcess d() {
        return this.a;
    }
}
