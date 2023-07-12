package tb;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class dp0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(TextView textView, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153989817")) {
            ipChange.ipc$dispatch("153989817", new Object[]{textView, str});
        } else if (textView == null || TextUtils.isEmpty(str)) {
        } else {
            if ("URWDIN-Medium".equals(str)) {
                str2 = "damai_digit.otf";
            } else {
                str2 = "iconfont".equals(str) ? "damai_iconfont.ttf" : "";
            }
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getApplicationContext().getAssets(), str2));
        }
    }
}
