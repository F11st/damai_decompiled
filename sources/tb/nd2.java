package tb;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class nd2 {
    public static int a(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) (context.getResources().getDisplayMetrics().density * f);
    }
}
