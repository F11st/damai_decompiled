package tb;

import android.app.Activity;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sy2 {
    public static boolean a(Activity activity, View view) {
        if (activity == null || view == null) {
            return false;
        }
        View decorView = (activity.getWindow() == null || activity.getWindow().getDecorView() == null) ? null : activity.getWindow().getDecorView();
        View view2 = view;
        while (decorView != view) {
            if (view2.getParent() == null || !(view2.getParent() instanceof View)) {
                view2 = null;
                continue;
            } else {
                view2 = (View) view2.getParent();
                continue;
            }
            if (view2 == null) {
                return false;
            }
        }
        return true;
    }
}
