package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class as {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int NFC_READ_OVERTIME = 1000;

    public static void a(int i, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298043520")) {
            ipChange.ipc$dispatch("-1298043520", new Object[]{Integer.valueOf(i), map});
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        map.put("title", "芯片读取失败");
                        map.put("subTitle", "请将票紧贴手机，不要移动，并重试");
                        return;
                    } else if (i != 5) {
                        return;
                    }
                }
            }
            map.put("title", "验真失败，该票可能存在风险");
            return;
        }
        map.put("title", "芯片读取失败");
    }
}
