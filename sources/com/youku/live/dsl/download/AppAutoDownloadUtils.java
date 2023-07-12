package com.youku.live.dsl.download;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AppAutoDownloadUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "AppAutoDownloadUtils";

    public static void navToPicWebView(Context context, String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826682184")) {
            ipChange.ipc$dispatch("826682184", new Object[]{context, str, str2, str3, map});
        }
    }
}
