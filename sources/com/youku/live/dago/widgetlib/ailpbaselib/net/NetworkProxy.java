package com.youku.live.dago.widgetlib.ailpbaselib.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.AILPMtopListener;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.GeneralCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.MtopUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile NetworkProxy instance;

    public static NetworkProxy getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199774309")) {
            return (NetworkProxy) ipChange.ipc$dispatch("-1199774309", new Object[0]);
        }
        if (instance == null) {
            synchronized (NetworkProxy.class) {
                if (instance == null) {
                    instance = new NetworkProxy();
                }
            }
        }
        return instance;
    }

    public static void request(String str, Map<String, String> map, boolean z, AILPMtopListener aILPMtopListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74488553")) {
            ipChange.ipc$dispatch("-74488553", new Object[]{str, map, Boolean.valueOf(z), aILPMtopListener});
        } else {
            getInstance().requestData(str, "", map, z, aILPMtopListener);
        }
    }

    private void requestData(String str, String str2, Map<String, String> map, boolean z, AILPMtopListener aILPMtopListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662729385")) {
            ipChange.ipc$dispatch("-662729385", new Object[]{this, str, str2, map, Boolean.valueOf(z), aILPMtopListener});
        } else {
            MtopUtils.request(str, str2, map, z, aILPMtopListener);
        }
    }

    public static void requestGeneral(String str, Map<String, String> map, boolean z, GeneralCallback<?> generalCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498192158")) {
            ipChange.ipc$dispatch("498192158", new Object[]{str, map, Boolean.valueOf(z), generalCallback});
        } else {
            MtopUtils.request(str, "", map, z, generalCallback);
        }
    }

    public static void request(String str, String str2, Map<String, String> map, boolean z, AILPMtopListener aILPMtopListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179712243")) {
            ipChange.ipc$dispatch("-1179712243", new Object[]{str, str2, map, Boolean.valueOf(z), aILPMtopListener});
        } else {
            getInstance().requestData(str, str2, map, z, aILPMtopListener);
        }
    }

    public static void requestGeneral(String str, String str2, Map<String, String> map, boolean z, GeneralCallback<?> generalCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575619608")) {
            ipChange.ipc$dispatch("-575619608", new Object[]{str, str2, map, Boolean.valueOf(z), generalCallback});
        } else {
            MtopUtils.request(str, str2, map, z, generalCallback);
        }
    }
}
