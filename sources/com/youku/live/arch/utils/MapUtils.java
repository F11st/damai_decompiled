package com.youku.live.arch.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MapUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, String> build(Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788374844")) {
            return (Map) ipChange.ipc$dispatch("-788374844", new Object[]{map, str, str2});
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, str2);
        return map;
    }
}
