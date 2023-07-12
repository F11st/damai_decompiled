package tb;

import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class qa0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990732884")) {
            ipChange.ipc$dispatch("1990732884", new Object[]{imageView});
        } else if (imageView.getTag() instanceof vr) {
            ((vr) imageView.getTag()).cancel();
        }
    }
}
