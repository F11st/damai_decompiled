package tb;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ob {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(View view, @IdRes int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027212587")) {
            ipChange.ipc$dispatch("2027212587", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (view == null || view.findViewById(i) == null) {
        } else {
            ((TextView) view.findViewById(i)).setTextColor(i2);
        }
    }

    public static void b(View view, @IdRes int i, SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1456085242")) {
            ipChange.ipc$dispatch("-1456085242", new Object[]{view, Integer.valueOf(i), spannableString});
        } else if (view == null || view.findViewById(i) == null || spannableString == null) {
        } else {
            ((TextView) view.findViewById(i)).setText(spannableString);
        }
    }

    public static void c(View view, @IdRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94955634")) {
            ipChange.ipc$dispatch("-94955634", new Object[]{view, Integer.valueOf(i), str});
        } else if (view == null || view.findViewById(i) == null || wh2.j(str)) {
        } else {
            ((TextView) view.findViewById(i)).setText(str.trim());
        }
    }
}
