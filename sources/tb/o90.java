package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class o90 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "510319745") ? (String) ipChange.ipc$dispatch("510319745", new Object[]{str}) : TextUtils.isEmpty(str) ? z20.c() : str;
    }

    public static boolean b(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1963382265") ? ((Boolean) ipChange.ipc$dispatch("1963382265", new Object[]{collection})).booleanValue() : collection == null || collection.size() == 0;
    }

    public static void c(int i, List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258989984")) {
            ipChange.ipc$dispatch("-258989984", new Object[]{Integer.valueOf(i), list});
        } else if (!b(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).pos = i;
                i++;
            }
        }
    }
}
