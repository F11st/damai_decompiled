package tb;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ya2 {
    private static AtomicInteger a = new AtomicInteger();

    public static String a(String str) {
        if (a.get() == Integer.MAX_VALUE) {
            a.set(0);
        }
        if (!TextUtils.isEmpty(str)) {
            return zh2.e(str, ".AWCN", String.valueOf(a.incrementAndGet()));
        }
        return zh2.d("AWCN", String.valueOf(a.incrementAndGet()));
    }
}
