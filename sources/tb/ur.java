package tb;

import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ur {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Typeface a;
    private static WeakHashMap<View, Void> b = new WeakHashMap<>();

    public static Typeface a(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113779620")) {
            return (Typeface) ipChange.ipc$dispatch("-1113779620", new Object[]{view});
        }
        if (a == null) {
            try {
                a = Typeface.createFromAsset(view.getContext().getApplicationContext().getAssets(), "damai_iconfont.ttf");
            } catch (Exception e) {
                Log.w("StackTrace", e);
            }
        }
        b.put(view, null);
        return a;
    }

    public static void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107137715")) {
            ipChange.ipc$dispatch("-2107137715", new Object[]{view});
            return;
        }
        b.remove(view);
        if (b.size() == 0) {
            a = null;
        }
    }
}
