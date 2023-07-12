package com.youku.live.dago.liveplayback.widget.plugins.quality;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefinitionInfo {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int getDefinitionQualityByString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "126857618")) {
            return ((Integer) ipChange.ipc$dispatch("126857618", new Object[]{str})).intValue();
        }
        return 0;
    }

    public static String getDefinitionTextByQuality(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1980352130") ? (String) ipChange.ipc$dispatch("-1980352130", new Object[]{Integer.valueOf(i)}) : "";
    }

    public static List<String> getDefinitions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "766936702") ? (List) ipChange.ipc$dispatch("766936702", new Object[0]) : new ArrayList();
    }
}
