package com.youku.live.dago.widgetlib.ailpbaselib.net.mtop;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MtopUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> void request(String str, Map<String, String> map, boolean z, GeneralCallback<?> generalCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1146007294")) {
            ipChange.ipc$dispatch("-1146007294", new Object[]{str, map, Boolean.valueOf(z), generalCallback});
        } else {
            MtopHelper.getInstance().doRequest(str, "", map, z, generalCallback);
        }
    }

    public static void request(String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207205115")) {
            ipChange.ipc$dispatch("207205115", new Object[]{str, map, Boolean.valueOf(z), iRemoteBaseListener});
        } else {
            MtopHelper.getInstance().doRequest(str, "", map, z, iRemoteBaseListener);
        }
    }

    public static <T> void request(String str, String str2, Map<String, String> map, boolean z, GeneralCallback<?> generalCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594814772")) {
            ipChange.ipc$dispatch("-1594814772", new Object[]{str, str2, map, Boolean.valueOf(z), generalCallback});
        } else {
            MtopHelper.getInstance().doRequest(str, str2, map, z, generalCallback);
        }
    }

    public static void request(String str, String str2, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459437583")) {
            ipChange.ipc$dispatch("-1459437583", new Object[]{str, str2, map, Boolean.valueOf(z), iRemoteBaseListener});
        } else {
            MtopHelper.getInstance().doRequest(str, str2, map, z, iRemoteBaseListener);
        }
    }
}
