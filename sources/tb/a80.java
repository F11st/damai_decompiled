package tb;

import android.os.Debug;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a80 {
    public static final String TAG = "DeviceRuntimeInfo";
    public long a;
    public long b;
    public String c;

    public static a80 a() {
        a80 a80Var = new a80();
        try {
            Runtime runtime = Runtime.getRuntime();
            a80Var.a = (runtime.totalMemory() >> 20) - (runtime.freeMemory() >> 20);
        } catch (Throwable unused) {
            a80Var.a = -1L;
        }
        try {
            a80Var.b = Debug.getPss() >> 10;
        } catch (Throwable unused2) {
            a80Var.b = -1L;
        }
        return a80Var;
    }

    public a80 b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("lc=");
        sb.append(this.c);
        sb.append("|java=");
        sb.append(this.a);
        sb.append("|pss=");
        sb.append(this.b);
        return sb.toString();
    }
}
