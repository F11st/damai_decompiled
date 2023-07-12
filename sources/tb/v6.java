package tb;

import android.content.SharedPreferences;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class v6 extends s1 {

    /* compiled from: Taobao */
    /* renamed from: tb.v6$a */
    /* loaded from: classes11.dex */
    public static class C9808a {
        public static long a() {
            return fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).getLong("lastStartProcessTime", -1L);
        }

        public static void b(long j) {
            SharedPreferences.Editor edit = fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).edit();
            edit.putLong("lastStartProcessTime", j);
            edit.apply();
        }
    }

    public void a(boolean z) {
        this.a.c("isFirstLaunch", z);
    }

    public void b(boolean z) {
        this.a.c("isFullNewInstall", z);
    }

    public void c(long j) {
        this.a.e("lastStartProcessTime", j);
    }

    public void d(String str) {
        if (LauncherProcessor.WARM.equals(str)) {
            str = LauncherProcessor.HOT;
        }
        this.a.f("launchType", str);
    }

    public void e(long j) {
        this.a.e("startAppOnCreateSystemClockTime", j);
    }

    public void f(long j) {
        this.a.e("startAppOnCreateSystemTime", j);
    }

    public void g(long j) {
        this.a.e("startProcessSystemClockTime", j);
    }

    public void h(long j) {
        this.a.e("startProcessSystemTime", j);
        C9808a.b(j);
    }
}
