package tb;

import android.os.Looper;
import android.util.SparseArray;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wz2 {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public String a;
        public String c;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public double l;
        public SparseArray<a> m;
        public String n;
        public double o;
        public boolean p;
        public Map<String, Object> q;
        private boolean r;
        public int k = -1;
        public long e = System.currentTimeMillis();
        public int d = wz2.d();
        public String b = wz2.a();

        public void a() {
            if (!this.r) {
                this.r = true;
                wz2.e(this);
                return;
            }
            WXLogUtils.w("WXTracing", "Event " + this.d + " has been submitted.");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        public int a;
        public long b;
        public long c = -1;
        public long d = -1;
        public long e;
    }

    public static String a() {
        String name = Thread.currentThread().getName();
        return "WeexJSBridgeThread".equals(name) ? "JSThread" : "WeeXDomThread".equals(name) ? "DOMThread" : Looper.getMainLooper() == Looper.myLooper() ? "UIThread" : name;
    }

    public static boolean b() {
        return WXEnvironment.isApkDebugable();
    }

    public static a c(String str, String str2, int i) {
        a aVar = new a();
        aVar.a = str;
        aVar.f = str2;
        aVar.d = d();
        aVar.k = i;
        return aVar;
    }

    public static int d() {
        return a.getAndIncrement();
    }

    public static synchronized void e(a aVar) {
        synchronized (wz2.class) {
            ITracingAdapter z = WXSDKManager.v().z();
            if (z != null) {
                z.submitTracingEvent(aVar);
            }
        }
    }
}
