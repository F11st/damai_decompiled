package tb;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ep0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Typeface a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1720163302")) {
            return (Typeface) ipChange.ipc$dispatch("1720163302", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        return Typeface.createFromAsset(context.getApplicationContext().getAssets(), "damai_digit.otf");
    }

    public static void b(TextView textView, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247949792")) {
            ipChange.ipc$dispatch("1247949792", new Object[]{textView, str});
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
