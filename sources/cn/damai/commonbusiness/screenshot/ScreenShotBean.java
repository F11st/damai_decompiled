package cn.damai.commonbusiness.screenshot;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScreenShotBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public HashMap<String, String> mScreenShotMap = new HashMap<>();

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240304822")) {
            ipChange.ipc$dispatch("-1240304822", new Object[]{this});
            return;
        }
        HashMap<String, String> hashMap = this.mScreenShotMap;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void put(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656258780")) {
            ipChange.ipc$dispatch("1656258780", new Object[]{this, str, str2});
        } else if (str != null) {
            this.mScreenShotMap.put(str, str2);
        }
    }
}
