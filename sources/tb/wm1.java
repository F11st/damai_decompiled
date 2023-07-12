package tb;

import com.alibaba.android.onescheduler.ILogger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class wm1 {
    private static ILogger a = new z50();

    public static void a(String str, Object... objArr) {
        a.e("OneScheduler", String.format(str, objArr));
    }
}
