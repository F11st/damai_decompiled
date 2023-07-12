package tb;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cw2 {
    public static int dpToPx(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
