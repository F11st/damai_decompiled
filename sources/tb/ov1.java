package tb;

import android.content.Context;
import cn.damai.trade.R$array;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ov1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static List<String> a;

    public static List<String> a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263052811")) {
            return (List) ipChange.ipc$dispatch("-1263052811", new Object[]{context});
        }
        List<String> list = a;
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            a = arrayList;
            arrayList.addAll(Arrays.asList(context.getResources().getStringArray(R$array.project_common_problems)));
        }
        return a;
    }
}
