package com.youku.live.livesdk.wkit.component.common.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UtUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static HashMap<String, String> getFinalUTArgs(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435978685")) {
            return (HashMap) ipChange.ipc$dispatch("1435978685", new Object[]{str, str2, str3, str4});
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("roomid", str);
        hashMap.put("liveid", str);
        hashMap.put("anchor-id", str3);
        hashMap.put("screenid", str2);
        hashMap.put("guid", str4);
        return hashMap;
    }

    public static HashMap<String, String> getUTArgs(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656551957")) {
            return (HashMap) ipChange.ipc$dispatch("1656551957", new Object[]{str, str2, str3, str4});
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("roomid", str);
        hashMap.put("liveid", str);
        hashMap.put("screenid", str2);
        hashMap.put("spm-name", str3);
        hashMap.put("spm-url", str4);
        hashMap.put("scm", "");
        return hashMap;
    }
}
