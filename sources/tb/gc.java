package tb;

import android.text.TextUtils;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class gc {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414387907")) {
            ipChange.ipc$dispatch("-1414387907", new Object[]{textView, str});
        } else if (textView == null) {
        } else {
            if (!TextUtils.isEmpty(str)) {
                textView.setVisibility(0);
                textView.setText(str);
                return;
            }
            textView.setText("");
        }
    }
}
