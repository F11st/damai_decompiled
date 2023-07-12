package tb;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class l62 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-419970544") ? ((Integer) ipChange.ipc$dispatch("-419970544", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "113043404") ? (DisplayMetrics) ipChange.ipc$dispatch("113043404", new Object[]{context}) : context.getResources().getDisplayMetrics();
    }

    public static DisplayMetrics c(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395806651")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("395806651", new Object[]{activity});
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }
}
