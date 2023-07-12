package tb;

import android.util.Log;
import com.taobao.android.modular.LogProvider;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rc1 {
    private static final LogProvider a;
    private static volatile LogProvider b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class b implements LogProvider {
        private b() {
        }

        @Override // com.taobao.android.modular.LogProvider
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.taobao.android.modular.LogProvider
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.taobao.android.modular.LogProvider
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.taobao.android.modular.LogProvider
        public void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.taobao.android.modular.LogProvider
        public void w(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    }

    static {
        b bVar = new b();
        a = bVar;
        b = bVar;
    }

    public static void a(String str, String str2) {
        b.e(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        b.e(str, str2, th);
    }

    public static void c(String str, String str2) {
        b.w(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        b.w(str, str2, th);
    }
}
