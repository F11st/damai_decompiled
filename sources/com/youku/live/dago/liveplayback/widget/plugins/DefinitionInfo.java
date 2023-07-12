package com.youku.live.dago.liveplayback.widget.plugins;

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
        if (AndroidInstantRuntime.support(ipChange, "1489534850")) {
            return ((Integer) ipChange.ipc$dispatch("1489534850", new Object[]{str})).intValue();
        }
        return 0;
    }

    public static String getDefinitionTextByQuality(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "166314862") ? (String) ipChange.ipc$dispatch("166314862", new Object[]{Integer.valueOf(i)}) : "";
    }

    public static List<String> getDefinitions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474064242") ? (List) ipChange.ipc$dispatch("-474064242", new Object[0]) : new ArrayList();
    }
}
