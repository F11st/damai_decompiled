package tb;

import com.taobao.downloader.adpater.Monitor;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nh1 {

    /* compiled from: Taobao */
    /* renamed from: tb.nh1$a */
    /* loaded from: classes11.dex */
    public static class C9474a {
        public URL a;
        public long b;
        public boolean c;
        public boolean d;
        public long e;
        public long f;
        public double g;
        public String h;
        public long i;
        public String j;
        public String k;

        public C9474a() {
            System.currentTimeMillis();
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        Monitor monitor = um.c;
        if (monitor != null) {
            monitor.monitorFail("download-sdk", str, str2, str3, str4);
        }
    }

    public static void b(String str, String str2) {
        try {
            Monitor monitor = um.c;
            if (monitor == null || !(monitor instanceof Monitor)) {
                return;
            }
            monitor.monitorSuccess("download-sdk", str, str2);
        } catch (Throwable unused) {
        }
    }
}
