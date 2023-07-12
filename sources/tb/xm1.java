package tb;

import com.alibaba.android.onescheduler.utils.OneSchedulerException;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xm1 {
    public static void a(String str) {
        throw new OneSchedulerException(str);
    }

    public static void b(String str) {
        if (vm1.a) {
            throw new OneSchedulerException(str);
        }
    }
}
