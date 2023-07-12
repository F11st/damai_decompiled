package android.taobao.windvane.util;

import android.content.res.Resources;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DPUtil {
    public static int dip2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
