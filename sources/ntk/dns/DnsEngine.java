package ntk.dns;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class DnsEngine {
    private Context mAppContext;

    /* compiled from: Taobao */
    /* renamed from: ntk.dns.DnsEngine$b */
    /* loaded from: classes2.dex */
    private static class C8730b {
        private static final DnsEngine a = new DnsEngine();
    }

    static {
        System.loadLibrary("ntkhttp");
        System.loadLibrary("ntk");
    }

    private DnsEngine() {
        dns_init();
    }

    private native void dns_init();

    public static DnsEngine getInstance() {
        return C8730b.a;
    }

    public native String dumpDnsCacheInfo(String str);

    public native String dumpTcpInfo();

    public void init(@NonNull Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public native String[] lookUp(String str);
}
