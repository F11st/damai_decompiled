package com.youku.live.widgets.widgets.orientation;

import android.content.res.Configuration;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IEngineInstance;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class OrientationHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ORIENTATION_AUTO = "auto";
    public static final String ORIENTATION_CHANGE_EVENT = "OrientationChange";
    public static final String ORIENTATION_KEY = "orientation";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
    public static final String ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
    public static String currentAngleORIENTATION;

    private static void broadcastOrientation(IEngineInstance iEngineInstance, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991718194")) {
            ipChange.ipc$dispatch("991718194", new Object[]{iEngineInstance, map});
        } else if (iEngineInstance != null) {
            iEngineInstance.asyncPutData("OrientationChange", map);
        }
    }

    public static void setScreenType(IEngineInstance iEngineInstance, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304960996")) {
            ipChange.ipc$dispatch("304960996", new Object[]{iEngineInstance, configuration});
            return;
        }
        int i = configuration.orientation;
        if (currentAngleORIENTATION == null) {
            currentAngleORIENTATION = i == 1 ? "portrait" : "landscapeLeft";
        }
        HashMap hashMap = new HashMap();
        if (i == 1) {
            if (!currentAngleORIENTATION.equals("portrait") && !currentAngleORIENTATION.equals("portraitUpsideDown")) {
                currentAngleORIENTATION = "portrait";
                hashMap.put("orientation", "portrait");
            } else {
                hashMap.put("orientation", currentAngleORIENTATION);
            }
            broadcastOrientation(iEngineInstance, hashMap);
            return;
        }
        if (!currentAngleORIENTATION.equals("landscapeRight") && !currentAngleORIENTATION.equals("landscapeLeft")) {
            currentAngleORIENTATION = "landscapeLeft";
            hashMap.put("orientation", "landscapeLeft");
        } else {
            hashMap.put("orientation", currentAngleORIENTATION);
        }
        broadcastOrientation(iEngineInstance, hashMap);
    }
}
